package com.example.pr15kablukovpr23_102;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PhotoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);

        if (getSupportActionBar() != null) getSupportActionBar().hide();

        ImageView ivFull = findViewById(R.id.iv_full_photo);

        // Получаем ID ресурса изображения, которое передали
        int imageResId = getIntent().getIntExtra("image_id", 0);
        if (imageResId != 0) {
            ivFull.setImageResource(imageResId);
        }

        // Закрыть при нажатии на текст "Закрыть"
        findViewById(R.id.tv_close_photo).setOnClickListener(v -> finish());
    }
}