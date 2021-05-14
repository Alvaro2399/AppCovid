package com.example.appcovid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.appcovid.Model.Persona;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.UUID;

public class Registrar extends AppCompatActivity {

    private FirebaseAuth mAuth;
    //DATOS DE USUARIO
    private EditText dni,nombre,apellido,f_nacimiento,telefono,correo,dir_domicilio,nomb_cont_emergencia,num_cont_emergencia,peso,talla,contraseña,conf_contraseña;
    private Switch sw1,sw2,sw3,sw4,sw5,sw6,sw7,sw8;

    //DATOS CALENDARIO
    //FECHA NACIMEINTO
    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    static final int DATE_ID = 0;
    Calendar C = Calendar.getInstance();

    //FIREBASE
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        //CALENDARIO
        sMonthIni = C.get(Calendar.MONTH);
        sDayIni = C.get(Calendar.DAY_OF_MONTH);
        sYearIni = C.get(Calendar.YEAR);
        f_nacimiento = (EditText) findViewById(R.id.txt_RegistrarFechaNacimiento);

        f_nacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(DATE_ID);
            }
        });

        mAuth = FirebaseAuth.getInstance();
        //INSTANCIAR TODOS LOS EDIT TEXT
        dni           = findViewById(R.id.txt_RegistrarDni);
        nombre        = findViewById(R.id.txt_RegistrarNombre);
        apellido      = findViewById(R.id.txt_RegistrarApellido);
        f_nacimiento  = findViewById(R.id.txt_RegistrarFechaNacimiento);
        telefono      = findViewById(R.id.txt_RegistrarTelefono);
        correo        = findViewById(R.id.txt_RegistrarCorreo);
        dir_domicilio = findViewById(R.id.txt_RegistrarDireccion);
        nomb_cont_emergencia = findViewById(R.id.txt_RegistrarNombreContactoEmergencia);
        num_cont_emergencia  = findViewById(R.id.txt_RegistrarNumeroContactoEmergencia);
        peso          = findViewById(R.id.txt_RegistrarPeso);
        talla         = findViewById(R.id.txt_RegistrarTalla);
        contraseña    = findViewById(R.id.txt_RegistrarContraseña);
        conf_contraseña = findViewById(R.id.txt_RegistrarConfirmarContraseña);
        //INSTANCIAR TODOS LOS SWITCH
        sw1  = (Switch) findViewById(R.id.sw_Registrar_Embarazo);
        sw2  = (Switch) findViewById(R.id.sw_Registrar_Obesidad);
        sw3  = (Switch) findViewById(R.id.sw_Registrar_Diabetes);
        sw4  = (Switch) findViewById(R.id.sw_Registrar_Hipertension);
        sw5  = (Switch) findViewById(R.id.sw_Registrar_Inmunodepresion);
        sw6  = (Switch) findViewById(R.id.sw_Registrar_Cancer);
        sw7  = (Switch) findViewById(R.id.sw_Registrar_Insuficiencia_renal);
        sw8  = (Switch) findViewById(R.id.sw_Registrar_Insuficiencia_hepatica);

        inicializarFirebase();
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }


   //Metodo para pasar de ventana
    public void VolverVentana(View view){
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
    }


    //Metodo Para Calendario
    private void colocar_fecha() {
        f_nacimiento.setText((mMonthIni + 1) + "-" + mDayIni + "-" + mYearIni+" ");
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

    //METODO REGISTRAR
    public void RegistrarUsuario(View view){
        //TODOS LOS EDIT TEXT
        String dni1      = String.valueOf(dni.getText());
        String nombre1   = nombre.getText().toString();
        String apellido1 = apellido.getText().toString();
        String f_nacimiento1 = f_nacimiento.getText().toString();
        String telefono1 = String.valueOf(telefono.getText());
        String correo1   = correo.getText().toString();
        String dir_domicilio1 = dir_domicilio.getText().toString();
        String nomb_cont_emergencia1 = nomb_cont_emergencia.getText().toString();
        String num_cont_emergencia1  = String.valueOf(num_cont_emergencia.getText());
        String peso1 = String.valueOf(peso.getText());
        String talla1 = String.valueOf(talla.getText());
        String contraseña1 = contraseña.getText().toString();
        String conf_contraseña1 = conf_contraseña.getText().toString();
        //TODOS LOS SWITCHES
        Boolean sw1_1 = sw1.isChecked();
        Boolean sw2_1 = sw2.isChecked();
        Boolean sw3_1 = sw3.isChecked();
        Boolean sw4_1 = sw4.isChecked();
        Boolean sw5_1 = sw5.isChecked();
        Boolean sw6_1 = sw6.isChecked();
        Boolean sw7_1 = sw7.isChecked();
        Boolean sw8_1 = sw8.isChecked();

        //VALIDAMOS CAMPOS VACIOS
        if(!dni1.isEmpty() && !nombre1.isEmpty() && !apellido1.isEmpty() && !f_nacimiento1.isEmpty() && !telefono1.isEmpty() && !correo1.isEmpty() && !dir_domicilio1.isEmpty() && !nomb_cont_emergencia1.isEmpty() && !num_cont_emergencia1.isEmpty() && !peso1.isEmpty() && !talla1.isEmpty() && !contraseña1.isEmpty() && !conf_contraseña1.isEmpty()){
            //VALIDAR QUE EL DNI TENGA 8 DIGITOS
            if(dni1.length() ==8){
                //VALIDAR QUE EL CELULAR TENGA 9 DIGITOS
                if(telefono1.length() == 9){
                      //VALIDAR QUE EL TELEFONO DE EMERGENCIA SEA MENOR O IGUAL A 9
                        if(num_cont_emergencia1.length() <=9){
                            //VALIDAR QUE LAS CONTRASEÑAS COINCIDAN
                            if(contraseña.getText().toString().equals(conf_contraseña.getText().toString())){

                                mAuth.createUserWithEmailAndPassword(correo.getText().toString(),contraseña.getText().toString())
                                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                if (task.isSuccessful()) {
                                                    // Sign in success, update UI with the signed-in user's information
                                                    Toast.makeText(getApplicationContext(), "USUARIO CREADO",Toast.LENGTH_SHORT).show();
                                                    FirebaseUser user = mAuth.getCurrentUser();
                                                    //updateUI(user);


                                                    Persona p = new Persona();
                                                    p.setUid(UUID.randomUUID().toString());
                                                    p.setDni(Integer.parseInt(dni1));
                                                    p.setNombre(nombre1);
                                                    p.setApellido(apellido1);
                                                    p.setF_nacimiento(f_nacimiento1);
                                                    p.setTelefono(Integer.parseInt(telefono1));
                                                    p.setCorreo(correo1);
                                                    p.setDir_domicilio(dir_domicilio1);
                                                    p.setNomb_cont_emergencia(nomb_cont_emergencia1);
                                                    p.setNum_cont_emergencia(Integer.parseInt(num_cont_emergencia1));
                                                    p.setPeso(Integer.parseInt(peso1));
                                                    p.setTalla(Integer.parseInt(talla1));
                                                    p.setContraseña(contraseña1);
                                                    p.setConf_contraseña(conf_contraseña1);
                                                    p.setSw_Embarazo(sw1_1);
                                                    p.setSw_Obesidad(sw2_1);
                                                    p.setSw_Diabetes(sw3_1);
                                                    p.setSw_Hipertension(sw4_1);
                                                    p.setSw_Inmunodepresion(sw5_1);
                                                    p.setSw_Cancer(sw6_1);
                                                    p.setSw_Insuficiencia_renal(sw7_1);
                                                    p.setSw_Insuficiencia_hepatica(sw8_1);
                                                    databaseReference.child("Usuario").child(p.getUid()).setValue(p);

                                                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                                    startActivity(i);

                                                } else {
                                                    // If sign in fails, display a message to the user.
                                                    Toast.makeText(getApplicationContext(), "Authentication failed.",Toast.LENGTH_SHORT).show();
                                                    //updateUI(null);
                                                }
                                            }




                                        });


                            }else{
                                Toast.makeText(this,"Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                                contraseña.setError("Contraseñas no coinciden");
                                conf_contraseña.setError("Contraseñas no coinciden");
                            }


                        }else{
                            num_cont_emergencia.setError("El celular debe tener 9 dígitos");
                        }


                }else{
                    telefono.setError("El celular debe tener 9 dígitos");
                }


            }else{
                dni.setError("El DNI debe tener 8 dígitos");
            }

        }else{
            Validacion();
        }

    }

    private void LimpiarCajas() {
        dni.setText("");
        nombre.setText("");
        apellido.setText("");
        f_nacimiento.setText("");
        telefono.setText("");
        correo.setText("");
        dir_domicilio.setText("");
        nomb_cont_emergencia.setText("");
        num_cont_emergencia.setText("");
        peso.setText("");
        talla.setText("");
        contraseña.setText("");
        conf_contraseña.setText("");

    }

    private void Validacion() {
        String dni1      = String.valueOf(dni.getText());
        String nombre1   = nombre.getText().toString();
        String apellido1 = apellido.getText().toString();
        String f_nacimiento1 = f_nacimiento.getText().toString();
        String telefono1 = String.valueOf(telefono.getText());
        String correo1   = correo.getText().toString();
        String dir_domicilio1 = dir_domicilio.getText().toString();
        String nomb_cont_emergencia1 = nomb_cont_emergencia.getText().toString();
        String num_cont_emergencia1  = String.valueOf(num_cont_emergencia.getText());
        String peso1 = String.valueOf(peso.getText());
        String talla1 = String.valueOf(talla.getText());
        String contraseña1 = contraseña.getText().toString();
        String conf_contraseña1 = conf_contraseña.getText().toString();


        if(dni1.isEmpty()){
            dni.setError("Se requiere llenar información");
        }else if(nombre1.isEmpty()){
            nombre.setError("Se requiere llenar información");
        }else if(apellido1.isEmpty()){
            apellido.setError("Se requiere llenar información");
        }else if(f_nacimiento1.isEmpty()){
            f_nacimiento.setError("Se requiere llenar información");
        }else if(telefono1.isEmpty()){
            telefono.setError("Se requiere llenar información");
        }else if(correo1.isEmpty()){
            correo.setError("Se requiere llenar información");
        }else if(dir_domicilio1.isEmpty()){
            dir_domicilio.setError("Se requiere llenar información");
        }else if(nomb_cont_emergencia1.isEmpty()){
            nomb_cont_emergencia.setError("Se requiere llenar información");
        }else if(num_cont_emergencia1.isEmpty()){
            num_cont_emergencia.setError("Se requiere llenar información");
        }else if(peso1.isEmpty()){
            peso.setError("Se requiere llenar información");
        }else if(talla1.isEmpty()){
            talla.setError("Se requiere llenar información");
        }else if(conf_contraseña1.isEmpty()){
            conf_contraseña.setError("Se requiere llenar información");
        }else if(conf_contraseña1.isEmpty()){
            conf_contraseña.setError("Se requiere llenar información");
        }

    }





}