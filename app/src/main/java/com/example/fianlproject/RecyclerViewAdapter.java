package com.example.fianlproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Integer> icons;
    private List<String> iconsText;

    public RecyclerViewAdapter(List<Integer> icons,List<String> iconsText) {
        this.icons = icons;
        this.iconsText=iconsText;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.imageviewitems, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // For to bind my Image view in imageview to the icon
        int iconResId = icons.get(position);
        holder.iconImageView.setImageResource(iconResId);

        // For to bind my Text view in imageview to the text
        String iconText=iconsText.get(position);
        holder.iconTextView.setText(iconText);
    }

    @Override
    public int getItemCount() {
        return icons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iconImageView;
        public TextView iconTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            iconImageView = itemView.findViewById(R.id.iconImageView);
            iconTextView = itemView.findViewById(R.id.iconTextView);
        }
    }
}
