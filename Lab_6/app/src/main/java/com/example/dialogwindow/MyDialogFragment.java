package com.example.dialogwindow;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {

    public interface MyDialogFragmentListener {
        void onReturnValue(String value);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Заголовок
        builder.setTitle("Диалоговое окно");

        // Подключаем свою компоновку
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View layout = inflater.inflate(R.layout.dialog_layout, null);
        builder.setView(layout);

        final EditText myText = layout.findViewById(R.id.name);

        // Кнопка 1 — Показать текст в Activity (Positive)
        builder.setPositiveButton(R.string.show_text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                MyDialogFragmentListener activity = (MyDialogFragmentListener) getActivity();
                if (activity != null) {
                    activity.onReturnValue(myText.getText().toString());
                }
            }
        });

        // Кнопка 2 — Закрыть диалог (Negative)
        builder.setNegativeButton(R.string.close, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();   // просто закрываем диалог
            }
        });

        // Кнопка 3 — Завершить Activity (Neutral)
        builder.setNeutralButton(R.string.exit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                if (getActivity() != null) {
                    getActivity().finish();
                }
            }
        });

        // Чтобы нельзя было закрыть кнопкой "Назад"
        // builder.setCancelable(false);

        return builder.create();
    }
}