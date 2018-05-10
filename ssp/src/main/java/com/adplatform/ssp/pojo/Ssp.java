package com.adplatform.ssp.pojo;

public class Ssp {
    private Long id;

    private String name;

    private String token;

    private String adxId;

    private String adxToken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getAdxId() {
        return adxId;
    }

    public void setAdxId(String adxId) {
        this.adxId = adxId == null ? null : adxId.trim();
    }

    public String getAdxToken() {
        return adxToken;
    }

    public void setAdxToken(String adxToken) {
        this.adxToken = adxToken == null ? null : adxToken.trim();
    }
}