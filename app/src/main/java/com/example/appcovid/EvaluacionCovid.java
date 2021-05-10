package com.example.appcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EvaluacionCovid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion_covid);
    }

    @Override
    public void onBackPressed() {

    }

    //Metodo para pasar de ventana
    public void ContinuarPagPrin(View view){
            Intent contpagprin = new Intent(this, PaginaPrincipal.class);
        startActivity(contpagprin);
    }




}