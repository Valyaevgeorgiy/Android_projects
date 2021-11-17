package com.example.intent_filters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Activ_Time extends AppCompatActivity {

    SimpleDateFormat sdf;
    String time;
    TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activ_time);
        Log.d("Activity start", "Запустилась Activ_Time");

        tvTime = (TextView) findViewById(R.id.tvTime);

        sdf = new SimpleDateFormat("HH:mm:ss");
        time = sdf.format(new Date(System.currentTimeMillis()));

        tvTime.setText(time);
    }
}