package com.di.playstore.data.model;

import java.io.Serializable;

public class CategoryModel implements Serializable {
    private final String name;
    private final int icon;

    public CategoryModel(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() { return name; }
    public int getIcon() { return icon; }
}