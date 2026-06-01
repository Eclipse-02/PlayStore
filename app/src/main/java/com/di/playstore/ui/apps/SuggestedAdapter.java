package com.di.playstore.ui.apps;

import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.di.playstore.R;
import com.di.playstore.data.model.AppModel;
import com.di.playstore.ui.details.AppDetailsActivity;

import java.util.List;

public class SuggestedAdapter extends RecyclerView.Adapter<SuggestedAdapter.SuggestedViewHolder> {

    private final List<AppModel> apps;

    public SuggestedAdapter(List<AppModel> apps) {
        this.apps = apps;
    }

    @NonNull
    @Override
    public SuggestedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_suggested_app, parent, false);
        return new SuggestedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuggestedViewHolder holder, int position) {
        AppModel app = apps.get(position);

        holder.image.setImageResource(app.getImage());
        holder.banner.setImageResource(app.getBanner());
        holder.name.setText(app.getName());
        holder.rating.setText(app.getRating());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), AppDetailsActivity.class);
            intent.putExtra("app_data", app);
            v.getContext().startActivity(intent);
        });

        applyTopCrop(holder.banner);
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

    static class SuggestedViewHolder extends RecyclerView.ViewHolder {
        ImageView image, banner;
        TextView name, rating;

        public SuggestedViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivApp);
            banner = itemView.findViewById(R.id.ivBanner);
            name = itemView.findViewById(R.id.tvName);
            rating = itemView.findViewById(R.id.tvRating);
        }
    }
}