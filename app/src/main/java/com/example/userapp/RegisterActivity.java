package com.example.userapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    EditText edName;
    EditText edEmail;
    EditText edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edName = findViewById(R.id.txtName);
        edEmail = findViewById(R.id.txtEmail);
        edPassword = findViewById(R.id.txtPassword);

    }


    public void btnRegisterClick(View v){

        String email = edEmail.getText().toString();
        String name = edName.getText().toString();
        String password = edPassword.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://android.parthrai.ca/api/android/register";

        JSONObject payload = new JSONObject();

        try {
            payload.put("email", email);
            payload.put("name", name);
            payload.put("password", password);
            payload.put("dev", "parth");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest register = new JsonObjectRequest(Request.Method.POST, url, payload, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(" Response --- ", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(" ERROR --- ", error.toString());
            }
        });

        queue.add(register);


    }
}
