package com.adplatform.adx.core;

import com.adplatform.adx.core.exchange.Auction;
import com.adplatform.adx.core.exchange.DemandExecutorServiceFacade;
import com.adplatform.adx.core.model.*;
import com.adplatform.adx.dao.DspUserMapper;
import com.adplatform.adx.pojo.DspUser;
import com.adplatform.common.rtb.model.BidRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class DemandService implements Callable<AdProviderReader>{



    private BidRequest bidRequest;

    private PublishAgent publishAgent;

    private List<DspUser> dspUsers;

    public DemandService(List<DspUser> dspUsers, PublishAgent publishAgent){

        this.dspUsers=dspUsers;

        this.publishAgent=publishAgent;
    }



    @Override
    public AdProviderReader call() throws Exception {
        AdProviderReader adProviderReader=null;



        List<DemandBroker> demandBrokers=createBroker();
        //
        List<Future<ResponseContainer>> futures = DemandExecutorServiceFacade.instance.invokeAll(demandBrokers);

        futures.parallelStream().filter(Objects::nonNull).forEach(future->{
            try {
                System.out.println("exe ");
                final ResponseContainer responseContainer = future.get();
                System.out.println("responseContainer.getAdProvider():"+responseContainer.getAdProvider());
                System.out.println("responseContainer.getBidResponse()"+responseContainer.getBidResponse());
                publishAgent.getBidExchange().setBidResponse(responseContainer.getAdProvider(), responseContainer.getBidResponse());
            } catch (Exception e) {
                System.out.println(DemandService.class.getSimpleName()+e.toString());
            }
        });

        adProviderReader= Auction.auctioneer(publishAgent.getBidExchange());


        return adProviderReader;
    }

    private List<DemandBroker> createBroker(){
        List<DemandBroker> list = new ArrayList<>();

        //建立bidRequest
        BidRequest bidRequest = BidRequestBuilder.build(publishAgent);

        for(DspUser dspUser:dspUsers) {

            DemandBroker demandBroker = new DemandBroker(new AdProvider(dspUser), bidRequest);

            list.add(demandBroker);
        }
        return list;
    }


}
