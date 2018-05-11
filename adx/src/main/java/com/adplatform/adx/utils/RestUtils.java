package com.adplatform.adx.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestUtils {

    public static RestTemplate restTemplate;

    @Autowired
    public  void setRestTemplate(RestTemplate restTemplate) {
        RestUtils.restTemplate = restTemplate;
    }
}
