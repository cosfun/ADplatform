package com.adplatform.adx.core;

import com.adplatform.adx.core.model.AdProvider;
import com.adplatform.adx.core.model.ResponseContainer;
import com.adplatform.adx.utils.RestUtils;
import com.adplatform.common.rtb.model.BidRequest;
import com.adplatform.common.rtb.model.BidResponse;
import com.adplatform.common.rtb.model.response.Bid;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.concurrent.Callable;


public class DemandBroker  implements Callable<ResponseContainer>{



    private AdProvider adProvider;

    private BidRequest bidRequest;



    public DemandBroker(AdProvider adProvider,BidRequest bidRequest){
        this.adProvider=adProvider;
        this.bidRequest=bidRequest;
    }


    @Override
    public ResponseContainer call() throws Exception {
        ResponseContainer response=RestUtils.restTemplate.postForObject(adProvider.getUrl(),bidRequest, ResponseContainer.class);
        return response;
    }
}
