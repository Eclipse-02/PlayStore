package com.di.playstore.ui.details;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.di.playstore.R;
import com.di.playstore.data.model.ScreenshotModel;

import java.util.List;

public class ScreenshotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<ScreenshotModel> list;

    public ScreenshotAdapter(List<ScreenshotModel> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        ScreenshotModel item = list.get(position);
        if (item.getType() == ScreenshotModel.TYPE_VIDEO) return 2;
        return item.isVertical() ? 1 : 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == 2) {
            View v = inflater.inflate(R.layout.item_video, parent, false);
            return new VideoViewHolder(v);
        } else if (viewType == 1) {
            View v = inflater.inflate(R.layout.item_screenshot_vertical, parent, false);
            return new ImageViewHolder(v);
        } else {
            View v = inflater.inflate(R.layout.item_screenshot_horizontal, parent, false);
            return new ImageViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ScreenshotModel item = list.get(position);

        if (holder instanceof ImageViewHolder) {
            ((ImageViewHolder) holder).image.setImageResource(item.getImageRes());
            if (item.isVertical()) {
                applyTopCrop(((ImageViewHolder) holder).image);
            }

            holder.itemView.setOnClickListener(v -> {
                android.content.Intent intent = new android.content.Intent(v.getContext(), ScreenshotViewerActivity.class);
                intent.putExtra("image_res", item.getImageRes());
                v.getContext().startActivity(intent);
            });
        } else if (holder instanceof VideoViewHolder) {
            ((VideoViewHolder) holder).bind(item.getVideoUrl());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        ImageViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivScreenshot);
        }
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnail;

        VideoViewHolder(View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.ivThumbnail);
        }

        void bind(String url) {
            String videoId = extractYoutubeId(url);

            // Load thumbnail (no Glide needed)
            String thumbnailUrl = "https://img.youtube.com/vi/" + videoId + "/hqdefault.jpg";

            new Thread(() -> {
                try {
                    java.io.InputStream input = new java.net.URL(thumbnailUrl).openStream();
                    android.graphics.Bitmap bitmap = android.graphics.BitmapFactory.decodeStream(input);

                    thumbnail.post(() -> thumbnail.setImageBitmap(bitmap));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            itemView.setOnClickListener(v -> {
                android.content.Intent intent = new android.content.Intent(
                        android.content.Intent.ACTION_VIEW,
                        android.net.Uri.parse(url)
                );
                v.getContext().startActivity(intent);
            });
        }

        private String extractYoutubeId(String url) {
            String videoId = null;

            if (url.contains("v=")) {
                videoId = url.split("v=")[1];
                int ampIndex = videoId.indexOf("&");
                if (ampIndex != -1) {
                    videoId = videoId.substring(0, ampIndex);
                }
            }

            return videoId;
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
}