package com.adplatform.adx.core.model;


import com.adplatform.common.rtb.model.BidResponse;

public class ResponseContainer {
    private AdProvider adProvider;

    private BidResponse bidResponse;


    public AdProvider getAdProvider() {
        return adProvider;
    }

    public void setAdProvider(AdProvider adProvider) {
        this.adProvider = adProvider;
    }

    public BidResponse getBidResponse() {
        return bidResponse;
    }

    public void setBidResponse(BidResponse bidResponse) {
        this.bidResponse = bidResponse;
    }
}
