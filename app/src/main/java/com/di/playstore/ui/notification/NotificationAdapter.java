package com.di.playstore.ui.notification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.di.playstore.R;
import com.di.playstore.data.model.NotificationModel;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private final List<NotificationModel> list;

    public NotificationAdapter(List<NotificationModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_notification, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotificationModel item = list.get(position);
        holder.ivApp.setImageResource(item.getImage());
        holder.tvTitle.setText(item.getTitle());
        holder.tvMessage.setText(item.getMessage());
        holder.tvDate.setText(item.getDate());

        holder.ivMore.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(v.getContext(), holder.ivMore);

            try {
                Field field = PopupMenu.class.getDeclaredField("mPopup");
                field.setAccessible(true);

                Object menuPopupHelper = field.get(popupMenu);
                Method setForceShowIcon = menuPopupHelper
                        .getClass()
                        .getDeclaredMethod("setForceShowIcon", boolean.class);

                setForceShowIcon.invoke(menuPopupHelper, true);

            } catch (Exception e) {
                e.printStackTrace();
            }

            popupMenu.getMenuInflater().inflate(
                    R.menu.menu_notification_item,
                    popupMenu.getMenu()
            );

            popupMenu.setOnMenuItemClickListener(menuItem -> {
                int currentPosition = holder.getAdapterPosition();

                if (currentPosition == RecyclerView.NO_POSITION) {
                    return true;
                }

                if (menuItem.getItemId() == R.id.action_clear) {
                    list.remove(currentPosition);
                    notifyItemRemoved(currentPosition);
                    return true;

                } else if (menuItem.getItemId() == R.id.action_more_like) {
                    Toast.makeText(
                            v.getContext(),
                            "Thank you for your feedback!",
                            Toast.LENGTH_SHORT
                    ).show();
                    return true;

                } else if (menuItem.getItemId() == R.id.action_less_like) {
                    Toast.makeText(
                            v.getContext(),
                            "Thank you for your feedback!",
                            Toast.LENGTH_SHORT
                    ).show();
                    return true;
                }

                return false;
            });
            popupMenu.show();
        });
    }

    @Override
    public int getItemCount() { return list.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivApp, ivMore;
        TextView tvTitle, tvMessage, tvDate;

        ViewHolder(View itemView) {
            super(itemView);
            ivApp = itemView.findViewById(R.id.ivApp);
            ivMore = itemView.findViewById(R.id.ivMore);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvMessage = itemView.findViewById(R.id.tvMessage);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }
}