package com.adplatform.common.rtb.model;

import com.adplatform.common.rtb.model.requeset.Device;
import com.adplatform.common.rtb.model.requeset.Impression;
import com.adplatform.common.rtb.model.requeset.Site;
import com.adplatform.common.rtb.model.requeset.User;

public class BidRequest {
    private String id;

    private Impression impression;

    private Site site;

    private Device device;

    private User user;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Impression getImpression() {
        return impression;
    }

    public void setImpression(Impression impression) {
        this.impression = impression;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
