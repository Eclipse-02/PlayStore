package com.di.playstore.ui.notification;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.di.playstore.R;
import com.di.playstore.data.model.NotificationModel;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        RecyclerView recyclerView = findViewById(R.id.recyclerNotifications);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(v -> finish());

        List<NotificationModel> list = new ArrayList<>();
        list.add(new NotificationModel(R.drawable.appspotify, "Update available", "Spotify has a new update", "2 days ago"));
        list.add(new NotificationModel(R.drawable.appcanva, "Recommended", "Try Canva for design", "1 week ago"));

        recyclerView.setAdapter(new NotificationAdapter(list));
    }
}