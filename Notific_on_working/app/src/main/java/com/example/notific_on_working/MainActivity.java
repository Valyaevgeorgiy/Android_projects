package com.example.notific_on_working;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int[] counter = {0};
        setContentView(R.layout.activity_main);

        Button btnStartServ = findViewById(R.id.btnStartFgService);
        Button btnClicker = findViewById(R.id.btnClick);

        Intent StartService = new Intent(MainActivity.this, MyService.class);

        btnStartServ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartService.putExtra("flag", 1);
                startForegroundService(StartService);
            }
        });

        btnClicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter[0] += 1;
                StartService.putExtra("counter", counter[0]);
                startForegroundService(StartService);
            }
        });
    }
}