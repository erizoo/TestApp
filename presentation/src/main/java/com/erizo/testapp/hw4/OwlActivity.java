package com.erizo.testapp.hw4;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.erizo.testapp.R;

/**
 * Created by Erizo on 19.02.2018.
 */

public class OwlActivity extends AppCompatActivity {

    private ImageView imageView1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_work_owl_activity);
        final int[] imageArray = {R.drawable.sova_anmation_2,
                R.drawable.sova_anmation_3,
                R.drawable.sova_anmation_1};

        imageView1 = findViewById(R.id.imageView2);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;
            public void run() {
                imageView1.setImageResource(imageArray[i]);
                i++;
                if (i > imageArray.length - 1) {
                    i = 0;
                }
                handler.postDelayed(this, 300);
            }
        };
        handler.postDelayed(runnable, 1000);
    }

}
