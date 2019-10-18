package com.example.watchistic;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Listemontres extends AppCompatActivity {
    private String urlModels = "http://10.33.4.65:3000/statistics/getvote";
    RecyclerView myrecyclerview;
    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("titre", "ON CREATE LOG");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listedesmontres);
//        requestBracelet();
        myrecyclerview= findViewById(R.id.recycler_view);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        Log.d("Log 1" , "");
        myAdapter = new MyAdapter(this, LoadList());

        myrecyclerview.setAdapter(myAdapter);
    }

    private ArrayList<ModelMontre> LoadList(){
        final ArrayList<ModelMontre> maList = new ArrayList<>();
        RequestQueue mRequestQueue = Volley.newRequestQueue(this);

        StringRequest mStringRequest = new StringRequest(Request.Method.GET, urlModels, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonA = new JSONArray(response.toString());
                    Drawable braceletDrawable = null;
                    Drawable boitierDrawable = null;
                    Drawable cadranDrawable = null;
                    for (int i = 0; i < jsonA.length(); i++) {
                        try {
                            String BraceletUrl = jsonA.getJSONObject(i).getString("image_bracelet") ;
                            InputStream ims = getAssets().open( BraceletUrl.substring( 8 ));
                            braceletDrawable = Drawable.createFromStream(ims, null);

                            String BoitierUrl = jsonA.getJSONObject(i).getString("image_boitier") ;
                            InputStream ims2 = getAssets().open(BoitierUrl.substring(8));
                            boitierDrawable = Drawable.createFromStream(ims2, null);

                            String cadranUrl = jsonA.getJSONObject(i).getString("image_cadran") ;
                            InputStream ims3 = getAssets().open(cadranUrl.substring(8));
                            cadranDrawable = Drawable.createFromStream(ims3, null);
                        }catch (Exception e){
                            Log.d("exception :", "");
                        }

                        maList.add( new ModelMontre ( braceletDrawable , boitierDrawable, cadranDrawable, jsonA.getJSONObject(i).getString("Createur") , jsonA.getJSONObject(i).getDouble("NbVote") , jsonA.getJSONObject(i).getString("Nom") ));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Error : " + error.toString());
            }
        });
        mRequestQueue.add(mStringRequest);

        return maList;
    }

}
