package com.di.playstore.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.di.playstore.R;
import com.di.playstore.data.model.AppModel;
import com.di.playstore.data.model.ScreenshotModel;
import com.di.playstore.ui.search.SearchActivity;
import com.di.playstore.utils.PreferenceManager;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AppDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_details);

        ChipGroup chipTags = findViewById(R.id.chipTags);
        ImageView ivAppIcon = findViewById(R.id.ivAppIcon);
        TextView tvName = findViewById(R.id.tvAppName);
        TextView tvPublisher = findViewById(R.id.tvAppPublisher);
        TextView tvRating = findViewById(R.id.tvAppRating);
        TextView tvBigRating = findViewById(R.id.tvBigRating);
        TextView tvDescription = findViewById(R.id.tvDescription);
        TextView tvSize = findViewById(R.id.tvSize);
        TextView tvDownload = findViewById(R.id.tvDownload);
        RecyclerView recyclerScreenshots = findViewById(R.id.recyclerScreenshots);
        RecyclerView recyclerReviews = findViewById(R.id.recyclerReviews);

        AppModel app = (AppModel) getIntent().getSerializableExtra("app_data");
        if (app != null) {

            tvName.setText(app.getName());
            tvPublisher.setText(app.getPublisher());
            tvRating.setText(app.getRating());
            tvBigRating.setText(app.getRating());
            tvDescription.setText(app.getDescription());
            tvSize.setText(app.getSize());
            tvDownload.setText(app.getDownload());
            ivAppIcon.setImageResource(app.getImage());

            recyclerScreenshots.setAdapter(
                    new ScreenshotAdapter(app.getScreenshots())
            );

            recyclerReviews.setAdapter(
                    new ReviewAdapter(app.getReviews())
            );

            recyclerReviews.setNestedScrollingEnabled(false);
        }

        ImageView ivMore = findViewById(R.id.ivMore);

        ivMore.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(this, v);
            popup.getMenuInflater().inflate(R.menu.menu_app_details, popup.getMenu());

            String appName = app.getName();
            boolean isWishlisted = PreferenceManager.isWishlisted(this, appName);

            MenuItem wishlistItem = popup.getMenu().findItem(R.id.menu_wishlist);

            wishlistItem.setIcon(
                    isWishlisted
                            ? R.drawable.bookmark_remove_20px
                            : R.drawable.bookmark_add_20px
            );

            popup.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.menu_wishlist) {

                    boolean current = PreferenceManager.isWishlisted(this, appName);
                    PreferenceManager.setWishlisted(this, appName, !current);

                    Toast.makeText(this,
                            appName + (current ? " removed from wishlist" : " added to wishlist"),
                            Toast.LENGTH_SHORT).show();

                    return true;
                }
                return false;
            });

            try {
                Field field = popup.getClass().getDeclaredField("mPopup");
                field.setAccessible(true);
                Object menuPopupHelper = field.get(popup);
                Class<?> classPopupHelper = Class.forName(menuPopupHelper.getClass().getName());
                Method setForceIcons = classPopupHelper.getMethod("setForceShowIcon", boolean.class);
                setForceIcons.invoke(menuPopupHelper, true);
            } catch (Exception e) {
                e.printStackTrace();
            }

            popup.show();
        });

        Button btnInstall = findViewById(R.id.btnInstall);
        Button btnUninstall = findViewById(R.id.btnUninstall);

        String appName = app.getName();
        boolean installed = PreferenceManager.isInstalled(this, appName);
        updateInstallState(btnInstall, btnUninstall, installed);

        btnInstall.setOnClickListener(v -> {
            boolean isInstalled = PreferenceManager.isInstalled(this, appName);

            if (!isInstalled) {
                PreferenceManager.setInstalled(this, appName, true);
                updateInstallState(btnInstall, btnUninstall, true);
            } else {
                Toast.makeText(this, "Opening " + appName, Toast.LENGTH_SHORT).show();
            }
        });

        btnUninstall.setOnClickListener(v -> {
            PreferenceManager.setInstalled(this, appName, false);
            updateInstallState(btnInstall, btnUninstall, false);
        });

        findViewById(R.id.ivBack).setOnClickListener(v -> finish());

        // Screenshots
        recyclerScreenshots.setLayoutManager(
                new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        );

        ScreenshotAdapter adapter = new ScreenshotAdapter(app.getScreenshots());
        recyclerScreenshots.setAdapter(adapter);

        recyclerScreenshots.setOnFlingListener(null);

        boolean hasVertical = false;

        for (ScreenshotModel s : app.getScreenshots()) {
            if (s.getType() == ScreenshotModel.TYPE_IMAGE && s.isVertical()) {
                hasVertical = true;
                break;
            }
        }

        if (!hasVertical) {
            new PagerSnapHelper().attachToRecyclerView(recyclerScreenshots);
        }

        // ChipTags
        chipTags.removeAllViews();

        for (String tag : app.getTags()) {
            Chip chip = new Chip(this);
            chip.setText(tag);
            chip.setClickable(true);
            chip.setCheckable(false);

            chip.setOnClickListener(v -> {
                Intent intent = new Intent(this, SearchActivity.class);
                intent.putExtra("initial_query", tag);
                startActivity(intent);
            });

            chipTags.addView(chip);
        }

        recyclerReviews.setLayoutManager(
                new LinearLayoutManager(this)
        );

        for (int i = 0; i < chipTags.getChildCount(); i++) {
            View chipView = chipTags.getChildAt(i);

            if (chipView instanceof Chip) {
                Chip chip = (Chip) chipView;

                chip.setClickable(true);
                chip.setOnClickListener(v -> {
                    Intent intent = new Intent(AppDetailsActivity.this, SearchActivity.class);
                    intent.putExtra("initial_query", chip.getText().toString());
                    startActivity(intent);
                });
            }
        }
    }

    private void updateInstallState(Button btnInstall, Button btnUninstall, boolean installed) {
        if (installed) {
            btnInstall.setText("Open");
            btnUninstall.setVisibility(View.VISIBLE);
        } else {
            btnInstall.setText("Install");
            btnUninstall.setVisibility(View.GONE);
        }
    }
}