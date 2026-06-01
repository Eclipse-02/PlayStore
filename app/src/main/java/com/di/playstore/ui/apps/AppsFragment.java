package com.di.playstore.ui.apps;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.di.playstore.R;
import com.di.playstore.data.dummy.DummyDataProvider;
import com.di.playstore.ui.notification.NotificationActivity;

public class AppsFragment extends Fragment {

    private AppsSectionAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_apps, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerSections);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new AppsSectionAdapter(
                DummyDataProvider.getAppSections()
        );

        recyclerView.setAdapter(adapter);

        ImageView ivNotification = view.findViewById(R.id.ivNotification);
        ivNotification.setOnClickListener(v ->
                startActivity(new Intent(requireContext(), NotificationActivity.class))
        );

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}