package com.example.appcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EvaluacionInicial extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaaluacion_inicial);


    }



    @Override
    public void onBackPressed() {

    }


    //Metodo para pasar de ventana
    public void IrEvaluacionCovid(View view){
        Intent evacovid = new Intent(this, EvaluacionCovid.class);
        startActivity(evacovid);
    }

    //Metodo para pasar de ventana
    public void IrOpciones1(View view){
        Intent opcione1 = new Intent(this, MenuOpciones.class);
        startActivity(opcione1);
    }









}