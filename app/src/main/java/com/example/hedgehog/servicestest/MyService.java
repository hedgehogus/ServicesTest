package com.example.hedgehog.servicestest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by hedgehog on 03.09.2016.
 */
public class MyService extends Service {
    static boolean isRunningNow = false;

    final String LOG_TAG = "myLogs";

    public void onCreate() {
        super.onCreate();
        //Log.d(LOG_TAG, "onCreate");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {

        isRunningNow = true;
        someTask(startId);
        //START_NOT_STICKY – сервис не будет перезапущен после того, как был убит системой
        //START_STICKY – сервис будет перезапущен после того, как был убит системой
        //START_REDELIVER_INTENT – сервис будет перезапущен после того, как был убит системой.
        // Кроме этого, сервис снова получит все вызовы startService, которые не были завершены методом stopSelf(startId).
        return START_REDELIVER_INTENT;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    void someTask(final int startID) {
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i<=180; i++) {
                    Log.d(LOG_TAG, "i = " + i + " id: " + startID );
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (!isRunningNow){
                        break;
                    }
                }

                boolean result = stopSelfResult(startID);
                Log.d (LOG_TAG, "result " + startID  + " " + result);
            }
        }).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
       // Log.d(LOG_TAG, "destroy" );
        isRunningNow = false;
    }
}
