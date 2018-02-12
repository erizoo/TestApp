package com.erizo.testapp.hw3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.erizo.testapp.BuildConfig;
import com.erizo.testapp.R;

/**
 * Created by Erizo on 12.02.2018.
 */

public class HomeWork3Activity extends AppCompatActivity {

    private Button takePictureButton, takeRoundPictureButton;
    private EditText editTextUrl;
    private ImageView imageView;
    private TextView textViewForBuild;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_work_3_activity);

        editTextUrl = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView);
        textViewForBuild = findViewById(R.id.textViewForBuild);

        takePictureButton = findViewById(R.id.take_picture_button);
        takeRoundPictureButton = findViewById(R.id.take_picture_round_button);
        takePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(HomeWork3Activity.this).load(editTextUrl.getText().toString()).into(imageView);
                textViewForBuild.setText(BuildConfig.API_ENDPOINT);
            }
        });

        takeRoundPictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(HomeWork3Activity.this)
                        .load("https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/68dd54ca-60cf-4ef7-898b-26d7cbe48ec7/10-dithering-opt.jpg")
                        .apply(RequestOptions.circleCropTransform()).into(imageView);
                textViewForBuild.setText(BuildConfig.API_ENDPOINT);
            }
        });


    }
}
