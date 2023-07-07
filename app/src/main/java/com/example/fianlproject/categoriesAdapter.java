package com.example.fianlproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class categoriesAdapter extends RecyclerView.Adapter<categoriesAdapter.ViewHolder>{

    private List<Integer> leftIcons;
    private List<String> leftIconsText;
    private List<Integer> rightIcons;
    private List<String> rightIconsText;


    public categoriesAdapter(List<Integer> leftIcons,List<String> leftIconsText,List<Integer> rightIcons,List<String> rightIconsText)
    {
        this.leftIcons=leftIcons;
        this.leftIconsText=leftIconsText;
        this.rightIcons=rightIcons;
        this.rightIconsText=rightIconsText;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_layout, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        int leftIconId=leftIcons.get(position);
        holder.leftImg.setImageResource(leftIconId);

        String leftIconTextId=leftIconsText.get(position);
        holder.leftText.setText(leftIconTextId);

        int rightIconId=rightIcons.get(position);
        holder.rightImg.setImageResource(rightIconId);

        String rightIconTextId=rightIconsText.get(position);
        holder.rightText.setText(rightIconTextId);
    }

    @Override
    public int getItemCount() {

        int leftCount=leftIcons.size();


        return leftCount;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView leftImg,rightImg;
        public TextView leftText,rightText;

        public ViewHolder(View itemView) {
            super(itemView);
            leftImg = itemView.findViewById(R.id.leftImg);
            rightImg = itemView.findViewById(R.id.rightImg);
            rightText = itemView.findViewById(R.id.rightText);
            leftText = itemView.findViewById(R.id.leftText);
        }
    }


}
