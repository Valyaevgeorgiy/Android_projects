package com.example.music_player_many_songs;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    final String MY_TAG = "MUZ";
    private MediaPlayer mediaPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Сервис создан", Toast.LENGTH_SHORT).show();
        Log.i(MY_TAG, "Method of MyService onCreate() has started!");
        mediaPlayer = MediaPlayer.create(this, R.raw.kolyan_classic);
        mediaPlayer.setLooping(false);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Сервис запущен", Toast.LENGTH_SHORT).show();
        Log.i(MY_TAG, "Method of MyService onStartCommand() has started!");
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Сервис остановлен", Toast.LENGTH_SHORT).show();
        Log.i(MY_TAG, "Method of MyService onDestroy() has started!");
        mediaPlayer.release();
    }
}