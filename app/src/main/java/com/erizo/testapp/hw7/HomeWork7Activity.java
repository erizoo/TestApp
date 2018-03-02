package com.erizo.testapp.hw7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.erizo.testapp.R;
import com.erizo.testapp.cw6.OneFragment;
import com.erizo.testapp.cw6.TwoFragment;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by Erizo on 02.03.2018.
 */

public class HomeWork7Activity extends AppCompatActivity {

    private static final String TAG = HomeWork7Activity.class.getSimpleName();
    private PublishSubject<Integer> subject = PublishSubject.create();
    boolean isSub = false;
    int count = 0;
    private TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_work_7_activity);

        textView = findViewById(R.id.textView);
        findViewById(R.id.buttonFragmentRx).setOnClickListener(v -> changeFragment());
    }

    private void changeFragment() {
        if (!isSub){
            count++;
            subject.onNext(count);
            Log.d(TAG, String.valueOf(count));
            showFragment(SecondFragment.getInstance(subject, false));
            isSub = true;
        } else {
            count++;
            subject.onNext(count);
            Log.d(TAG, String.valueOf(count));
            showFragment(SecondFragment.getInstance(subject, true));
        }

    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerRx, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
