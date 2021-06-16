package com.example.myapplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    List<listentity> allWords = new ArrayList<>();

    public void setAllWords(List<listentity> allWords) {
        this.allWords = allWords;
    }

    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.c,parent,false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull  Adapter.MyViewHolder holder, int position) {
        listentity listentity = allWords.get(position);
        holder.textViewnum.setText(listentity.getpSize());
        holder.textViewname.setText(listentity.getGname());
    }

    @Override
    public int getItemCount() {
        return allWords.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textViewnum,textViewname;
        int texttime;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            textViewnum = itemView.findViewById(R.id.textViewnum);
            textViewname = itemView.findViewById(R.id.textViewname);


        }
    }
}
