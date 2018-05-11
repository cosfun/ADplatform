package com.adplatform.adx.core.exchange;

import com.adplatform.adx.constants.Constants;
import com.adplatform.adx.core.DemandBroker;

import com.adplatform.adx.core.model.ResponseContainer;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.List;
import java.util.concurrent.*;

public class DemandExecutorServiceFacade {

    public static final DemandExecutorServiceFacade instance = new DemandExecutorServiceFacade();

    private final ExecutorService service;

    private DemandExecutorServiceFacade() {
        final ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("Demand-%d").setDaemon(true).build();
        service = Executors.newCachedThreadPool(namedThreadFactory);
    }

    public List<Future<ResponseContainer>> invokeAll(final List<DemandBroker> callables) throws InterruptedException {
        return service.invokeAll(callables,Constants.ExecutionTimeOut, TimeUnit.MILLISECONDS);
    }


    public void shutdown() {
        if (service != null && !service.isShutdown()) {
            service.shutdown();
        }
    }

}
