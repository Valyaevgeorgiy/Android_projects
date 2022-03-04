package com.example.music_player_many_songs;

import androidx.appcompat.app.AppCompatActivity;
import com.example.music_player_many_songs.PlayService.PlayServiceBinder;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

public class Playlist extends AppCompatActivity {

    PlayService playService;
    boolean serviceConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        Button btnPlayNext = findViewById(R.id.btnPlayNext);
        Button btnUnbind = findViewById(R.id.btnUnBind);

        Intent playServiceIntent = new Intent(this, PlayService.class);

        ServiceConnection mConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName className, IBinder service) {
                PlayServiceBinder binder = (PlayServiceBinder) service;
                playService = binder.getService();
                serviceConnected = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                serviceConnected = false;
            }
        };

        bindService(playServiceIntent, mConnection, BIND_AUTO_CREATE);

        // Включаем следующий трек
        btnPlayNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playService.playNextSong();
            }
        });

        btnUnbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (serviceConnected) {
                    unbindService(mConnection);
                    serviceConnected = false;
                }
            }
        });
    }
}