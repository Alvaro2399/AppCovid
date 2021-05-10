package com.example.appcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuOpciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);
    }

    @Override
    public void onBackPressed() {

    }

    //Metodo para pasar de ventana
    public void VolverMenu(View view){
        Intent volverMenu1 = new Intent(this, EvaluacionInicial.class);
        startActivity(volverMenu1);
    }

    //Metodo para pasar de ventana
    public void CerrarSesion1(View view){
        Intent Cerrar1 = new Intent(this, MainActivity.class);
        startActivity(Cerrar1);
    }

    //Metodo para pasar de ventana
    public void ActualizarPerfil1(View view){
        Intent Actualizar = new Intent(this, ActualizarPerfil.class);
        startActivity(Actualizar);
    }


}