package com.example.music_player_many_songs;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class PlayService extends Service {

    IBinder mBinder = new PlayServiceBinder();
    final String MY_TAG = "MUZ";
    ArrayList<Integer> playList;
    MediaPlayer mediaPlayer;
    Timer timer;

    // Количественный счётчик песен плейлиста
    int k = 0;

    public class PlayServiceBinder extends Binder {
        PlayService getService() {
            return PlayService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(MY_TAG, "Method of PlayService onBind() has started!");
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Полноценный массив треков плейлиста
        playList = new ArrayList<>();
        playList.add(R.raw.tischiny_hochu);
        playList.add(R.raw.call_3739);
        playList.add(R.raw.call_zhivi);
        playList.add(R.raw.federiko_fellini);
        playList.add(R.raw.kolyan_classic);
        playList.add(R.raw.rampampam_ring);
        playList.add(R.raw.ringtone_babel);
        playList.add(R.raw.tak_chochetsa_zhit);

        mediaPlayer = MediaPlayer.create(this, playList.get(0));
        mediaPlayer.start();
        Log.i(MY_TAG, "Method of PlayService onCreate() has started!");
        Log.i(MY_TAG, "PlayList has started!");

        timer = new Timer();
        if (playList.size() > 1) nextSong();
    }

    public void nextSong() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mediaPlayer.reset();
                mediaPlayer = MediaPlayer.create(PlayService.this, playList.get(++k));
                mediaPlayer.start();
                if (playList.size() > k + 1) {
                    nextSong();
                }
            }
        }, mediaPlayer.getDuration());
        Log.i(MY_TAG, "Method of PlayService nextSong() has started!");
    }

    public void playNextSong() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        timer.cancel();
        mediaPlayer.reset();
        if (playList.size() > k + 1) {
            Toast.makeText(PlayService.this.getApplicationContext(),
                    "Next трек по кнопке",
                    Toast.LENGTH_SHORT).show();
            mediaPlayer = MediaPlayer.create(PlayService.this, playList.get(++k));
            mediaPlayer.start();
            timer = new Timer();
            Log.i(MY_TAG, "Method of PlayService playNextSong() has started!");
            nextSong();
        } else {
            Toast.makeText(PlayService.this.getApplicationContext(),
                    "Треки закончились!",
                    Toast.LENGTH_SHORT).show();
            k -= 1;
            Log.i(MY_TAG, "Method of PlayService playNextSong() has stopped!");
        }
    }

    @Override
    public void onDestroy() {
        Log.i(MY_TAG, "Method of PlayService onDestroy() has started!");
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        timer.cancel();
        super.onDestroy();
    }
}