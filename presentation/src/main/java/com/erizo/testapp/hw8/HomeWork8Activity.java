package com.erizo.testapp.hw8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.erizo.testapp.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Created by Erizo on 14.03.2018.
 */

public class HomeWork8Activity extends AppCompatActivity {

    private Disposable d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_work_8_activity);
        Observable<Long> myObservable = Observable.interval(500, TimeUnit.MILLISECONDS);
        TextView textView = findViewById(R.id.timer_textView);
        d = myObservable.filter(l -> l % 2 == 0).observeOn(AndroidSchedulers.mainThread()).subscribe(l -> textView.setText(String.valueOf(l)));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!d.isDisposed()) {
            d.dispose();
        }
    }
}

