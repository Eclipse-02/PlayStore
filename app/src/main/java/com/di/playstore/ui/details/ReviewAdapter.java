package com.di.playstore.ui.details;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.di.playstore.R;
import com.di.playstore.data.model.ReviewModel;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private final List<ReviewModel> reviews;

    public ReviewAdapter(List<ReviewModel> reviews) {
        this.reviews = reviews;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_review, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ReviewModel review = reviews.get(position);

        holder.profile.setImageResource(review.getProfileImage());
        holder.username.setText(review.getUsername());
        holder.comment.setText(review.getComment());
        holder.date.setText(review.getDate());

        holder.layoutStars.removeAllViews();

        for (int i = 1; i <= 5; i++) {
            ImageView star = new ImageView(holder.itemView.getContext());

            star.setImageResource(R.drawable.star_20px);

            if (i <= review.getRating()) {
                star.setColorFilter(
                        holder.itemView.getContext().getColor(R.color.blue_primary)
                );
            } else {
                star.setColorFilter(
                        holder.itemView.getContext().getColor(android.R.color.darker_gray)
                );
            }

            int size = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    16,
                    holder.itemView.getResources().getDisplayMetrics()
            );

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, size);
            star.setLayoutParams(params);

            holder.layoutStars.addView(star);
        }
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profile;
        TextView username, comment, date;
        LinearLayout layoutStars;

        ViewHolder(View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.ivProfile);
            username = itemView.findViewById(R.id.tvUsername);
            comment = itemView.findViewById(R.id.tvComment);
            date = itemView.findViewById(R.id.tvDate);
            layoutStars = itemView.findViewById(R.id.layoutStars);
        }
    }
}