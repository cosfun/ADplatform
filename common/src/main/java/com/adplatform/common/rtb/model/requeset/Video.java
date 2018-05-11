package com.adplatform.common.rtb.model.requeset;

public class Video {
    String[] mimes;
    Integer minduration;
    Integer maxduration;
    Integer width;
    Integer height;


    public String[] getMimes() {
        return mimes;
    }

    public void setMimes(String[] mimes) {
        this.mimes = mimes;
    }

    public Integer getMinduration() {
        return minduration;
    }

    public void setMinduration(Integer minduration) {
        this.minduration = minduration;
    }

    public Integer getMaxduration() {
        return maxduration;
    }

    public void setMaxduration(Integer maxduration) {
        this.maxduration = maxduration;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
