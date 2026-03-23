package com.example.pr15kablukovpr23_102;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {
    private ImageView p1, p2, p3, p4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        initViews();
        setupClickListeners();
        setupBottomNavigation();
    }

    private void initViews() {
        p1 = findViewById(R.id.iv_photo1);
        p2 = findViewById(R.id.iv_photo2);
        p3 = findViewById(R.id.iv_photo3);
        p4 = findViewById(R.id.iv_photo4);
    }

    private void setupClickListeners() {
        p1.setOnClickListener(v -> openPhoto(R.drawable.photo1));
        p2.setOnClickListener(v -> openPhoto(R.drawable.photo2));
        p3.setOnClickListener(v -> openPhoto(R.drawable.photo3));
        p4.setOnClickListener(v -> openPhoto(R.drawable.photo4));

        TextView tvExit = findViewById(R.id.tv_exit);
        tvExit.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }

    private void setupBottomNavigation() {
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_profile);
        bottomNav.setItemIconTintList(null);
        bottomNav.setSelectedItemId(R.id.nav_profile);

        bottomNav.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                // Если хочешь просто вернуться назад (к Home), лучше использовать finish()
                // Но если нужно явно открыть, то так:
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(intent);
                return true;
            }
            return true;
        });
    }

    private void openPhoto(int resId) {
        Intent intent = new Intent(this, PhotoDetailActivity.class);
        intent.putExtra("image_id", resId);
        startActivity(intent);
    }
}