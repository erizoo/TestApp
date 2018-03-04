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

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Erizo on 02.03.2018.
 */

public class HomeWork7Activity extends AppCompatActivity implements PublicSubjectContract {

    private static final String TAG = HomeWork7Activity.class.getSimpleName();

    private PublishSubject<Integer> subject = PublishSubject.create();
    private int count = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_work_7_activity);

        findViewById(R.id.buttonFragmentRx).setOnClickListener(v -> goSubject());
    }

    private void goSubject() {
        Log.d(TAG, String.valueOf(count));
        count++;
        subject.onNext(count);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerRx, FirstFragment.getInstance());
        transaction.commit();
    }

    @Override
    public Observable<Integer> getObservable() {
        return subject;
    }
}
