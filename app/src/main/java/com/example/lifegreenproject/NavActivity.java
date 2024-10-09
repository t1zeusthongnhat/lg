package com.example.lifegreenproject;

import android.health.connect.datatypes.units.Length;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class NavActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageButton buttonDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_home);

         drawerLayout = findViewById(R.id.drawerLayout);
         buttonDrawerToggle = findViewById(R.id.buttonDrawerToggle);
         navigationView = findViewById(R.id.navigationView);


         buttonDrawerToggle.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 drawerLayout.open();
             }
         });

         View headerView = navigationView.getHeaderView(0);
        ImageView useImage = headerView.findViewById(R.id.userImage);
        TextView textUsername = headerView.findViewById(R.id.textUsername);

        useImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(NavActivity.this,textUsername.getText(), Toast.LENGTH_SHORT).show();

            }
        });

         navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                 int itemId = item.getItemId();
                 if(itemId == R.id.navMenu){
                     Toast.makeText(NavActivity.this,"Menu Clicked", Toast.LENGTH_SHORT).show();
                 }
                 if(itemId == R.id.navCart){
                     Toast.makeText(NavActivity.this,"Cart Clicked", Toast.LENGTH_SHORT).show();
                 }
                 if(itemId == R.id.navFavorite){
                     Toast.makeText(NavActivity.this,"Favorite Clicked", Toast.LENGTH_SHORT).show();
                 }
                 if(itemId == R.id.navOrders){
                     Toast.makeText(NavActivity.this,"Ongoing Clicked", Toast.LENGTH_SHORT).show();
                 }
                 if(itemId == R.id.navHistory){
                     Toast.makeText(NavActivity.this,"History Clicked", Toast.LENGTH_SHORT).show();
                 }
                 if(itemId == R.id.navFeedback){
                     Toast.makeText(NavActivity.this,"Feedback Clicked", Toast.LENGTH_SHORT).show();
                 }
                 if(itemId == R.id.navTerms){
                     Toast.makeText(NavActivity.this,"Term Clicked", Toast.LENGTH_SHORT).show();
                 }
                 if(itemId == R.id.navContact){
                     Toast.makeText(NavActivity.this,"Contact Clicked", Toast.LENGTH_SHORT).show();
                 }
                 if(itemId == R.id.navShare){
                     Toast.makeText(NavActivity.this,"Share Clicked", Toast.LENGTH_SHORT).show();
                 }
                 drawerLayout.close();
                 return false;
             }
         });
    }
}
