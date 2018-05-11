package com.adplatform.common.rtb.model;

import com.adplatform.common.rtb.model.response.SeatBid;

public class BidResponse {
    private String id;

    private SeatBid[] seatbid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SeatBid[] getSeatbid() {
        return seatbid;
    }

    public void setSeatbid(SeatBid[] seatbid) {
        this.seatbid = seatbid;
    }
}
