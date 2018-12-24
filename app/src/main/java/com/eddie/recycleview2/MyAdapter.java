package com.eddie.recycleview2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<String> list;

    public MyAdapter() {

        list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {

            list.add("Name " + i);
        }
    }

    public void remove(int pos) {

        list.remove(pos);
//        notifyDataSetChanged();
        notifyItemRemoved(pos);
    }

    public void move(int from, int to) {

        String str = list.remove(from);
        list.add(to, str);
        notifyItemMoved(from, to);
//        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Log.d("MY_TAG", "onCreateViewHolder: ");

        RecyclerView.ViewHolder holder;

        if (i == 0) {

            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.my_row, viewGroup, false);

            holder = new MyViewHolder(view);

        } else {

            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.my_row, viewGroup, false);

            holder = new MyViewHolder(view);
        }

//        return new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder myViewHolder, int i) {

        String name = list.get(i);

        if (myViewHolder instanceof MyViewHolder) {

            ((MyViewHolder) myViewHolder).nameTxt.setText(name);

        } else if (myViewHolder instanceof MyOddViewHolder) {

            ((MyOddViewHolder) myViewHolder).nameTxt.setText(name);
        }
//        myViewHolder.nameTxt.setText(name);

//        if (i % 2 != 0) {
//
//            myViewHolder.nameTxt.setGravity(Gravity.END);
//        }
    }

    @Override
    public int getItemViewType(int position) {

        //return position % 2;
        return 0;
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTxt;

        public MyViewHolder(View itemView) {

            super(itemView);
            nameTxt = itemView.findViewById(R.id.name_txt);
        }
    }

    class MyOddViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTxt;

        public MyOddViewHolder(@NonNull View itemView) {

            super(itemView);
            nameTxt = itemView.findViewById(R.id.name_txt);
        }
    }
}
