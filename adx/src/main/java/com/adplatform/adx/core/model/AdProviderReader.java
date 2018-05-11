package com.adplatform.adx.core.model;

public interface AdProviderReader {
    float getPrice();
    AdProvider getAdProvider();
    void buildResponse();

}
