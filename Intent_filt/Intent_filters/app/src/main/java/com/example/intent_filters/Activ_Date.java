package com.example.intent_filters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Activ_Date extends AppCompatActivity {

    SimpleDateFormat sdf;
    String date;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activ_date);
        Log.d("Activity start", "Запустилась Activ_Date");

        tvDate = (TextView) findViewById(R.id.tvDate);

        sdf = new SimpleDateFormat("dd.MM.yyyy");
        date = sdf.format(new Date(System.currentTimeMillis()));

        tvDate.setText(date);
    }
}