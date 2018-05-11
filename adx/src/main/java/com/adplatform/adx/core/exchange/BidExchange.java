package com.adplatform.adx.core.exchange;

import com.adplatform.adx.core.model.AdProvider;
import com.adplatform.common.rtb.model.BidResponse;

import java.util.HashMap;
import java.util.Map;

public class BidExchange {


    private final Map<AdProvider, BidResponse> bidResponseMap;

    public BidExchange(){
        bidResponseMap = new HashMap<>();
    }

    public void setBidResponse(AdProvider adProvider,BidResponse bidResponse) {
        this.bidResponseMap.put(adProvider, bidResponse);
    }

    public Map<AdProvider, BidResponse> getBidResponseMap() {
        return bidResponseMap;
    }
}
