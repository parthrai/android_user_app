package com.example.userapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent i = getIntent();
        String email = i.getStringExtra("UserEmail");

        TextView lblWelcome = findViewById(R.id.lblWelcome);

        lblWelcome.setText(email);
    }
}
