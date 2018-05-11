package com.adplatform.common.rtb.model.requeset;

public class Banner {
    private int width;
    private int height;
    private String[] mimes;//支持的类型swf jpg

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String[] getMimes() {
        return mimes;
    }

    public void setMimes(String[] mimes) {
        this.mimes = mimes;
    }
}
