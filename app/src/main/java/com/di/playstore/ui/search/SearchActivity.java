package com.di.playstore.ui.search;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.di.playstore.R;
import com.di.playstore.data.dummy.DummyDataProvider;
import com.di.playstore.data.model.AppModel;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private List<AppModel> allApps;
    private SearchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        EditText etSearch = findViewById(R.id.etSearch);
        RecyclerView recyclerSearch = findViewById(R.id.recyclerSearch);

        allApps = DummyDataProvider.getAllApps();
        adapter = new SearchAdapter(new ArrayList<>(allApps));

        recyclerSearch.setLayoutManager(new LinearLayoutManager(this));
        recyclerSearch.setAdapter(adapter);

        ImageView ivBack = findViewById(R.id.ivBack);
        ImageView ivClear = findViewById(R.id.ivClear);

        ivBack.setOnClickListener(v -> finish());
        ivClear.setOnClickListener(v -> etSearch.setText(""));

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<AppModel> filtered = filterApps(s.toString());
                adapter.updateList(filtered);
            }

            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}
        });

        String initialQuery = getIntent().getStringExtra("initial_query");

        if (initialQuery != null) {
            etSearch.setText(initialQuery);

            List<AppModel> filtered = filterApps(initialQuery);
            adapter.updateList(filtered);
        }

        etSearch.setSelection(etSearch.getText().length());
    }

    private List<AppModel> filterApps(String query) {
        List<AppModel> allApps = DummyDataProvider.getAllApps();
        List<AppModel> result = new ArrayList<>();

        String lowerQuery = query.toLowerCase().trim();

        for (AppModel app : allApps) {

            boolean matchName = app.getName().toLowerCase().contains(lowerQuery);
            boolean matchPublisher = app.getPublisher().toLowerCase().contains(lowerQuery);

            boolean matchTag = false;
            for (String tag : app.getTags()) {
                if (tag.toLowerCase().contains(lowerQuery)) {
                    matchTag = true;
                    break;
                }
            }

            if (matchName || matchPublisher || matchTag) {
                result.add(app);
            }
        }

        return result;
    }
}