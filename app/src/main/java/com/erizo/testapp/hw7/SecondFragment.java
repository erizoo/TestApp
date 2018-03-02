package com.erizo.testapp.hw7;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erizo.testapp.R;
import com.erizo.testapp.cw6.TwoFragment;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by Erizo on 02.03.2018.
 */

public class SecondFragment extends Fragment {

    private TextView textView;
    private PublishSubject<Integer> subject;
    private Integer i;

    public static SecondFragment getInstance(PublishSubject<Integer> subject, boolean b){
        if (!b) {
            subject.subscribe();
        }

        return new SecondFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        textView = getActivity().findViewById(R.id.textView);
        return getLayoutInflater().inflate(R.layout.two_fragment, container, false);
    }
}
