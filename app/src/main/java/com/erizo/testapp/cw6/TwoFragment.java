package com.erizo.testapp.cw6;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erizo.testapp.R;

/**
 * Created by Erizo on 26.02.2018.
 */

public class TwoFragment extends Fragment {

    public static  TwoFragment getInstance(){
        return new TwoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.two_fragment, container, false);
    }
}
