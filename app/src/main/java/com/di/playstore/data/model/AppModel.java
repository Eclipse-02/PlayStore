package com.di.playstore.data.model;

import java.io.Serializable;
import java.util.List;

public class AppModel implements Serializable {
    private final String name;
    private final String publisher;
    private final String description;
    private final String rating;
    private final String size;
    private final String download;
    private final int image;
    private final int banner;
    private final List<ScreenshotModel> screenshots;
    private final List<ReviewModel> reviews;
    private final List<String> tags;

    public AppModel(String name,
                    String publisher,
                    String description,
                    String rating,
                    String size,
                    String download,
                    int image,
                    int banner,
                    List<ScreenshotModel> screenshots,
                    List<ReviewModel> reviews,
                    List<String> tags) {
        this.name = name;
        this.publisher = publisher;
        this.description = description;
        this.rating = rating;
        this.size = size;
        this.download = download;
        this.image = image;
        this.banner = banner;
        this.screenshots = screenshots;
        this.reviews = reviews;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    public String getSize() {
        return size;
    }

    public String getDownload() {
        return download;
    }

    public int getImage() {
        return image;
    }

    public int getBanner() {
        return banner;
    }

    public List<ScreenshotModel> getScreenshots() {
        return screenshots;
    }

    public List<ReviewModel> getReviews() {
        return reviews;
    }

    public List<String> getTags() {
        return tags;
    }
}