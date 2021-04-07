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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText txtEmail;
    EditText txtPassword;
    TextView lblMsg;
    private RequestQueue mQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        lblMsg = findViewById(R.id.lblMsg);
    }

    public void btnLoginClick(View v){


        if(txtEmail.getText().toString().equals("user@valid.com") && txtPassword.getText().toString().equals("testpass")){
            // show a success msg

            Intent dashboardIntent = new Intent(this, DashboardActivity.class);
            dashboardIntent.putExtra("UserEmail", txtEmail.getText().toString());
            startActivity(dashboardIntent);

        }else{
            // show an error msg
            lblMsg.setText("Invalid User");
        }
    }

    public void btnRegisterClick(View v){

        Intent registerIntent = new Intent(this, RegisterActivity.class);
        startActivity(registerIntent);
    }

    public void json(View v){

        mQueue = Volley.newRequestQueue(this);

        String url = "https://jsonplaceholder.typicode.com/todos";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("@@@##$#%%-", "ResponseCheck :");

                        try {

                            JSONArray jsonarray;
                                jsonarray = new JSONArray(response);
                                for (int i = 0; i < jsonarray.length(); i++) {
                                    JSONObject mJsonObject = jsonarray.optJSONObject(i);
                                    Log.d("OutPut", mJsonObject.optString("transactionId"));
                                }
                        } catch (JSONException e) {
                            Log.d("$$$$$4","here");

                            e.printStackTrace();
                            Log.d("$$$$$4",response.toString());
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.d("$$$$$4","response.toString()");

            }
        });


        mQueue.add(request);

    }
}
