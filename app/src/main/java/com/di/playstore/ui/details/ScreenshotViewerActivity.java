package com.di.playstore.ui.details;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.di.playstore.R;
import io.getstream.photoview.PhotoView;

public class ScreenshotViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screenshot_viewer);
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));

        PhotoView photoView = findViewById(R.id.photoView);
        ImageView ivBack = findViewById(R.id.ivBack);

        int imageRes = getIntent().getIntExtra("image_res", 0);
        if (imageRes != 0) {
            photoView.setImageResource(imageRes);
        }

        ivBack.setOnClickListener(v -> finish());
    }
}