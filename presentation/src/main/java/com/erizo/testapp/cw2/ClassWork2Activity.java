package com.erizo.testapp.cw2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.erizo.testapp.R;
import com.erizo.testapp.cw1.ClassWork1Activity;
import com.erizo.testapp.cw1.Singleton;

/**
 * Created by Erizo on 09.02.2018.
 */

public class ClassWork2Activity extends AppCompatActivity {

    private static final String TAG = ClassWork1Activity.class.getSimpleName();
    private static final String KEY_TEXT = "KEY_TEXT";
    private Button button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_work_2_activity);
        Log.e(TAG, "onCreate");

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ClassWork1Activity.class);
                intent.putExtra(KEY_TEXT, "Hi");
                startActivity(intent);
            }
        });
    }
}
