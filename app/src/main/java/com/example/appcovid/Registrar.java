package com.example.appcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Registrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
    }

   //Metodo para pasar de ventana
    public void VolverVentana(View view){
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
    }

}