package com.adplatform.dsp.controller;


import com.adplatform.common.rtb.model.BidRequest;
import com.adplatform.common.rtb.model.BidResponse;
import com.adplatform.common.rtb.model.response.Bid;
import com.adplatform.common.rtb.model.response.SeatBid;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Random;

@RequestMapping("/dsp")
@RestController
public class Dsp {

    @RequestMapping("/view")
    public String auction(@RequestBody BidRequest bidRequest, HttpServletRequest request, HttpServletResponse response){
        BidResponse bidResponse = new BidResponse();

        //略过
        SeatBid seatBid = new SeatBid();

        Bid bid0 = new Bid();
        bid0.setId("1");
        bid0.setAdid("1");
        bid0.setPrice(new Random().nextFloat());

        Bid bid1 = new Bid();
        bid0.setId("2");
        bid1.setAdid("2");
        bid1.setPrice(new Random().nextFloat());

        Bid[] bids=new Bid[2];
        bids[0]=bid0;
        bids[1]=bid1;
        seatBid.setBid(bids);

        SeatBid[] seatBids=new SeatBid[1];
        seatBids[0]=seatBid;

        bidResponse.setSeatbid(seatBids);

        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("bidResponse", bidResponse);

        HashMap<String, Object> aderMap = new HashMap<>();
        aderMap.put("id","1");

        resMap.put("adProvider", aderMap);

        String body=JSON.toJSONString(resMap);
        System.out.println(body);
        return body;
    }
}
