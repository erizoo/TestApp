package com.erizo.testapp.hw5;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.erizo.testapp.R;

/**
 * Created by Erizo on 26.02.2018.
 */

public class HomeWork5Activity extends AppCompatActivity {

    private static final String TAG_NAME = HomeWork5Activity.class.getSimpleName();
    private WifiManager manager;
    private Button changeWifiStateButton;
    private ServiceConnection connection;
    private boolean bound = false;
    private MyService.MyBinder binder;
    private BroadcastReceiver receiver;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bound) {
            unbindService(connection);
        }
        bound = false;
        unregisterReceiver(receiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_work_5_activity);
        manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                checkWiFi();
            }
        };
        registerReceiver(receiver, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binder = (MyService.MyBinder) service;
                bound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                bound = false;
            }
        };
        bindService(new Intent(this, MyService.class), connection, BIND_AUTO_CREATE);
        changeWifiStateButton = findViewById(R.id.button7);
        changeWifiStateButton.setOnClickListener(v -> {
            if (bound) {
                binder.getService().changeWiFiState();
            }
        });
        checkWiFi();
    }

    public void checkWiFi() {
        if (manager.isWifiEnabled()) {
            changeWifiStateButton.setText("Выключить Wi-fi");
        } else {
            changeWifiStateButton.setText("Включить Wi-fi");
        }
    }
}
