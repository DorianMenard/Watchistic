package com.example.watchistic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "http://10.33.1.120:3000/bracelet/getAll";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = ( Button ) findViewById(R.id.okbutton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("OnClick Button");
                //sendAndRequestResponse();

                Intent intent = new Intent(MainActivity.this, Custom_Watch.class);
                startActivity(intent);
            }
        });
    }



    private void sendAndRequestResponse() {

        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
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

                    }
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
}
