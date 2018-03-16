package com.erizo.testapp.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erizo.testapp.R;
import com.erizo.testapp.hw6.People;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erizo on 27.02.2018.
 */

public class JsonAdapter extends RecyclerView.Adapter<JsonAdapter.ViewHolder> {

    private List<People> peopleList = new ArrayList<>();
    private List<People> filterList = new ArrayList<>();
    private static final String TAG = JsonAdapter.class.getSimpleName();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // наш пункт состоит только из одного TextView
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.tv_recycler_item);
        }
    }

    public JsonAdapter(List<People> list) {
        peopleList = list;
        filterList.addAll(peopleList);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item_from_json, parent, false);

        // тут можно программно менять атрибуты лэйаута (size, margins, paddings и др.)

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        People listItem = filterList.get(position);
        holder.mTextView.setText(listItem.getSurname());
        Log.d(TAG, "onBindViewHolder() position: " + position);
    }

    @Override
    public int getItemCount() {
        return (null != filterList ? filterList.size() : 0);
    }

    public void filter(final String text) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                filterList.clear();
                if (TextUtils.isEmpty(text)) {
                    filterList.addAll(peopleList);
                } else {
                    for (People item : peopleList) {
                        if (item.getSurname().toLowerCase().contains(text.toLowerCase())) {
                            filterList.add(item);
                        }
                    }
                }
            }
        }).start();
        notifyDataSetChanged();
    }
}
