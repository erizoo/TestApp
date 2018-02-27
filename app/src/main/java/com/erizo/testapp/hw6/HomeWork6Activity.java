package com.erizo.testapp.hw6;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.erizo.testapp.R;
import com.erizo.testapp.adapters.JsonAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Erizo on 27.02.2018.
 */

public class HomeWork6Activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private JsonTest jsonTest;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_work_6_activity);

        List<People> list = getListPeople();
        mRecyclerView = findViewById(R.id.json_recycler_view);

        // используем linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // создаем адаптер
        mAdapter = new JsonAdapter(list);
        mRecyclerView.setAdapter(mAdapter);

    }

    private List<People> getListPeople() {
        InputStream is = null;
        try {
            AssetManager assetManager = getAssets();
            is = assetManager.open("test.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            jsonTest = gson.fromJson(json, JsonTest.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonTest.getPeople();
    }
}
