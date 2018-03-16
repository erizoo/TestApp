package com.erizo.testapp.hw5;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Erizo on 26.02.2018.
 */

public class MyService extends Service {

    private static final String LOG_TAG = MyService.class.getSimpleName();
    private MyBinder binder;
    private WifiManager manager;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
    }

    public void changeWiFiState() {
        manager.setWifiEnabled(!manager.isWifiEnabled());
    }

    @Override
    public IBinder onBind(Intent intent) {
        binder = new MyBinder();
        return binder;
    }

    public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }
}
