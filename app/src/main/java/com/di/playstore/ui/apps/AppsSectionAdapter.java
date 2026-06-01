package com.di.playstore.ui.apps;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.di.playstore.R;
import com.di.playstore.data.model.SectionModel;
import com.google.android.material.color.MaterialColors;

import java.util.List;

public class AppsSectionAdapter extends RecyclerView.Adapter<AppsSectionAdapter.ViewHolder> {

    private final List<SectionModel> sections;

    public AppsSectionAdapter(List<SectionModel> sections) {
        this.sections = sections;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_section_container, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SectionModel section = sections.get(position);
        holder.tvTitle.setText(section.getTitle());

        int textColor = MaterialColors.getColor(
                holder.itemView,
                com.google.android.material.R.attr.colorOnSurface
        );

        int paddingStartDp = 6;
        int paddingStartPx = (int) (paddingStartDp * holder.itemView.getContext().getResources().getDisplayMetrics().density);
        holder.tvTitle.setPaddingRelative(
                paddingStartPx,
                holder.tvTitle.getPaddingTop(),
                holder.tvTitle.getPaddingEnd(),
                holder.tvTitle.getPaddingBottom()
        );

        holder.tvTitle.setTextColor(textColor);

        Context context = holder.itemView.getContext();
        switch (section.getType()) {
            case 0:
                holder.recyclerHorizontal.setLayoutManager(
                        new LinearLayoutManager(
                                context,
                                RecyclerView.HORIZONTAL,
                                false
                        )
                );
                holder.recyclerHorizontal.setAdapter(new FeaturedAdapter(section.getApps()));
                holder.recyclerHorizontal.setOnFlingListener(null);
                new PagerSnapHelper().attachToRecyclerView(holder.recyclerHorizontal);
                break;

            case 1:
                int recommendedSpans = context.getResources().getInteger(R.integer.recommended_grid_span);
                GridLayoutManager recommendedGrid = new GridLayoutManager(
                        context,
                        recommendedSpans,
                        RecyclerView.HORIZONTAL,
                        false
                );
                holder.recyclerHorizontal.setLayoutManager(recommendedGrid);
                holder.recyclerHorizontal.setAdapter(new RecommendedAdapter(section.getApps()));
                holder.recyclerHorizontal.setOnFlingListener(null);
                new PagerSnapHelper().attachToRecyclerView(holder.recyclerHorizontal);
                break;

            default:
                int suggestedSpans = context.getResources().getInteger(R.integer.suggested_grid_span);
                GridLayoutManager suggestedGrid = new GridLayoutManager(
                        context,
                        suggestedSpans,
                        RecyclerView.HORIZONTAL,
                        false
                );
                holder.recyclerHorizontal.setLayoutManager(suggestedGrid);
                holder.recyclerHorizontal.setAdapter(new SuggestedAdapter(section.getApps()));
                break;
        }
    }

    @Override
    public int getItemCount() { return sections.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        RecyclerView recyclerHorizontal;

        ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvSectionTitle);
            recyclerHorizontal = itemView.findViewById(R.id.recyclerHorizontal);
        }
    }
}