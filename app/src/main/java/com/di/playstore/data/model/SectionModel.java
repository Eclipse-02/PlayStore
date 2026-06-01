package com.di.playstore.data.model;

import java.io.Serializable;
import java.util.List;

public class SectionModel implements Serializable {
    private final String title;
    private final int type;
    private final List<AppModel> apps;

    public SectionModel(String title, int type, List<AppModel> apps) {
        this.title = title;
        this.type = type;
        this.apps = apps;
    }

    public String getTitle() { return title; }
    public int getType() { return type; }
    public List<AppModel> getApps() { return apps; }
}