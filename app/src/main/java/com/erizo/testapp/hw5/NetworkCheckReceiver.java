package com.erizo.testapp.hw5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.util.Log;

import java.util.Objects;

/**
 * Created by Erizo on 26.02.2018.
 */

public class NetworkCheckReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Objects.equals(intent.getAction(), ConnectivityManager.CONNECTIVITY_ACTION)) {
                Log.d("NetworkCheckReceiver", "NetworkCheckReceiver invoked...");

                boolean noConnectivity = intent.getBooleanExtra(
                        ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

                if (!noConnectivity) {

                    Log.d("NetworkCheckReceiver", "connected");
                } else {

                    Log.d("NetworkCheckReceiver", "disconnected");
                }
            }
        }
    }
}
