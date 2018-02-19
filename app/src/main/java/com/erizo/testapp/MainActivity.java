package com.erizo.testapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.erizo.testapp.adapters.RecyclerAdapter;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Erizo on 07.02.2018.
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        String[] myDataset = getDataSet();

        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    private String[] getDataSet() {

        String[] mDataSet = new String[5];
        for (int i = 0; i < 5; i++) {
            mDataSet[i] = "item" + i;
        }
        return mDataSet;
    }
}
