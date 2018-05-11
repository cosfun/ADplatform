package com.adplatform.common.rtb.model.response;

public class Bid {
    String id;//dsp 曝光id
    String impId;
    float price;
    String adid;
    String nurl;
    String ext;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImpId() {
        return impId;
    }

    public void setImpId(String impId) {
        this.impId = impId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAdid() {
        return adid;
    }

    public void setAdid(String adid) {
        this.adid = adid;
    }

    public String getNurl() {
        return nurl;
    }

    public void setNurl(String nurl) {
        this.nurl = nurl;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
