package com.erizo.testapp.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.erizo.testapp.R;
import com.erizo.testapp.hw1.HomeWork1Activity;
import com.erizo.testapp.hw2.HomeWork2Activity;
import com.erizo.testapp.hw3.HomeWork3Activity;
import com.erizo.testapp.hw4.HomeWork4Activity;
import com.erizo.testapp.hw5.HomeWork5Activity;
import com.erizo.testapp.hw6.HomeWork6Activity;
import com.erizo.testapp.hw7.HomeWork7Activity;
import com.erizo.testapp.hw8.HomeWork8Activity;
import com.erizo.testapp.user.DataBinding;

/**
 * Created by Erizo on 07.02.2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] mDataset;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public Button buttonForActivity;

        public ViewHolder(View v) {
            super(v);
            buttonForActivity = v.findViewById(R.id.button_for_activity);
            buttonForActivity.setOnClickListener(v1 -> {
                int count = getAdapterPosition();
                switch (count) {
                    case 0:
                        Intent intent = new Intent(v1.getContext(), HomeWork1Activity.class);
                        v1.getContext().startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(v1.getContext(), HomeWork2Activity.class);
                        v1.getContext().startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(v1.getContext(), HomeWork3Activity.class);
                        v1.getContext().startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(v1.getContext(), HomeWork4Activity.class);
                        v1.getContext().startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(v1.getContext(), HomeWork5Activity.class);
                        v1.getContext().startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(v1.getContext(), HomeWork6Activity.class);
                        v1.getContext().startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(v1.getContext(), HomeWork7Activity.class);
                        v1.getContext().startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(v1.getContext(), HomeWork8Activity.class);
                        v1.getContext().startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(v1.getContext(), DataBinding.class);
                        v1.getContext().startActivity(intent8);
                        break;
                    default:
                        break;
                }

            });
        }
    }

    public RecyclerAdapter(String[] dataset) {
        mDataset = dataset;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.buttonForActivity.setText("Домашнее задание №" + (position + 1));
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
