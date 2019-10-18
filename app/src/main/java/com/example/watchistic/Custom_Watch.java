package com.example.watchistic;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
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

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Custom_Watch extends AppCompatActivity {

    public String CouleurBracelet;
    public String MatiereBracelet;
    public String CouleurCadran;
    public String CouleurSocle;

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    //10.33.1.120
    private String urlBracelet = "http://10.33.1.120:3000/bracelet/getAll";
    private String urlBoitier = "http://10.33.1.120:3000/boitier/getAll";
    private String urlCadran = "http://10.33.1.120:3000/cadran/getAll";

    private ImageView imvBracelet = null;
    private ImageView imvSocle = null;
    private ImageView imvCadran = null;

    private int idBracelet = 0;
    private int idBoitier = 0;
    private int idCadran = 0;

    final List<String> list = new ArrayList<String>();
    final List<String> list2 = new ArrayList<String>();
    final List<String> listCC = new ArrayList<String>();
    final List<String> listCS = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customwatch);

        imvBracelet = (ImageView) findViewById(R.id.imageView);
        imvSocle = (ImageView) findViewById(R.id.imageView2);
        imvCadran = (ImageView) findViewById(R.id.imageView3);
        final EditText nomMontre = (EditText) findViewById(R.id.editText);

        try {
            InputStream ims = getAssets().open("Bracelet/bleu-marine.png");
            Drawable d = Drawable.createFromStream(ims, null);
            imvBracelet.setImageDrawable(d);
            ims.close();

            InputStream imsS = getAssets().open("Boitier/boitier-or.png");
            Drawable dS = Drawable.createFromStream(imsS, null);
            imvSocle.setImageDrawable(dS);
            imsS.close();

            InputStream imsC = getAssets().open("Cadran/cadran-blanc-noir.png");
            Drawable dC = Drawable.createFromStream(imsC, null);
            imvCadran.setImageDrawable(dC);
            imsC.close();
        } catch (IOException e) {

        }
        requestBracelet();
        requestSocle();
        requestCadran();
        //requestBracelet();

        //Request post Submit
        String url = "http://192.168.1.27:3000/soumettre/submit";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        //Log.d("Error.Response", r);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Bracelet_id", String.valueOf(idBracelet));
                params.put("Cadran_id", String.valueOf(idCadran));
                params.put("Boitier_id", String.valueOf(idBoitier));
                params.put("Nom", "TestSubmit");
                params.put("Utilisateur_id", "1");

                return params;
            }
        };
        mRequestQueue.add(postRequest);


//Spinner Couleur Bracelet




//Spinner Matiere Bracelet

        //Spinner Couleur cadran




        Button validateCustom = ( Button ) findViewById(R.id.ValidateCustom);
        validateCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Bracelet : "  +  idBracelet + ", " + " Cadran : " + idCadran + " Socle : " + idBoitier);
                System.out.println("Montre name = " + nomMontre.getText());
                final String nomM = nomMontre.getText().toString();

                //Request post Submit
                String url = "http://10.33.1.120:3000/soumettre/submit";
                StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // response
                                Log.d("Response", response);
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                //Log.d("Error.Response", r);
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("Bracelet_id", String.valueOf(idBracelet));
                        params.put("Cadran_id", String.valueOf(idCadran));
                        params.put("Boitier_id", String.valueOf(idBoitier));
                        params.put("Nom", nomM);
                        params.put("Utilisateur_id", "1");

                        return params;
                    }
                };
                mRequestQueue.add(postRequest);


            }
        });

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
                //Toast.makeText(this, "ITEM 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Intent intent = new Intent(Custom_Watch.this, stats.class);
                startActivity(intent);
                return true;
            case R.id.item3:
                Intent intenté = new Intent(Custom_Watch.this, Listemontres.class);
                startActivity(intenté);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    void requestBracelet() {
        //final List<String> list2 = new ArrayList<String>();
        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, urlBracelet, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println("Response : " + response.toString());

                try {
                    // get JSONObject from JSON file
                    JSONArray jsonA = new JSONArray(response.toString());

                    for (int i = 0; i < jsonA.length(); i++) {
                        // create a JSONObject for fetching single user data
                        JSONObject image = jsonA.getJSONObject(i);
                        // fetch email and name and store it in arraylist
                        System.out.println("ImagePath : " + image.getString("Image"));
                        String img = image.getString("Image");
                        String im = img.substring(17, (img.length() - 4));
                        String name = image.getString("Nom");
                        //list.add(image.getString("Image"));
                        list.add(im);
                        list2.add(name);
                    }
                    createAdapteur();
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

    void requestSocle() {
        //final List<String> list2 = new ArrayList<String>();
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

                    for (int i = 0; i < jsonA.length(); i++) {
                        // create a JSONObject for fetching single user data
                        JSONObject image = jsonA.getJSONObject(i);
                        // fetch email and name and store it in arraylist
                        System.out.println("ImagePath : " + image.getString("Image"));
                        String img = image.getString("Image");
                        String im = img.substring(24, (img.length() - 4));
                        //list.add(image.getString("Image"));
                        listCS.add(im);
                    }
                    createAdapteurBoitier();
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


    void requestCadran() {
        //final List<String> list2 = new ArrayList<String>();
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

                    for (int i = 0; i < jsonA.length(); i++) {
                        // create a JSONObject for fetching single user data
                        JSONObject image = jsonA.getJSONObject(i);
                        // fetch email and name and store it in arraylist
                        System.out.println("ImagePath : " + image.getString("Image"));
                        String img = image.getString("Image");
                        String im = img.substring(22, (img.length() - 4));
                        //list.add(image.getString("Image"));
                        listCC.add(im);
                    }
                    createAdapteurCadran();
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

    void createAdapteur() {
        Spinner spinnerCouleurBracelet = (Spinner) findViewById(R.id.spinnerCouleurBracelet);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCouleurBracelet.setAdapter(dataAdapter);

        spinnerCouleurBracelet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                CouleurBracelet = (String)parentView.getAdapter().getItem(position);
                idBracelet = position + 1;
                System.out.println(list.get(position));
                //CouleurBracelet = list.get(position);

                try {
                    Log.d("ASSET","Bracelet/Cuir/" + list.get(position) + ".png");
                    InputStream imsS = getAssets().open("Bracelet/" + list.get(position) + ".png");

                    Drawable dS = Drawable.createFromStream(imsS, null);
                    imvBracelet.setImageDrawable(dS);
                    imsS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    void createAdapteurCadran() {
        Spinner spinnerCouleurCadran = (Spinner) findViewById(R.id.spinner3);
        //final List<String> listCC = new ArrayList<String>();

        ArrayAdapter<String> dataAdapterCC = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listCC);
        dataAdapterCC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCouleurCadran.setAdapter(dataAdapterCC);

        spinnerCouleurCadran.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                System.out.println(listCC.get(position));
                CouleurCadran = listCC.get(position);
                idCadran = position + 1;

                try {
                    InputStream imsS = getAssets().open("Cadran/cadran-" + CouleurCadran + ".png");
                    Drawable dS = Drawable.createFromStream(imsS, null);
                    imvCadran.setImageDrawable(dS);
                    imsS.close();
                } catch (IOException e) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    void createAdapteurBoitier() {
//Spinner Couleur socle
        Spinner spinnerCouleurSocle = (Spinner) findViewById(R.id.spinner4);
        //final List<String> listCS = new ArrayList<String>();

        ArrayAdapter<String> dataAdapterCS = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listCS);
        dataAdapterCS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCouleurSocle.setAdapter(dataAdapterCS);

        spinnerCouleurSocle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                CouleurSocle = (String)parentView.getAdapter().getItem(position);
                idBoitier = position + 1;
                System.out.println(listCS.get(position));
                //CouleurSocle = listCS.get(position);

                try {
                    InputStream imsS = getAssets().open("Boitier/boitier-" + CouleurSocle + ".png");
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
    }
}
