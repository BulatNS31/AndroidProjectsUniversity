package com.example.toggleapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Находим элементы
        tvStatus = findViewById(R.id.tvStatus);
        CheckBox checkBox = findViewById(R.id.checkBox);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        ImageButton imageButton = findViewById(R.id.imageButton);

        // ========== 1. CheckBox ==========
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tvStatus.setText("CheckBox: уведомления ВКЛЮЧЕНЫ");
                    Toast.makeText(MainActivity.this, "Уведомления включены", Toast.LENGTH_SHORT).show();
                } else {
                    tvStatus.setText("CheckBox: уведомления ВЫКЛЮЧЕНЫ");
                    Toast.makeText(MainActivity.this, "Уведомления выключены", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // ========== 2. ToggleButton ==========
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tvStatus.setText("ToggleButton: состояние ВКЛЮЧЕНО");
                } else {
                    tvStatus.setText("ToggleButton: состояние ВЫКЛЮЧЕНО");
                }
            }
        });

        // ========== 3. RadioGroup (RadioButton) ==========
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selected = findViewById(checkedId);
                String color = selected.getText().toString();

                tvStatus.setText("Выбран цвет: " + color);

                // Меняем цвет фона статуса для наглядности
                if (checkedId == R.id.radioRed) {
                    tvStatus.setBackgroundColor(0xFFFFCDD2); // светло-красный
                } else if (checkedId == R.id.radioGreen) {
                    tvStatus.setBackgroundColor(0xFFC8E6C9); // светло-зелёный
                } else if (checkedId == R.id.radioBlue) {
                    tvStatus.setBackgroundColor(0xFFBBDEFB); // светло-синий
                }
            }
        });

        // ========== 4. ImageButton ==========
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvStatus.setText("ImageButton: нажата кнопка камеры!");
                Toast.makeText(MainActivity.this, "Нажата ImageButton", Toast.LENGTH_SHORT).show();
            }
        });
    }
}