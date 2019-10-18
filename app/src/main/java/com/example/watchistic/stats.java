package com.example.watchistic;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class stats extends AppCompatActivity {

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;

    private String urlCadran = "http://10.33.1.120:3000/statistics/getcadran";
    private String urlBoitier = "http://10.33.1.120:3000/statistics/getboitier";
    private String urlCouleur = "http://10.33.1.120:3000/statistics/getcouleur";
    private String urlMatiere = "http://10.33.1.120:3000/statistics/getmatiere";
    private String urlModele = "http://10.33.1.120:3000/statistics/getmodele";

    final List<String> listCadran = new ArrayList<String>();
    final List<String> listBoitier = new ArrayList<String>();
    final List<String> listCouleur = new ArrayList<String>();
    final List<String> listMatiere = new ArrayList<String>();
    final List<String> listModele = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);


        sendAndRequestResponseModele();




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(stats.this, Custom_Watch.class);
                startActivity(intent);
                //Toast.makeText(this, "ITEM 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    private void sendAndRequestResponse() {

        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, urlCadran, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println("Response : " + response.toString());

                try {
                    // get JSONObject from JSON file
                    JSONArray jsonA = new JSONArray(response.toString());

                    for (int i = 0; i < 3; i++) {
                        // create a JSONObject for fetching single user data
                        JSONObject image = jsonA.getJSONObject(i);
                        // fetch email and name and store it in arraylist
                        System.out.println("CADRAN : " + image.getString("Nom"));
                        listCadran.add(image.getString("Nom"));
                        listCadran.add(image.getString("NbCadran"));

                    }
                    TextView textVBracelet = (TextView) findViewById(R.id.textView14);
                    int pourcent = Integer.parseInt(listCadran.get(1)) * 100 / Integer.parseInt(listModele.get(0));
                    textVBracelet.setText(listCadran.get(0) + "  : " + String.valueOf(pourcent) + "%");

                    TextView textVBracelet2 = (TextView) findViewById(R.id.textView15);
                    int pourcent2 = Integer.parseInt(listCadran.get(3)) * 100 / Integer.parseInt(listModele.get(0));
                    textVBracelet2.setText(listCadran.get(2) + "  : " + String.valueOf(pourcent2) + "%");

                    TextView textVBracelet3 = (TextView) findViewById(R.id.textView16);
                    int pourcent3 = Integer.parseInt(listCadran.get(5)) * 100 / Integer.parseInt(listModele.get(0));
                    textVBracelet3.setText(listCadran.get(4) + "  : " + String.valueOf(pourcent3) + "%");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //Log.i(TAG,"Error :" + error.toString());
                System.out.println("Error : " + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
    }

    private void sendAndRequestResponseBoitier() {

        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, urlBoitier, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println("Response : " + response.toString());

                try {
                    // get JSONObject from JSON file
                    JSONArray jsonA = new JSONArray(response.toString());

                    for (int i = 0; i < 3; i++) {
                        // create a JSONObject for fetching single user data
                        JSONObject image = jsonA.getJSONObject(i);
                        // fetch email and name and store it in arraylist
                        System.out.println("CADRAN : " + image.getString("Nom"));
                        listBoitier.add(image.getString("Nom"));
                        listBoitier.add(image.getString("NbBoitier"));

                    }

                    TextView textVBracelet = (TextView) findViewById(R.id.textView17);
                    int pourcent = Integer.parseInt(listBoitier.get(1)) * 100 / Integer.parseInt(listModele.get(0));
                    textVBracelet.setText(listBoitier.get(0) + "  : " + String.valueOf(pourcent) + "%");

                    TextView textVBracelet2 = (TextView) findViewById(R.id.textView18);
                    int pourcent2 = Integer.parseInt(listBoitier.get(3)) * 100 / Integer.parseInt(listModele.get(0));
                    textVBracelet2.setText(listBoitier.get(2) + "  : " + String.valueOf(pourcent2) + "%");

                    TextView textVBracelet3 = (TextView) findViewById(R.id.textView19);
                    int pourcent3 = Integer.parseInt(listBoitier.get(5)) * 100 / Integer.parseInt(listModele.get(0));
                    textVBracelet3.setText(listBoitier.get(4) + "  : " + String.valueOf(pourcent3) + "%");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //Log.i(TAG,"Error :" + error.toString());
                System.out.println("Error : " + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
    }

    private void sendAndRequestResponseCouleur() {

        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, urlCouleur, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println("Response : " + response.toString());

                try {
                    // get JSONObject from JSON file
                    JSONArray jsonA = new JSONArray(response.toString());

                    for (int i = 0; i < 3; i++) {
                        // create a JSONObject for fetching single user data
                        JSONObject image = jsonA.getJSONObject(i);
                        // fetch email and name and store it in arraylist
                        System.out.println("CADRAN : " + image.getString("Nom"));
                        listCouleur.add(image.getString("Nom"));
                        listCouleur.add(image.getString("NbCouleur"));

                    }

                    TextView textVBracelet = (TextView) findViewById(R.id.textView20);
                    int pourcent = Integer.parseInt(listCouleur.get(1)) * 100 / Integer.parseInt(listModele.get(0));
                    textVBracelet.setText(listCouleur.get(0) + "  : " + String.valueOf(pourcent) + "%");

                    TextView textVBracelet2 = (TextView) findViewById(R.id.textView21);
                    int pourcent2 = Integer.parseInt(listCouleur.get(3)) * 100 / Integer.parseInt(listModele.get(0));
                    textVBracelet2.setText(listCouleur.get(2) + "  : " + String.valueOf(pourcent2) + "%");

                    TextView textVBracelet3 = (TextView) findViewById(R.id.textView22);
                    int pourcent3 = Integer.parseInt(listCouleur.get(5)) * 100 / Integer.parseInt(listModele.get(0));
                    textVBracelet3.setText(listCouleur.get(4) + "  : " + String.valueOf(pourcent3) + "%");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //Log.i(TAG,"Error :" + error.toString());
                System.out.println("Error : " + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
    }

    private void sendAndRequestResponseMatiere() {

        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, urlMatiere, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println("Response : " + response.toString());

                try {
                    // get JSONObject from JSON file
                    JSONArray jsonA = new JSONArray(response.toString());

                    for (int i = 0; i < 2; i++) {
                        // create a JSONObject for fetching single user data
                        JSONObject image = jsonA.getJSONObject(i);
                        // fetch email and name and store it in arraylist
                        System.out.println("CADRAN : " + image.getString("Nom"));
                        listMatiere.add(image.getString("Nom"));
                        listMatiere.add(image.getString("NbMatiere"));

                    }

                    TextView textVBracelet = (TextView) findViewById(R.id.textView23);
                    int pourcent = Integer.parseInt(listMatiere.get(1)) * 100 / Integer.parseInt(listModele.get(0));
                    textVBracelet.setText(listMatiere.get(0) + "  : " + String.valueOf(pourcent) + "%");

                    TextView textVBracelet2 = (TextView) findViewById(R.id.textView24);
                    int pourcent2 = Integer.parseInt(listMatiere.get(3)) * 100 / Integer.parseInt(listModele.get(0));
                    textVBracelet2.setText(listMatiere.get(2) + "  : " + String.valueOf(pourcent2) + "%");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //Log.i(TAG,"Error :" + error.toString());
                System.out.println("Error : " + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
    }

    private void sendAndRequestResponseModele() {

        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, urlModele, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println("Response : " + response.toString());

                try {
                    // get JSONObject from JSON file
                    listModele.add(response.toString());

                    sendAndRequestResponseCouleur();
                    sendAndRequestResponseMatiere();
                    sendAndRequestResponse();
                    sendAndRequestResponseBoitier();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //Log.i(TAG,"Error :" + error.toString());
                System.out.println("Error : " + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
    }


}
