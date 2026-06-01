package com.di.playstore.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.di.playstore.R;
import com.di.playstore.ui.library.LibraryActivity;
import com.di.playstore.ui.notification.NotificationActivity;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        LinearLayout btnWishlist = view.findViewById(R.id.btnWishlist);
        LinearLayout btnInstalled = view.findViewById(R.id.btnInstalled);

        btnWishlist.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), LibraryActivity.class);
            intent.putExtra("type", "wishlist");
            startActivity(intent);
        });

        btnInstalled.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), LibraryActivity.class);
            intent.putExtra("type", "installed");
            startActivity(intent);
        });

        ImageView ivNotification = view.findViewById(R.id.ivNotification);
        ivNotification.setOnClickListener(v ->
                startActivity(new Intent(requireContext(), NotificationActivity.class))
        );

        return view;
    }
}