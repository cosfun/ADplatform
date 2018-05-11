package com.adplatform.adx.controller;


import com.adplatform.adx.core.exchange.ChannalFactory;
import com.adplatform.adx.core.exchange.ExchangeExecutorServiceFacade;
import com.adplatform.adx.core.exchange.ExchangeService;
import com.adplatform.adx.core.model.AdProviderReader;
import com.adplatform.adx.core.model.PublishAgent;
import com.adplatform.adx.dao.DspUserMapper;
import com.adplatform.adx.pojo.DspUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RequestMapping(value = "/adx" )
@RestController()
public class Adx {
    @Autowired
    DspUserMapper dspUserMapper;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("view")
    public String view(Long id, Long token, Integer adId) {
        try {

            PublishAgent publishAgent = new PublishAgent();
            //
            System.out.println("start");
            List<Callable<AdProviderReader>> callables = ChannalFactory.create(dspUserMapper.findAll(),publishAgent);
            List<Future<AdProviderReader>> futures = ExchangeExecutorServiceFacade.instance.invokeAll(callables);
            Future<AdProviderReader> winnerFuture = futures.stream().reduce(ExchangeService::validate).orElse(null);

            if(winnerFuture!=null){
                try {
                    AdProviderReader winner=winnerFuture.get();
                    System.out.println("win! price:"+winner.getPrice());
                    return "success win price:"+winner.getPrice();
                } catch (ExecutionException | CancellationException e) {
                    //e.printStackTrace();
                    System.out.println("error:"+e.getMessage());
                    return "false";
                }

            }
            System.out.println("no win");
            return "false";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "false";
    }

    //private load
}
