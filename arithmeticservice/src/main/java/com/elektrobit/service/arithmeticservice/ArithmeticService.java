package com.elektrobit.service.arithmeticservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class ArithmeticService extends Service {
    private final String TAG = this.getClass().getName();
    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind called");
        return new ArithmeticServiceImpl();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // code to perform background tasks
        return START_STICKY;
    }
}
