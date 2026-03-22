package com.example.pr15kablukovpr23_102;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout lastSelectedLayout = null;
    private int defaultCircleColor, selectedCircleColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Цвета из ресурсов (настрой их в colors.xml)
        defaultCircleColor = ContextCompat.getColor(this, R.color.white);
        selectedCircleColor = ContextCompat.getColor(this, R.color.teal_200);

        // Находим наши кнопки-контейнеры
        setupFeelingButton(R.id.ll_calm, R.string.calm);
        setupFeelingButton(R.id.ll_relax, R.string.relax);
        setupFeelingButton(R.id.ll_focus, R.string.focus);
        setupFeelingButton(R.id.ll_anxious, R.string.anxious);

        // Обработка нижнего меню
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_profile) {
                // Переход в профиль
                //startActivity(new Intent(this, ProfileActivity.class));
            }
            return true;
        });
    }

    private void setupFeelingButton(int layoutId, int stringResId) {
        LinearLayout layout = findViewById(layoutId);
        layout.setOnClickListener(v -> {
            // 1. Сбрасываем предыдущую кнопку
            if (lastSelectedLayout != null) {
                resetFeelingStyle(lastSelectedLayout);
            }

            // 2. Выделяем текущую
            selectFeelingStyle(layout);
            lastSelectedLayout = layout;

            // 3. Показываем сообщение
            Toast.makeText(this, getString(stringResId), Toast.LENGTH_SHORT).show();
        });
    }

    private void selectFeelingStyle(LinearLayout layout) {
        View circle = layout.getChildAt(0); // ImageView (иконка)
        circle.setBackgroundTintList(ColorStateList.valueOf(selectedCircleColor));
    }

    private void resetFeelingStyle(LinearLayout layout) {
        View circle = layout.getChildAt(0);
        circle.setBackgroundTintList(ColorStateList.valueOf(defaultCircleColor));
    }
}