package com.erizo.testapp.hw7;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erizo.testapp.R;

import io.reactivex.disposables.Disposable;

/**
 * Created by Erizo on 02.03.2018.
 */

public class FirstFragment extends Fragment {

    private static final String TAG = FirstFragment.class.getSimpleName();

    private TextView textView;

    private PublicSubjectContract publicSubjectContract;
    private Disposable disposable;

    public static FirstFragment getInstance() {
        return new FirstFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.two_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        textView = view.findViewById(R.id.textView);
        view.setOnClickListener(v -> {subscribe();
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onPause() {
        if (disposable != null) {
            disposable.dispose();
        }
        super.onPause();
    }

    @Override
    public void onAttach(Context context) {
        Activity activity = getActivity();
        if (activity != null) {
            publicSubjectContract = (PublicSubjectContract) activity;
        }
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        publicSubjectContract = null;
    }

    private void subscribe(){
        disposable = publicSubjectContract
                .getObservable()
                .doOnNext(integer -> {
                })
                .map(String::valueOf)
                .subscribe(integer -> {
                    Log&d(TAG, String.valueOf(integer));
                    textView.setText(integer);
                    // сюда прилетают даные
                }, throwable -> {
                    // сюда прилетают ошибки
                });
    }

}
