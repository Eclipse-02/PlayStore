package com.di.playstore.ui.library;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.di.playstore.R;
import com.di.playstore.data.dummy.DummyDataProvider;
import com.di.playstore.data.model.AppModel;
import com.di.playstore.ui.search.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        ImageView ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(v -> finish());

        loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        RecyclerView recyclerView = findViewById(R.id.recyclerLibrary);
        TextView title = findViewById(R.id.ivScreenTitle);
        TextView tvEmptyMessage = findViewById(R.id.tvEmptyMessage);
        LinearLayout layoutEmpty = findViewById(R.id.layoutEmpty);

        SearchAdapter adapter = new SearchAdapter(new ArrayList<>());
        String type = getIntent().getStringExtra("type");

        List<AppModel> list;

        if ("wishlist".equals(type)) {
            title.setText("Wishlist");
            list = DummyDataProvider.getWishlistApps(this);
            tvEmptyMessage.setText("No apps in wishlist");
        } else {
            title.setText("Installed");
            list = DummyDataProvider.getInstalledApps(this);
            tvEmptyMessage.setText("No installed apps");
        }

        if (list.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            layoutEmpty.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            layoutEmpty.setVisibility(View.GONE);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter.updateList(list); // IMPORTANT
            recyclerView.setAdapter(new SearchAdapter(list));
        }
    }
}