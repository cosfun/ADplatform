package com.adplatform.adx.core.exchange;

import com.adplatform.adx.core.model.AdProviderReader;
import com.adplatform.common.utils.FloatComparator;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ExchangeService {


    public static Future<AdProviderReader> validate(final Future<AdProviderReader> a, final Future<AdProviderReader> b) {
        try {
            if (b.get() == null) {
                return a;
            }
            if (a.get() == null) {
                return b;
            }

            if (FloatComparator.greaterThanWithPrecision(a.get().getPrice(), b.get().getPrice())) {
                return a;
            }
        } catch (final InterruptedException | ExecutionException| CancellationException e) {
            System.out.println("error:"+e.getMessage());
        }

        return b;
    }

}
