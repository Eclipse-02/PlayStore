package com.di.playstore.ui.apps;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.di.playstore.R;
import com.di.playstore.data.model.AppModel;
import com.di.playstore.ui.details.AppDetailsActivity;
import com.di.playstore.utils.PreferenceManager;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    private final List<AppModel> apps;

    public FeaturedAdapter(List<AppModel> apps) {
        this.apps = apps;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_featured_app, parent, false);
        return new FeaturedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        AppModel app = apps.get(position);

        holder.banner.setImageResource(app.getBanner());
        holder.image.setImageResource(app.getImage());
        holder.name.setText(app.getName());
        holder.publisher.setText(app.getPublisher());
        holder.rating.setText(app.getRating());

        // InstallBtn
        boolean isInstalled = PreferenceManager.isInstalled(
                holder.itemView.getContext(),
                app.getName()
        );

        updateInstallButtonStyle(holder, isInstalled);

        holder.btnInstall.setOnClickListener(v -> {
            boolean currentInstalled = PreferenceManager.isInstalled(
                    v.getContext(),
                    app.getName()
            );

            if (!currentInstalled) {
                PreferenceManager.setInstalled(
                        v.getContext(),
                        app.getName(),
                        true
                );

                updateInstallButtonStyle(holder, true);

            } else {
                Toast.makeText(
                        v.getContext(),
                        "Opening " + app.getName(),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        // AppDetail
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), AppDetailsActivity.class);
            intent.putExtra("app_data", app);
            v.getContext().startActivity(intent);
        });

        // Banner
        holder.banner.setImageResource(app.getBanner());
        applyTopCrop(holder.banner);
    }

    private void updateInstallButtonStyle(FeaturedViewHolder holder, boolean installed) {
        MaterialButton button = (MaterialButton) holder.btnInstall;

        button.setStrokeWidth(0);

        if (installed) {
            button.setText("Open");
            button.setBackgroundTintList(
                    ColorStateList.valueOf(
                            holder.itemView.getContext().getColor(R.color.surface_light)
                    )
            );

            button.setTextColor(
                    holder.itemView.getContext().getColor(R.color.blue_primary)
            );

            button.setStrokeWidth(4);

            button.setStrokeColor(
                    ColorStateList.valueOf(
                            holder.itemView.getContext().getColor(R.color.blue_primary)
                    )
            );
        } else {
            button.setText("Install");
            button.setBackgroundTintList(
                    ColorStateList.valueOf(
                            holder.itemView.getContext().getColor(R.color.blue_primary)
                    )
            );

            button.setTextColor(
                    holder.itemView.getContext().getColor(R.color.blue_on_primary)
            );

            button.setStrokeWidth(0);
        }
    }

    private void applyTopCrop(ImageView imageView) {
        imageView.post(() -> {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null) return;

            float viewWidth = imageView.getWidth();

            float drawableWidth = drawable.getIntrinsicWidth();

            float scale = viewWidth / drawableWidth;

            Matrix matrix = new Matrix();
            matrix.setScale(scale, scale);

            float dx = (viewWidth - drawableWidth * scale) / 2f;
            float dy = 0f;

            matrix.postTranslate(dx, dy);

            imageView.setImageMatrix(matrix);
        });
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

    static class FeaturedViewHolder extends RecyclerView.ViewHolder {
        public Button btnInstall;
        ImageView image, banner;
        TextView name, publisher, rating, size;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.ivBanner);
            image = itemView.findViewById(R.id.ivApp);
            name = itemView.findViewById(R.id.tvName);
            publisher = itemView.findViewById(R.id.tvPublisher);
            rating = itemView.findViewById(R.id.tvRating);
            btnInstall = itemView.findViewById(R.id.btnInstall);
        }
    }
}