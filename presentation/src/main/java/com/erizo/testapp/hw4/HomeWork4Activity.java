package com.erizo.testapp.hw4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.erizo.testapp.R;

/**
 * Created by Erizo on 16.02.2018.
 */

public class HomeWork4Activity extends AppCompatActivity {

    private Button button;
    private Button buttonClock;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_work_4_1_activity);

        button = findViewById(R.id.button4);
        buttonClock = findViewById(R.id.button5);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(HomeWork4Activity.this, OwlActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
        });
        buttonClock.setOnClickListener(v -> {
            Intent intent = new Intent(HomeWork4Activity.this, ClockActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
        });


    }
}
