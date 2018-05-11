package com.adplatform.adx.core;

import com.adplatform.adx.core.model.PublishAgent;
import com.adplatform.common.rtb.model.BidRequest;
import org.apache.catalina.servlet4preview.http.PushBuilder;

public class BidRequestBuilder {

    public static BidRequest build(PublishAgent publishAgent){
        BidRequest bidRequest=new BidRequest();
        bidRequest.setId("1");
        return bidRequest;
    }
}
