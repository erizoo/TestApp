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
    private boolean bound = false;
    private Intent intent;
    private Button bind;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_work_5_activity);



        sConn = new ServiceConnection() {
            public void onServiceConnected(ComponentName name, IBinder binder) {
                Log.d(TAG_NAME, "HomeWork5Activity onServiceConnected");
                bound = true;
            }

            public void onServiceDisconnected(ComponentName name) {
                Log.d(TAG_NAME, "HomeWork5Activity onServiceDisconnected");
                bound = false;
            }
        };

        intent = new Intent("ru.startandroid.develop.p0972servicebindserver.MyService");
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

    public void onClickStart(View v) {
        startService(intent);
    }

    public void onClickStop(View v) {
        stopService(intent);
    }

    public void onClickBind(View v) {
        bindService(intent, sConn, BIND_AUTO_CREATE);
    }

    public void onClickUnBind(View v) {
        if (!bound) return;
        unbindService(sConn);
        bound = false;
    }

    protected void onDestroy() {
        super.onDestroy();
        onClickUnBind(null);
    }
}
