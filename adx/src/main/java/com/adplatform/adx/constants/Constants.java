package com.adplatform.adx.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constants {


    public static int ExecutionTimeOut=0;

    @Value("${adx.executionTimeOut}")
    public void setExecutionTimeOut(int executionTimeOut) {
        ExecutionTimeOut = executionTimeOut;
    }
}
