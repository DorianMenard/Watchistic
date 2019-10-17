package com.example.watchistic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<ModelMontre> ListModels;

    public MyAdapter(Context c, ArrayList<ModelMontre> listModels) {
        this.c = c;
        ListModels = listModels;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.montre, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.Nom.setText(ListModels.get(position).getNom());
        holder.Votes.setText( Double.toString(ListModels.get(position).getVotesTotal()) );
        holder.Creator.setText(Integer.toString(ListModels.get(position).getCreator_id())  );
        holder.Cadran.setImageResource(ListModels.get(position).getCadran());
        holder.Bracelet.setImageResource(ListModels.get(position).getBracelet());
        holder.Boitier.setImageResource(ListModels.get(position).getBoitier());
    }

    @Override
    public int getItemCount() {
        return ListModels.size();
    }
}
