package com.pucpr.cadastropessoas.controller;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.pucpr.cadastropessoas.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setTitle("Ficha");
    }
}
