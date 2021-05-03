package com.example.appcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Metodo para pasar de ventana
    public void CrearCuenta(View view){
        Intent crearcuenta = new Intent(this, Registrar.class);
        startActivity(crearcuenta);
    }
    public void IniciarSesion(View view){
        Intent iniciarsesion = new Intent(this, EvaluacionInicial.class);
        startActivity(iniciarsesion);
    }

}