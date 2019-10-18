package com.example.watchistic;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder {
    ImageView Bracelet, Boitier, Cadran;
    TextView Votes, Creator, Nom;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        this.Boitier = itemView.findViewById(R.id.boitier);
        this.Bracelet = itemView.findViewById(R.id.bracelet);
        this.Cadran = itemView.findViewById(R.id.cadran);
        this.Creator = itemView.findViewById(R.id.Createur);
        this.Votes = itemView.findViewById(R.id.votes);
        this.Nom = itemView.findViewById(R.id.Nom);
    }
}
