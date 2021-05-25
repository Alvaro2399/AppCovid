package com.example.appcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.example.appcovid.Model.Evaluación;
import com.example.appcovid.Model.Usuario;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EvaluacionCovid extends AppCompatActivity {

    private Switch evc1, evc2, evc3,evc4,evc5,evc6,evc7,evc8,evc9;



    //FIREBASE
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion_covid);

        mAuth = FirebaseAuth.getInstance();

        //INSTANCIAR TODOS LOS SWITCHES
        evc1  = (Switch) findViewById(R.id.sw_evc_1);
        evc2  = (Switch) findViewById(R.id.sw_evc_2);
        evc3  = (Switch) findViewById(R.id.sw_evc_3);
        evc4  = (Switch) findViewById(R.id.sw_evc_4);
        evc5  = (Switch) findViewById(R.id.sw_evc_5);
        evc6  = (Switch) findViewById(R.id.sw_evc_6);
        evc7  = (Switch) findViewById(R.id.sw_evc_7);
        evc8  = (Switch) findViewById(R.id.sw_evc_8);
        evc9  = (Switch) findViewById(R.id.sw_evc_9);


        inicializarFirebase();
    }
    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public void onBackPressed() {

    }

    //Metodo para pasar de ventana
    public void ContinuarPagPrin(View view){
            Intent contpagprin = new Intent(this, PaginaPrincipal.class);
        startActivity(contpagprin);
    }

    public void RegistrarEvalucionCovid(View view){
        //Todos los Switches

         Boolean evc1_1 = evc1.isChecked();
         Boolean evc2_1 = evc2.isChecked();
         Boolean evc3_1 = evc3.isChecked();
         Boolean evc4_1 = evc4.isChecked();
         Boolean evc5_1 = evc5.isChecked();
         Boolean evc6_1 = evc6.isChecked();
         Boolean evc7_1 = evc7.isChecked();
         Boolean evc8_1 = evc8.isChecked();
         Boolean evc9_1 = evc9.isChecked();

        Evaluación e = new Evaluación();

        e.setSw_encuesta1(evc1_1);
        e.setSw_encuesta2(evc2_1);
        e.setSw_encuesta3(evc3_1);
        e.setSw_encuesta4(evc4_1);
        e.setSw_encuesta5(evc5_1);
        e.setSw_encuesta6(evc6_1);
        e.setSw_encuesta7(evc7_1);
        e.setSw_encuesta8(evc8_1);
        e.setSw_encuesta9(evc9_1);

        //Sirve para obtener el usuario que ha iniciado sesion
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //Validas la existencia del usuario
        if (user != null) {
            //
            String uid = user.getUid();
            databaseReference.child("RegistroAppCovid").child(uid).child("Evaluacion").setValue(e);

            //edt_correo.setText(email);


        }else{
            Toast.makeText(getApplicationContext(), "Usuario no existe",Toast.LENGTH_SHORT).show();
        }



        //databaseReference.child("RegistroAppCovid").child(u.id).child("Evaluacion").setValue(e);

        Intent contpagprin = new Intent(this, PaginaPrincipal.class);
        startActivity(contpagprin);

    }




}