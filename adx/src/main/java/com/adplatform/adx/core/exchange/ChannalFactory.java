package com.adplatform.adx.core.exchange;

import com.adplatform.adx.core.DemandService;
import com.adplatform.adx.core.model.AdProviderReader;
import com.adplatform.adx.core.model.PublishAgent;
import com.adplatform.adx.dao.DspUserMapper;
import com.adplatform.adx.pojo.DspUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


public class ChannalFactory {


    static public List<Callable<AdProviderReader>> create(List<DspUser> dspUsers,PublishAgent publishAgent){
        List<Callable<AdProviderReader>> list = new ArrayList<>();
        list.add(new DemandService(dspUsers,publishAgent));
        return list;
    }
}
