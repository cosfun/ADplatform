package com.adplatform.adx.core.model;

import com.adplatform.adx.pojo.DspUser;

public class AdProvider {
    String id;
    String name;
    String url;


    public AdProvider(){
        super();
    }

    public AdProvider(DspUser dspUser) {
        setId(dspUser.getId() + "");
        setName(dspUser.getName());
        setUrl(dspUser.getUrl());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
