package com.erizo.testapp.hw1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.erizo.testapp.R;

/**
 * Created by Erizo on 05.02.2018.
 */

public class HomeWork1Activity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonStart;
    private TextView firstTextView, secondTextView;
    private String firstText, secondText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_work_1_activity);

        firstTextView = findViewById(R.id.first_text_view);
        secondTextView = findViewById(R.id.second_text_view);

        buttonStart = findViewById(R.id.button_start);
//        buttonStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                changeText();
//            }
//        });
//        firstTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                changeText();
//            }
//        });
//        secondTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                changeText();
//            }
//        });
        buttonStart.setOnClickListener(this);
        firstTextView.setOnClickListener(this);
        secondTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_start:
                changeText();
                break;
            case R.id.first_text_view:
                changeText();
                break;
            case R.id.second_text_view:
                changeText();
                break;
            default:
                break;
        }
    }

    public void changeText(){
        firstText = firstTextView.getText().toString();
        secondText = secondTextView.getText().toString();
        firstTextView.setText(secondText);
        secondTextView.setText(firstText);
    }

    public void changeText(View view) {
        firstText = firstTextView.getText().toString();
        secondText = secondTextView.getText().toString();
        firstTextView.setText(secondText);
        secondTextView.setText(firstText);
    }
}
