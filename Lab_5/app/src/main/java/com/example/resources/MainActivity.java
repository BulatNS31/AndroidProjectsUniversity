package com.example.resources;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {

    private LinearLayout container;
    private TextView myText;
    private int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.container);
        myText = findViewById(R.id.my_text);   // главный текст
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        View rootLayout = findViewById(R.id.main);
        int id = item.getItemId();

        // ===== Цвета фона =====
        if (id == R.id.red) {
            rootLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
            return true;
        } else if (id == R.id.green) {
            rootLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
            return true;
        } else if (id == R.id.blue) {
            rootLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
            return true;
        } // ===== Выбор картинки фона =====
        else if (id == R.id.bg_background) {
            rootLayout.setBackgroundResource(R.drawable.background);
            Toast.makeText(this, "Фон: Background", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.bg_aben) {
            rootLayout.setBackgroundResource(R.drawable.aben);
            Toast.makeText(this, "Фон: Aben", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.bg_morning) {
            rootLayout.setBackgroundResource(R.drawable.morning);
            Toast.makeText(this, "Фон: Morning", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.bg_night) {
            rootLayout.setBackgroundResource(R.drawable.night);
            Toast.makeText(this, "Фон: Night", Toast.LENGTH_SHORT).show();
            return true;
        }

        // ===== Добавление элементов =====
        else if (id == R.id.add_edittext) {
            addEditText();
            return true;
        } else if (id == R.id.add_textview) {
            addTextView();
            return true;
        } else if (id == R.id.add_button) {
            addButton();
            return true;
        } else if (id == R.id.clear) {
            if (container != null) {
                container.removeAllViews();
                counter = 1;
                Toast.makeText(this, "Все элементы удалены", Toast.LENGTH_SHORT).show();
            }
            return true;
        }

        // ===== Смена шрифта =====
        else if (id == R.id.font_bellota) {
            setFont(R.font.bellota_regular);
            return true;
        } else if (id == R.id.font_opensans) {
            setFont(R.font.opensans_regular);
            return true;
        } else if (id == R.id.font_playfair) {
            setFont(R.font.playfair_display_regular);
            return true;
        } else if (id == R.id.font_bellota_bold) {
            setFont(R.font.bellota_bold);
            return true;
        } else if (id == R.id.font_playfair_italic) {
            setFont(R.font.playfair_display_italic);
            return true;
        }

        // ===== Выход =====
        else if (id == R.id.exit) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Метод смены шрифта
    private void setFont(int fontResId) {
        if (myText == null) return;

        Typeface typeface = ResourcesCompat.getFont(this, fontResId);
        if (typeface != null) {
            myText.setTypeface(typeface);
            Toast.makeText(this, "Шрифт изменён", Toast.LENGTH_SHORT).show();
        }
    }

    // ===== Методы добавления элементов =====
    private void addEditText() {
        if (container == null) return;

        EditText et = new EditText(this);
        et.setHint("Текстовое поле #" + counter++);
        et.setBackgroundColor(0xFFFFFFFF);
        et.setPadding(24, 16, 24, 16);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 12, 0, 12);
        et.setLayoutParams(params);

        container.addView(et);
    }

    private void addTextView() {
        if (container == null) return;

        TextView tv = new TextView(this);
        tv.setText("Новый TextView #" + counter++);
        tv.setTextSize(18);
        tv.setTextColor(0xFF000000);
        tv.setBackgroundColor(0xAAFFFFFF);
        tv.setPadding(24, 16, 24, 16);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 12, 0, 12);
        tv.setLayoutParams(params);

        container.addView(tv);
    }

    private void addButton() {
        if (container == null) return;

        Button btn = new Button(this);
        btn.setText("Кнопка #" + counter);
        final int num = counter++;
        btn.setOnClickListener(v ->
                Toast.makeText(this, "Нажата кнопка #" + num, Toast.LENGTH_SHORT).show()
        );

        container.addView(btn);
    }
}