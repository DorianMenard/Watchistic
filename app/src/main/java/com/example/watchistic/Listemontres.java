package com.example.watchistic;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Listemontres extends AppCompatActivity {
    RecyclerView myrecyclerview;
    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myrecyclerview= findViewById(R.id.recycler_view);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(this, LoadList());

        myrecyclerview.setAdapter(myAdapter);
    }

    private ArrayList<ModelMontre> LoadList(){

        ArrayList<ModelMontre> maList = new ArrayList<>();
        ModelMontre modelMontre = new ModelMontre();
        modelMontre.setNom("Model");
        modelMontre.setVotesTotal(50);
        modelMontre.setCreator_id(1);
        modelMontre.setBoitier(R.drawable.socle1);
        modelMontre.setBracelet(R.drawable.bracelet1);
        modelMontre.setCadran(R.drawable.cadran1);
        maList.add(modelMontre);

        ModelMontre modelMontre2 = new ModelMontre();
        modelMontre2.setNom("Model 2 ");
        modelMontre2.setVotesTotal(200);
        modelMontre2.setCreator_id(3);
        modelMontre2.setBoitier(R.drawable.socle2);
        modelMontre2.setBracelet(R.drawable.bracelet2);
        modelMontre2.setCadran(R.drawable.cadran5);
        maList.add(modelMontre2);

        return maList;
    }
}
