package com.adplatform.adx.core.exchange;

import com.adplatform.adx.constants.Constants;
import com.adplatform.adx.core.model.AdProviderReader;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.List;
import java.util.concurrent.*;

public class ExchangeExecutorServiceFacade {

    public static final ExchangeExecutorServiceFacade instance = new ExchangeExecutorServiceFacade();

    private final ExecutorService service;

    private ExchangeExecutorServiceFacade() {
        final ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("Adx-%d").setDaemon(true).build();
        service = Executors.newCachedThreadPool(namedThreadFactory);
    }

    public List<Future<AdProviderReader>> invokeAll(final List<Callable<AdProviderReader>> callables) throws InterruptedException {
        return service.invokeAll(callables,Constants.ExecutionTimeOut, TimeUnit.MILLISECONDS);
    }


    public void shutdown() {
        if (service != null && !service.isShutdown()) {
            service.shutdown();
        }
    }

}
