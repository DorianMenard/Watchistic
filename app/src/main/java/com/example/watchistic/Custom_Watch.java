package com.example.watchistic;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Custom_Watch extends AppCompatActivity {

    public String CouleurBracelet;
    public String MatiereBracelet;
    public String CouleurCadran;
    public String CouleurSocle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customwatch);

        final ImageView imvBracelet = (ImageView) findViewById(R.id.imageView);
        final ImageView imvSocle = (ImageView) findViewById(R.id.imageView2);
        final ImageView imvCadran = (ImageView) findViewById(R.id.imageView3);

        try {
            InputStream ims = getAssets().open("Bracelet/2.png");
            Drawable d = Drawable.createFromStream(ims, null);
            imvBracelet.setImageDrawable(d);
            ims.close();

            InputStream imsS = getAssets().open("Socle/2.png");
            Drawable dS = Drawable.createFromStream(imsS, null);
            imvSocle.setImageDrawable(dS);
            imsS.close();

            InputStream imsC = getAssets().open("Cadran/10.png");
            Drawable dC = Drawable.createFromStream(imsC, null);
            imvCadran.setImageDrawable(dC);
            imsC.close();
        } catch (IOException e) {

        }


//Spinner Couleur Bracelet
        Spinner spinnerCouleurBracelet = (Spinner) findViewById(R.id.spinnerCouleurBracelet);
        final List<String> list = new ArrayList<String>();
        list.add("Marron");
        list.add("Rouge");
        list.add("Noir");
        list.add("Noir_2");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCouleurBracelet.setAdapter(dataAdapter);

        spinnerCouleurBracelet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                System.out.println(list.get(position));
                CouleurBracelet = list.get(position);
                position = position + 1;
                try {
                    InputStream ims = getAssets().open("Bracelet/" + position + ".png");
                    Drawable d = Drawable.createFromStream(ims, null);
                    imvBracelet.setImageDrawable(d);
                    ims.close();
                } catch (IOException e) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


//Spinner Matiere Bracelet
        Spinner spinnerMatiereBracelet = (Spinner) findViewById(R.id.spinnerMatiereBracelet);
        final List<String> listMB = new ArrayList<String>();
        listMB.add("Cuir");
        listMB.add("Plastique");
        ArrayAdapter<String> dataAdapterMB = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMB);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMatiereBracelet.setAdapter(dataAdapterMB);

        spinnerMatiereBracelet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                System.out.println(listMB.get(position));
                MatiereBracelet = listMB.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        //Spinner Couleur cadran
        Spinner spinnerCouleurCadran = (Spinner) findViewById(R.id.spinner3);
        final List<String> listCC = new ArrayList<String>();
        listCC.add("Vert");
        listCC.add("Rouge");
        ArrayAdapter<String> dataAdapterCC = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listCC);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCouleurCadran.setAdapter(dataAdapterCC);

        spinnerCouleurCadran.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                System.out.println(listCC.get(position));
                CouleurCadran = listCC.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


        //Spinner Couleur socle
        Spinner spinnerCouleurSocle = (Spinner) findViewById(R.id.spinner4);
        final List<String> listCS = new ArrayList<String>();
        listCS.add("Gris");
        listCS.add("Dore");
        listCS.add("Gris_2");

        ArrayAdapter<String> dataAdapterCS = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listCS);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCouleurSocle.setAdapter(dataAdapterCS);

        spinnerCouleurSocle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                System.out.println(listCS.get(position));
                CouleurSocle = listCS.get(position);

                position = position + 1;
                try {
                    InputStream imsS = getAssets().open("Socle/" + position + ".png");
                    Drawable dS = Drawable.createFromStream(imsS, null);
                    imvSocle.setImageDrawable(dS);
                    imsS.close();
                } catch (IOException e) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


        Button validateCustom = ( Button ) findViewById(R.id.ValidateCustom);
        validateCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Bracelet : "  +  CouleurBracelet + ", " + MatiereBracelet + " Cadran : " + CouleurCadran + " Socle : " + CouleurSocle);

            }
        });

    }
}
