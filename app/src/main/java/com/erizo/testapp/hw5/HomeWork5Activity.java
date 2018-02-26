package com.erizo.testapp.hw5;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.erizo.testapp.R;

/**
 * Created by Erizo on 26.02.2018.
 */

public class HomeWork5Activity extends AppCompatActivity {

    private static final String TAG_NAME = HomeWork5Activity.class.getSimpleName();

    private ServiceConnection sConn;
    private MyService service;
    private boolean bound = false;
    private Intent intent;
    private Button turnOn;
    private Button turnOff;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_work_5_activity);

        turnOn = findViewById(R.id.button7);
        turnOff = findViewById(R.id.button8);

        sConn = new ServiceConnection() {
            public void onServiceConnected(ComponentName name, IBinder binder) {
                Log.d(TAG_NAME, "HomeWork5Activity onServiceConnected");
                service = ((MyService.MyBinder) binder).getService();
                bound = true;
            }

            public void onServiceDisconnected(ComponentName name) {
                Log.d(TAG_NAME, "HomeWork5Activity onServiceDisconnected");
                bound = false;
            }
        };

        intent = new Intent(getApplicationContext(), MyService.class);
        bindService(intent, sConn, BIND_AUTO_CREATE);
        startService(intent);

        turnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service.turnOnWiFi();
            }
        });
        turnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service.turnOfWiFi();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(
                ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkCheckReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopService(intent);
//        unbindService(sConn);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(networkCheckReceiver);
    }

    private BroadcastReceiver networkCheckReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            boolean noConnectivity = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

            if (!noConnectivity) {
                Toast.makeText(getApplicationContext(), "Wifi - включен!", Toast.LENGTH_SHORT).show();
                Log.d("NetworkCheckReceiver", "connected");
            } else {
                Toast.makeText(getApplicationContext(), "Wifi - выключен!", Toast.LENGTH_SHORT).show();
                Log.d("NetworkCheckReceiver", "disconnected");
            }
        }
    };

    protected void onDestroy() {
        super.onDestroy();
        if (!bound) return;
        unbindService(sConn);
        bound = false;
    }
}
