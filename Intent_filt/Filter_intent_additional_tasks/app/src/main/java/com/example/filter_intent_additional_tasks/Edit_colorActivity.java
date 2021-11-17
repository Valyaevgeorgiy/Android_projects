package com.example.filter_intent_additional_tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Edit_colorActivity extends AppCompatActivity {

    Spinner spColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_color);

        spColor = findViewById(R.id.spColor);
        String[] textColors = {"Красный", "Синий", "Жёлтый", "Зелёный", "Чёрный", "Розовый"};

        ArrayAdapter<String> spinnerArrayColors = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, textColors);

        spinnerArrayColors.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spColor.setAdapter(spinnerArrayColors);
    }

    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("color", spColor.getSelectedItem().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}