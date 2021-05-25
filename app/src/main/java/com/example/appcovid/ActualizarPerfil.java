package com.example.appcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class ActualizarPerfil extends AppCompatActivity {

    //FIREBASE
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    EditText edt_correo, edt_name;

    EditText t1;
    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    static final int DATE_ID = 0;
    Calendar C = Calendar.getInstance();

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_perfil);

        mAuth = FirebaseAuth.getInstance();

        sMonthIni = C.get(Calendar.MONTH);
        sDayIni = C.get(Calendar.DAY_OF_MONTH);
        sYearIni = C.get(Calendar.YEAR);
        t1 = (EditText) findViewById(R.id.txt_EditarFechaNacimiento);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(DATE_ID);
            }
        });


        inicializarFirebase();
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


    //Metodo para pasar de ventana
    public void Cancelar(View view){
        Intent cancelar = new Intent(this, MenuOpciones.class);
        startActivity(cancelar);
    }

    private void colocar_fecha() {
        t1.setText((mMonthIni + 1) + "-" + mDayIni + "-" + mYearIni+" ");
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYearIni = year;
                    mMonthIni = monthOfYear;
                    mDayIni = dayOfMonth;
                    colocar_fecha();

                }

            };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, sYearIni, sMonthIni, sDayIni);


        }


        return null;
    }


    public void ActualizarDatos(View view){

        //INSTANCIAR DATOS
        edt_correo = findViewById(R.id.txt_EditarCorreo);
        edt_name = findViewById(R.id.txt_EditarNombre);


        //OBTENER DATOS DEL USUARIO LOGEADO
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //VALIDAR EXISTENCIA DE USUARIUO
        if (user != null) {

            String email = user.getEmail();
            String uid = user.getUid();

            edt_correo.setText(email);


        }else{
            Toast.makeText(getApplicationContext(), "Usuario no existe",Toast.LENGTH_SHORT).show();
        }


    }



}