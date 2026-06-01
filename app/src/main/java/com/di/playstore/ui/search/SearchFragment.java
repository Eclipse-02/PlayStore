package com.di.playstore.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.di.playstore.R;
import com.di.playstore.data.dummy.DummyCategoryProvider;
import com.google.android.material.search.SearchBar;

public class SearchFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerCategories);
        int spanCount = getResources().getInteger(R.integer.search_category_span_count);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), spanCount));
        recyclerView.setAdapter(new CategoryAdapter(DummyCategoryProvider.getCategories()));

        SearchBar searchBar = view.findViewById(R.id.searchBar);
        searchBar.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), SearchActivity.class));
        });

        return view;
    }
}