package com.di.playstore.ui.apps;

import android.content.Intent;
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

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.RecommendedViewHolder> {

    private final List<AppModel> apps;

    public RecommendedAdapter(List<AppModel> apps) {
        this.apps = apps;
    }

    @NonNull
    @Override
    public RecommendedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recommended_app, parent, false);
        return new RecommendedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedViewHolder holder, int position) {
        AppModel app = apps.get(position);

        holder.image.setImageResource(app.getImage());
        holder.name.setText(app.getName());
        holder.description.setText(app.getDescription());
        holder.rating.setText(app.getRating());
        holder.size.setText(app.getSize());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), AppDetailsActivity.class);
            intent.putExtra("app_data", app);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

    static class RecommendedViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, description, rating, size;

        public RecommendedViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivApp);
            name = itemView.findViewById(R.id.tvName);
            description = itemView.findViewById(R.id.tvDescription);
            rating = itemView.findViewById(R.id.tvRating);
            size = itemView.findViewById(R.id.tvSize);
        }
    }
}