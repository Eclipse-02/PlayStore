package com.di.playstore.data.model;

import java.io.Serializable;

public class ReviewModel implements Serializable {
    private final int profileImage;
    private final int rating;
    private final String username;
    private final String comment;
    private final String date;

    public ReviewModel(int profileImage, int rating, String username, String comment, String date) {
        this.profileImage = profileImage;
        this.rating = rating;
        this.username = username;
        this.comment = comment;
        this.date = date;
    }

    public int getProfileImage() { return profileImage; }
    public int getRating() { return rating; }
    public String getUsername() { return username; }
    public String getComment() { return comment; }
    public String getDate() { return date; }
}