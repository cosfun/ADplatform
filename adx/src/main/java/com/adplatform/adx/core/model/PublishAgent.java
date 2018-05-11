package com.adplatform.adx.core.model;

import com.adplatform.adx.core.exchange.BidExchange;

public class PublishAgent {
    BidExchange bidExchange=new BidExchange();

    public BidExchange getBidExchange() {
        return bidExchange;
    }

    public void setBidExchange(BidExchange bidExchange) {
        this.bidExchange = bidExchange;
    }
}
