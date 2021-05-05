package com.example.appcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PaginaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);
    }

    //Metodo para pasar de ventana
    public void DescarteCovid(View view){
        Intent descarte = new Intent(this, EvaluacionCovid.class);
        startActivity(descarte);
    }


}