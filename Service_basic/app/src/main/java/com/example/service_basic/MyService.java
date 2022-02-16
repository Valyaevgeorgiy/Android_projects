package com.example.service_basic;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.Date;

public class MyService extends Service {

    final String LOG_TAG = "My_LOGs";
    final IBinder MyBinder = new MyBinder();

    public class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public void onCreate(){
        Log.i(LOG_TAG, "Method onCreate() started...");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.i(LOG_TAG, "Method onStartCommand() started...");
        interestTask();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(LOG_TAG, "Method onBind() started...");
        return MyBinder;
    }

    @Override
    public boolean onUnbind(Intent intent){
        Log.i(LOG_TAG, "Method onUnbind() started...");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent){
        Log.i(LOG_TAG, "Method onRebind() started...");
        super.onRebind(intent);
    }

    @Override
    public void onDestroy(){
        Log.i(LOG_TAG, "Method onDestroy() started...");
        Toast.makeText(getApplicationContext(), "Сервис завершил свою работу!",
                Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    // Интересное действие в рамках полезности сервиса приложения
    public void interestTask(){
        Date date = new Date();
        double value = Math.random() * 100;
        String result = String.format("%.2f", value);
        Toast.makeText(getApplicationContext(), "Now is " + date.toString(),
                Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "Шанс сделать все дела = " + (result) + "%",
                Toast.LENGTH_LONG).show();
    }
}
