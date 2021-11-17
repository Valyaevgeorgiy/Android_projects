package com.example.intent_filters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Info extends AppCompatActivity {

    SimpleDateFormat sdf;
    TextView tvView, tvDate;

    String format = "", textInfo = "", datetime = "", lname = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tvView = findViewById(R.id.tvView);

        // получаем Intent, который вызывал это Activity
        Intent intent = getIntent();

        // читаем из него action
        String action = intent.getAction();

        Log.d("Action", "Action is: " + action);

        // в зависимости от action заполняем переменные

        if (action.equals("com.example.intent.action.showtime")) {
            format = "HH:mm:ss";
            textInfo = "Time: ";
        }
        else if (action.equals("com.example.intent.action.showdate")) {
            format = "dd.MM.yyyy";
            textInfo = "Date: ";
        }

        // в зависимости от содержимого переменной format
        // получаем дату или время в переменную datetime
        sdf = new SimpleDateFormat(format);
        datetime = sdf.format(new Date(System.currentTimeMillis()));

        tvDate = (TextView) findViewById(R.id.tvInfo);
        tvDate.setText(textInfo + datetime);

        lname = intent.getStringExtra("lname");
        tvView.setText("Your name is: " + lname);
    }
}