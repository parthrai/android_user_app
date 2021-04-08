package com.example.userapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText txtEmail;
    EditText txtPassword;
    TextView lblMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        lblMsg = findViewById(R.id.lblMsg);
    }

    public void btnLoginClick(View v) throws JSONException {

       final String email = txtEmail.getText().toString();
       String password = txtPassword.getText().toString();

       String url = "https://android.parthrai.ca/api/android/login";



        JSONObject payload = new JSONObject();

        payload.put("email", email);
        payload.put("password", password);


        JSONArray arr_payload = new JSONArray();
        arr_payload.put(payload);




        RequestQueue queue = Volley.newRequestQueue(this);


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, url, arr_payload, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if(response.length() == 0){
                  lblMsg.setText("Please check your login details");
                  return;
                }


                startDashboardIntent();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(" Error - ", error.toString());
            }
        });

        queue.add(request);
    }

    public void btnRegisterClick(View v){

        Intent registerIntent = new Intent(this, RegisterActivity.class);
        startActivity(registerIntent);
    }

    public void startDashboardIntent(){

        Intent dashboardIntent = new Intent(this, DashboardActivity.class);
        startActivity(dashboardIntent);
    }
}
