package com.di.playstore.data.model;

import java.io.Serializable;

public class NotificationModel implements Serializable {
    private final int image;
    private final String title;
    private final String message;
    private final String date;

    public NotificationModel(int image, String title, String message, String date) {
        this.image = image;
        this.title = title;
        this.message = message;
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }
}