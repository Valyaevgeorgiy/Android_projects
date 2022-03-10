package com.example.broadcastworks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final
        String ATTENTION_MESSAGE = "В ближайший час в срочном порядке требую прислать отчёт!!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SendMessage(View view) {
        Intent intent = new Intent();
        ComponentName compoName = new ComponentName(this, MyReceiver.class);
        intent.putExtra("com.example.broadcast.Message", ATTENTION_MESSAGE);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        intent.setComponent(compoName);
        sendBroadcast(intent);
    }
}