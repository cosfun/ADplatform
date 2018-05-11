package com.adplatform.adx.pojo;

public class DspUser {
    private Long id;

    private Long dspId;

    private String dspToken;

    private String name;

    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDspId() {
        return dspId;
    }

    public void setDspId(Long dspId) {
        this.dspId = dspId;
    }

    public String getDspToken() {
        return dspToken;
    }

    public void setDspToken(String dspToken) {
        this.dspToken = dspToken == null ? null : dspToken.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}