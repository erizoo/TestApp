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
    MyBinder binder = new MyBinder();

    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "MyService onCreate");
    }

    public void turnOnWiFi(){
        WifiManager wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        assert wifiManager != null;
        wifiManager.setWifiEnabled(true);

    }

    public void turnOfWiFi(){
        WifiManager wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        assert wifiManager != null;
        wifiManager.setWifiEnabled(false);
    }

    public IBinder onBind(Intent intent) {
        Log.d(LOG_TAG, "MyService onBind");
        return binder;
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(LOG_TAG, "MyService onRebind");
    }

    public boolean onUnbind(Intent intent) {
        Log.d(LOG_TAG, "MyService onUnbind");
        return super.onUnbind(intent);
    }



    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "MyService onDestroy");
    }

    class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }
}
