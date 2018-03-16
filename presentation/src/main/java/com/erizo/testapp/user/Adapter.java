package com.erizo.testapp.user;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Erizo on 14.03.2018.
 */

public class Adapter {
    @BindingAdapter("android:src")
    //передача массива атрибутов
    public static void setImageUrl(@NonNull ImageView imageView, @NonNull String url) {
        Context context = imageView.getContext();

        Glide.with(context)
                .load(url)
                .into(imageView);
    }
}