package com.adplatform.adx.core.model;

public class RtbProviderReader implements AdProviderReader{
    private float price;

    private String dspId;

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public AdProvider getAdProvider() {
        return null;
    }

    @Override
    public void buildResponse() {

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
}
