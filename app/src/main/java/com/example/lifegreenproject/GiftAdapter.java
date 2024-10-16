package com.example.lifegreenproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GiftAdapter extends RecyclerView.Adapter<GiftAdapter.GiftViewHolder> {
    private List<Gift> giftList;

    public GiftAdapter(List<Gift> giftList) {
        this.giftList = giftList;
    }

    @NonNull
    @Override
    public GiftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gift, parent, false);
        return new GiftViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GiftViewHolder holder, int position) {
        Gift gift = giftList.get(position);
        holder.giftTitle.setText(gift.getTitle());
        holder.giftDescription.setText(gift.getDescription());
        holder.pointCheck.setText("Required Points: " + gift.getPoints());

        // Set click listener for the exchange button
        holder.exchangeButton.setOnClickListener(v -> {
            // Implement the exchange functionality here
            // For example, you could reduce user points or show a toast
        });
    }

    @Override
    public int getItemCount() {
        return giftList.size();
    }

    public static class GiftViewHolder extends RecyclerView.ViewHolder {
        ImageView giftImage;
        TextView giftTitle, giftDescription, pointCheck;
        Button exchangeButton;

        public GiftViewHolder(@NonNull View itemView) {
            super(itemView);
            giftImage = itemView.findViewById(R.id.giftImage);
            giftTitle = itemView.findViewById(R.id.giftTitle);
            giftDescription = itemView.findViewById(R.id.giftDescription);
            pointCheck = itemView.findViewById(R.id.pointCheck);
            exchangeButton = itemView.findViewById(R.id.exchangeButton);
        }
    }
}

