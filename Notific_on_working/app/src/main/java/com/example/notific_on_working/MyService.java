package com.example.notific_on_working;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

public class MyService extends Service {

    final IBinder myBinder = new MyServiceBinder();

    public class MyServiceBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent){
        return myBinder;
    }

    public static final String NOT_CHANNEL_ID = "121";

    @Override
    public void onCreate(){
        super.onCreate();
        Log.d("SV", "Method onCreate() has started!");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        int counter = intent.getIntExtra("counter", 0);

        Log.d("SV", "Method onStartCommand() has started!");

        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        notificationManager.createNotificationChannel(
                new NotificationChannel
                        (NOT_CHANNEL_ID, "SV", NotificationManager.IMPORTANCE_DEFAULT)
        );


        Intent secondActivity = new Intent(this, SecondActiv.class);
        Intent thirdActivity = new Intent(this, ThirdActiv.class);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(
                this, NOT_CHANNEL_ID
        );

        PendingIntent secondPendingIntent = PendingIntent.getActivity(
                this,
                0,
                secondActivity,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        PendingIntent thirdPendingIntent = PendingIntent.getActivity(
                this,
                0,
                thirdActivity,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        RemoteViews mRemoteViews = new RemoteViews(getPackageName(), R.layout.notif_custom);
        mRemoteViews.setTextViewText(R.id.title_notify, "TITLE");
        mRemoteViews.setTextViewText(R.id.content_notify, "CONTENT");

        Notification notification = notificationBuilder.setOngoing(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Title")
                .setContentText("Clicks: " + counter)
                .setContentIntent(secondPendingIntent)
                .setPriority(NotificationManager.IMPORTANCE_MIN)
                .setContent(mRemoteViews)
                .setCategory(Notification.CATEGORY_SERVICE)
                .addAction(R.drawable.ic_launcher_background,"Second activity", secondPendingIntent)
                .addAction(R.drawable.ic_launcher_background, "Third activity", thirdPendingIntent)
                .build();

        startForeground(1, notification);
        return super.onStartCommand(intent, flags, startId);
    }

}