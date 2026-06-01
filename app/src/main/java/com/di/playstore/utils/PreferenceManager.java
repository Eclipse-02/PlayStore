package com.di.playstore.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {

    private static final String PREF_NAME = "app_prefs";
    private static final String KEY_WISHLIST = "wishlist_";
    private static final String KEY_INSTALLED = "installed_";

    // Wishlist
    public static void setWishlisted(Context context, String appName, boolean value) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putBoolean(KEY_WISHLIST + appName, value).apply();
    }

    public static boolean isWishlisted(Context context, String appName) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getBoolean(KEY_WISHLIST + appName, false);
    }

    // Installed (already exists, keep consistent naming)
    public static void setInstalled(Context context, String appName, boolean value) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putBoolean(KEY_INSTALLED + appName, value).apply();
    }

    public static boolean isInstalled(Context context, String appName) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getBoolean(KEY_INSTALLED + appName, false);
    }
}