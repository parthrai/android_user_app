package com.example.userapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
}
