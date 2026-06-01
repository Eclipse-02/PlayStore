package com.di.playstore;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.di.playstore.ui.apps.AppsFragment;
import com.di.playstore.ui.search.SearchFragment;
import com.di.playstore.ui.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View bottomNav = findViewById(R.id.bottomNav);
        View navigationRail = findViewById(R.id.navigationRail);

        // Load default fragment (Apps)
        if (savedInstanceState == null) {
            loadFragment(new AppsFragment());
        }

        if (bottomNav instanceof BottomNavigationView) {
            ((BottomNavigationView) bottomNav).setOnItemSelectedListener(item -> {
                return handleNavigation(item.getItemId());
            });
        } else if (navigationRail instanceof com.google.android.material.navigationrail.NavigationRailView) {
            ((com.google.android.material.navigationrail.NavigationRailView) navigationRail).setOnItemSelectedListener(item -> {
                return handleNavigation(item.getItemId());
            });
        }
    }

    private boolean handleNavigation(int itemId) {
        Fragment selectedFragment = null;

        if (itemId == R.id.nav_apps) {
            selectedFragment = new AppsFragment();
        } else if (itemId == R.id.nav_search) {
            selectedFragment = new SearchFragment();
        } else if (itemId == R.id.nav_profile) {
            selectedFragment = new ProfileFragment();
        }

        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}