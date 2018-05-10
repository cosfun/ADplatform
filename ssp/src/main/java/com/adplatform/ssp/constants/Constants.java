package com.adplatform.ssp.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constants {

    public static String AdxUrl="";

    @Value("${constants.adx.url}")
    public void setAdxUrl(String adxUrl) {
        AdxUrl = adxUrl;
    }
}
