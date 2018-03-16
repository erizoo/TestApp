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

    public static final String KEY_COUNTER = "COUNTER";
    private TextView consumerTextView;
    private PublicSubjectContract contract;
    private Disposable disposable;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.two_fragment, container, false);
        consumerTextView = v.findViewById(R.id.textView);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            consumerTextView.setText(savedInstanceState.getString(KEY_COUNTER));
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_COUNTER, consumerTextView.getText().toString());
    }

    public static FirstFragment getInstance() {
        Bundle bundle = new Bundle();
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if (activity != null && activity instanceof PublicSubjectContract) {
            contract = (PublicSubjectContract) activity;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        disposable.dispose();
    }

    @Override
    public void onResume() {
        super.onResume();
        disposable = contract.getObservable().map(String::valueOf).subscribe(s -> consumerTextView.setText(s));
    }
}
