package com.example.appcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuOpciones2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones2);
    }

    //Metodo para pasar de ventana
    public void VolverMenu2(View view){
        Intent volverMenu2 = new Intent(this, PaginaPrincipal.class);
        startActivity(volverMenu2);
    }

    //Metodo para pasar de ventana
    public void CerrarSesion2(View view){
        Intent Cerrar2 = new Intent(this, MainActivity.class);
        startActivity(Cerrar2);
    }

    //Metodo para pasar de ventana
    public void ActualizarPerfil2(View view){
        Intent Actualizar2 = new Intent(this, ActualizarPerfil.class);
        startActivity(Actualizar2);
    }


}