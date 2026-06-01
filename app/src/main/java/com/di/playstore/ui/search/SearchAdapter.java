package com.di.playstore.ui.search;

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

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<AppModel> apps;

    public SearchAdapter(List<AppModel> apps) {
        this.apps = apps;
    }

    public void updateList(List<AppModel> newApps) {
        this.apps = newApps;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search_app, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AppModel app = apps.get(position);

        holder.image.setImageResource(app.getImage());
        holder.name.setText(app.getName());
        holder.publisher.setText(app.getPublisher());
        holder.rating.setText(app.getRating());
        holder.size.setText(app.getSize());
        holder.download.setText(app.getDownload());

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

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, publisher, rating, size, download;

        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivAppImage);
            name = itemView.findViewById(R.id.tvAppName);
            publisher = itemView.findViewById(R.id.tvPublisher);
            rating = itemView.findViewById(R.id.tvRating);
            size = itemView.findViewById(R.id.tvSize);
            download = itemView.findViewById(R.id.tvDownload);
        }
    }
}