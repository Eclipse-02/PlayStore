package com.di.playstore.data.model;

import java.io.Serializable;

public class ScreenshotModel implements Serializable {
    public static final int TYPE_IMAGE = 0;
    public static final int TYPE_VIDEO = 1;

    private int type;
    private int imageRes;
    private String videoUrl;
    private boolean isVertical;

    public ScreenshotModel(int imageRes, boolean isVertical) {
        this.type = TYPE_IMAGE;
        this.imageRes = imageRes;
        this.isVertical = isVertical;
    }

    public ScreenshotModel(String videoUrl) {
        this.type = TYPE_VIDEO;
        this.videoUrl = videoUrl;
    }

    public int getType() { return type; }
    public int getImageRes() { return imageRes; }
    public String getVideoUrl() { return videoUrl; }
    public boolean isVertical() { return isVertical; }
}