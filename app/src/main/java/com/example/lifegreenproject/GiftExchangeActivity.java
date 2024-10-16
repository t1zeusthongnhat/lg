package com.example.lifegreenproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GiftExchangeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GiftAdapter giftAdapter;
    private List<Gift> giftList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_gift);

        recyclerView = findViewById(R.id.giftRecyclerView);
        ImageButton backButton = findViewById(R.id.backButton);

        // Initialize gift list
        giftList = new ArrayList<>();
        // Add sample data (this would typically come from a server or database)
        giftList.add(new Gift("Gift 1", "This is gift 1", 100));
        giftList.add(new Gift("Gift 2", "This is gift 2", 150));
        giftList.add(new Gift("Gift 3", "This is gift 3", 200));

        // Set up the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        giftAdapter = new GiftAdapter(giftList);
        recyclerView.setAdapter(giftAdapter);

        // Add divider between items
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);


        // Thiết lập sự kiện click cho backButton
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kết thúc hoạt động hiện tại
                finish();
            }
        });
    }
}
