package com.example.lifegreenproject;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private LinearLayout garbageDictionaryLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Ánh xạ LinearLayout
        garbageDictionaryLayout = findViewById(R.id.garbage_dictionary_layout);

        // Thiết lập sự kiện click cho LinearLayout
        garbageDictionaryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mở DictionaryActivity khi người dùng click vào LinearLayout
                Intent intent = new Intent(HomeActivity.this, DictionaryActivity.class);
                startActivity(intent);
            }
        });

        drawerLayout = findViewById(R.id.drawerLayout);
        ImageView iconMenu = findViewById(R.id.iconMenu);
        NavigationView navigationView = findViewById(R.id.navigationView);

        iconMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();
            // Handle navigation view item clicks here
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        AppCompatButton learnAndPlayButton = findViewById(R.id.button2bb);
        learnAndPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        // Thay đổi màu sắc icon và text khi ở trang Home
        LinearLayout homeLayout = findViewById(R.id.homeLayout); // Đảm bảo id đã đúng
        ImageView homeIcon = findViewById(R.id.imageView12);
        TextView homeText = findViewById(R.id.textView12);

        // Đặt màu xanh cho icon và text
        homeIcon.setColorFilter(ContextCompat.getColor(this, R.color.primaryDarkColor), PorterDuff.Mode.SRC_IN);
        homeText.setTextColor(ContextCompat.getColor(this, R.color.primaryDarkColor));
    }
}