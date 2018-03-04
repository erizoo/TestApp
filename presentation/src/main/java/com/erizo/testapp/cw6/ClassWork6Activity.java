package com.erizo.testapp.cw6;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.erizo.testapp.R;

/**
 * Created by Erizo on 26.02.2018.
 */

public class ClassWork6Activity extends AppCompatActivity{

    private static final String TAG = ClassWork6Activity.class.getSimpleName();
    private boolean isOneVisible = true;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_work_6_activity);

        findViewById(R.id.buttonFragment).setOnClickListener(v -> changeFragment());

        if (savedInstanceState == null){
            showFragment(OneFragment.getInstance());
        }
    }

    private void changeFragment(){
        if (isOneVisible){
            showFragment(TwoFragment.getInstance());
            isOneVisible = false;
        } else {
            showFragment(OneFragment.getInstance());
            isOneVisible = true;
        }
    }

    private void showFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
