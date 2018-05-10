package com.adplatform.ssp.pojo;

public class AdInfo {
    private Long id;

    private Integer type;

    private String width;

    private String height;

    private String data;

    private Long sspId;

    private Long adxAdId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width == null ? null : width.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public Long getSspId() {
        return sspId;
    }

    public void setSspId(Long sspId) {
        this.sspId = sspId;
    }

    public Long getAdxAdId() {
        return adxAdId;
    }

    public void setAdxAdId(Long adxAdId) {
        this.adxAdId = adxAdId;
    }
}