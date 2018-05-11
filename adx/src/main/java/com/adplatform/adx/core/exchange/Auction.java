package com.adplatform.adx.core.exchange;

import com.adplatform.adx.core.model.AdProvider;
import com.adplatform.adx.core.model.RtbProviderReader;
import com.adplatform.common.rtb.model.BidResponse;
import com.adplatform.common.rtb.model.response.Bid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Auction {
    public static RtbProviderReader auctioneer(BidExchange bidExchange){
        ArrayList<Bidder> bidders = new ArrayList<>();

        for(Map.Entry<AdProvider,BidResponse> bidResponseEntry:bidExchange.getBidResponseMap().entrySet()){
            BidResponse bidResponse = bidResponseEntry.getValue();
            for(Bid bid:bidResponse.getSeatbid()[0].getBid()){
                Bidder bidder = new Bidder();
                bidder.setDspId(bidResponseEntry.getKey().getId());
                bidder.setPrice(bid.getPrice());
                System.out.println("bider id:"+bid.getId()+", price "+bid.getPrice());
                bidders.add(bidder);
            }
        }

        Collections.sort(bidders);

        RtbProviderReader winner=null;


        if(!bidders.isEmpty()&&bidders.size()>=2){
            winner = evalWinner(bidders);
        }

        return winner;
    }

    private static RtbProviderReader evalWinner(ArrayList<Bidder> bidders){
        RtbProviderReader rtbProviderReader = new RtbProviderReader();
        rtbProviderReader.setPrice((bidders.get(1).getPrice()+0.01f));
        rtbProviderReader.setDspId(bidders.get(1).getDspId());
        return rtbProviderReader;
    }



    private static class Bidder implements Comparable<Bidder>{
        private float price;
        private String dspId;

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public String getDspId() {
            return dspId;
        }

        public void setDspId(String dspId) {
            this.dspId = dspId;
        }


        @Override
        public int compareTo(Bidder o) {
            if (o.getPrice() > getPrice()) {
                return 1;
            }
            return -1;
        }
    }
}
