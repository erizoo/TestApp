package adapters;

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
            buttonForActivity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = getAdapterPosition();
                    switch (count) {
                        case 0:
                            Intent intent = new Intent(v.getContext(), HomeWork1Activity.class);
                            v.getContext().startActivity(intent);
                            break;
                        case 1:
                            Intent intent1 = new Intent(v.getContext(), HomeWork2Activity.class);
                            v.getContext().startActivity(intent1);
                            break;
                        default:
                            break;
                    }

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
