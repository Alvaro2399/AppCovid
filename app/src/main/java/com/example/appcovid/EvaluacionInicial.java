package com.example.appcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class EvaluacionInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaaluacion_inicial);
    }

    //Metodo para pasar de ventana
    public void IrEvaluacionCovid(View view){
        Intent evacovid = new Intent(this, EvaluacionCovid.class);
        startActivity(evacovid);
    }

    //Metodo para mostrar y ocultar menu desplegable
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    //Metodo para signar funciones a las opciones del menu
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.item1){
            Intent ActPerfil = new Intent(this, ActualizarPerfil.class);
            startActivity(ActPerfil);
        }else if(id == R.id.item2){
            Toast.makeText(this,"Opcion 2", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.item3){
            Intent fin = new Intent(this, MainActivity.class);
            startActivity(fin);
        }
        return super.onOptionsItemSelected(item);
    }






}