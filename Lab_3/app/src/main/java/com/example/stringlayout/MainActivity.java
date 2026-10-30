package com.example.stringlayout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private float mTextSize = 20;
    private EditText mEdit;
    private TextView tSize;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdit = findViewById(R.id.edit_text);
        tSize = findViewById(R.id.size);

        Button buttonB = findViewById(R.id.button_b);
        Button buttonI = findViewById(R.id.button_i);
        Button buttonSans = findViewById(R.id.button_sans);
        Button buttonSerif = findViewById(R.id.button_serif);
        Button buttonMonospace = findViewById(R.id.button_monospace);
        Button buttonPlus = findViewById(R.id.button_plus);
        Button buttonMinus = findViewById(R.id.button_minus);

        // Устанавливаем слушатели
        buttonB.setOnClickListener(this);
        buttonI.setOnClickListener(this);
        buttonSans.setOnClickListener(this);
        buttonSerif.setOnClickListener(this);
        buttonMonospace.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);

        // Начальный размер
        mEdit.setTextSize(mTextSize);
        tSize.setText(String.format(Locale.forLanguageTag("ru-RU"), "%.0f", mTextSize));
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.button_plus) {
            if (mTextSize < 72) {
                mTextSize += 2;
                mEdit.setTextSize(mTextSize);
                tSize.setText(String.format(Locale.forLanguageTag("ru-RU"), "%.0f", mTextSize));
            }
        }
        else if (id == R.id.button_minus) {
            if (mTextSize > 18) {
                mTextSize -= 2;
                mEdit.setTextSize(mTextSize);
                tSize.setText(String.format(Locale.forLanguageTag("ru-RU"), "%.0f", mTextSize));
            }
        }
        else if (id == R.id.button_b) {
            // Переключение жирного
            int style = mEdit.getTypeface() != null ? mEdit.getTypeface().getStyle() : Typeface.NORMAL;

            if (style == Typeface.ITALIC) {
                mEdit.setTypeface(mEdit.getTypeface(), Typeface.BOLD_ITALIC);
            } else if (style == Typeface.BOLD_ITALIC) {
                mEdit.setTypeface(mEdit.getTypeface(), Typeface.ITALIC);
            } else if (style == Typeface.BOLD) {
                mEdit.setTypeface(Typeface.create(mEdit.getTypeface(), Typeface.NORMAL));
            } else {
                mEdit.setTypeface(mEdit.getTypeface(), Typeface.BOLD);
            }
        }
        else if (id == R.id.button_i) {
            // Переключение курсива (пропущенный фрагмент)
            int style = mEdit.getTypeface() != null ? mEdit.getTypeface().getStyle() : Typeface.NORMAL;

            if (style == Typeface.BOLD) {
                mEdit.setTypeface(mEdit.getTypeface(), Typeface.BOLD_ITALIC);
            } else if (style == Typeface.BOLD_ITALIC) {
                mEdit.setTypeface(mEdit.getTypeface(), Typeface.BOLD);
            } else if (style == Typeface.ITALIC) {
                mEdit.setTypeface(Typeface.create(mEdit.getTypeface(), Typeface.NORMAL));
            } else {
                mEdit.setTypeface(mEdit.getTypeface(), Typeface.ITALIC);
            }
        }
        else if (id == R.id.button_sans) {
            int style = mEdit.getTypeface() != null ? mEdit.getTypeface().getStyle() : Typeface.NORMAL;

            if (style == Typeface.ITALIC) {
                mEdit.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC);
            } else if (style == Typeface.BOLD_ITALIC) {
                mEdit.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
            } else if (style == Typeface.BOLD) {
                mEdit.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
            } else {
                mEdit.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
            }
        }
        else if (id == R.id.button_serif) {
            int style = mEdit.getTypeface() != null ? mEdit.getTypeface().getStyle() : Typeface.NORMAL;

            if (style == Typeface.ITALIC) {
                mEdit.setTypeface(Typeface.SERIF, Typeface.ITALIC);
            } else if (style == Typeface.BOLD_ITALIC) {
                mEdit.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);
            } else if (style == Typeface.BOLD) {
                mEdit.setTypeface(Typeface.SERIF, Typeface.BOLD);
            } else {
                mEdit.setTypeface(Typeface.SERIF, Typeface.NORMAL);
            }
        }
        else if (id == R.id.button_monospace) {
            // Переключение на Monospace (пропущенный фрагмент)
            int style = mEdit.getTypeface() != null ? mEdit.getTypeface().getStyle() : Typeface.NORMAL;

            if (style == Typeface.ITALIC) {
                mEdit.setTypeface(Typeface.MONOSPACE, Typeface.ITALIC);
            } else if (style == Typeface.BOLD_ITALIC) {
                mEdit.setTypeface(Typeface.MONOSPACE, Typeface.BOLD_ITALIC);
            } else if (style == Typeface.BOLD) {
                mEdit.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
            } else {
                mEdit.setTypeface(Typeface.MONOSPACE, Typeface.NORMAL);
            }
        }
    }
}