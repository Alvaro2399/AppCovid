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

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class ActualizarPerfil extends AppCompatActivity {

    //FIREBASE
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    //private DatabaseReference mDatabase;
    DatabaseReference ref;
    //CREACION DE VARIABLES
        //VARIABLES DATABASE USUARIO
        private EditText edt_email;
        //VARIABLES DATABASE PACIENTE
        private EditText edt_ape,edt_dire,edt_fnac,edt_nom_emer,edt_name,edt_dni,edt_num_emer,edt_telf;
        //VARIABLES DATABASE HISTORIA CLINICA
        private EditText edt_peso,edt_talla;
        private Switch edt_sw1,edt_sw2,edt_sw3,edt_sw4,edt_sw5,edt_sw6,edt_sw7,edt_sw8;


    //VARIABLES PARA EL RELOJ
    //EditText t1;
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
        edt_fnac = (EditText) findViewById(R.id.txt_EditarFechaNacimiento);

        edt_fnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(DATE_ID);
            }
        });

        //ESTA SECCION SIRVE PARA JALAR LOS DATOS DE FIREBASE Y COLOCARLO EN EL FRAME

        //INSTANCIAR DATOS
        edt_dni        = findViewById(R.id.txt_EditarDni);
        edt_name       = findViewById(R.id.txt_EditarNombre);
        edt_ape        = findViewById(R.id.txt_EditarApellido);
        edt_fnac       = findViewById(R.id.txt_EditarFechaNacimiento);
        edt_telf       = findViewById(R.id.txt_EditarTelefono);
        edt_email      = findViewById(R.id.txt_EditarCorreo);
        edt_dire       = findViewById(R.id.txt_EditarDireccion);
        edt_nom_emer   = findViewById(R.id.txt_EditarNombreContactoEmergencia);
        edt_num_emer   = findViewById(R.id.txt_EditarNumeroContactoEmergencia);
        edt_peso       = findViewById(R.id.txt_EditarPeso);
        edt_talla      = findViewById(R.id.txt_EditarTalla);


        edt_sw1 = (Switch) findViewById(R.id.sw_Embarazo);
        edt_sw2 = (Switch) findViewById(R.id.sw_obesidad);
        edt_sw3 = (Switch) findViewById(R.id.sw_diabetes);
        edt_sw4 = (Switch) findViewById(R.id.sw_hipertension);
        edt_sw5 = (Switch) findViewById(R.id.sw_inmunodepresion);
        edt_sw6 = (Switch) findViewById(R.id.sw_cancer);
        edt_sw7 = (Switch) findViewById(R.id.sw_insuficiencia_renal);
        edt_sw8 = (Switch) findViewById(R.id.sw_insuficiencia_hepatica);


        //OBTENER DATOS DEL USUARIO LOGEADO
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        ref = FirebaseDatabase.getInstance().getReference();

        //VALIDAR EXISTENCIA DE USUARIUO
        if (user != null){
            String uid = user.getUid();

            //OBTENER DATOS DE LA TABLA USUARIO
            ref.child("RegistroAppCovid").child(uid).child("Usuario").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        String email = dataSnapshot.child("correo").getValue(String.class);
                        edt_email.setText(email);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    System.out.println("Fallo la lectura :" + databaseError.getCode());
                }
            });

            //OBTENER DATOS DE LA TABLA PACIENTE
            ref.child("RegistroAppCovid").child(uid).child("Paciente").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                   if(dataSnapshot.exists()){

                        int dni = dataSnapshot.child("dni").getValue(int.class);
                        String nombre = dataSnapshot.child("nombre").getValue(String.class);
                        String apellido = dataSnapshot.child("apellido").getValue(String.class);
                        String fecha_nacimiento = dataSnapshot.child("f_nacimiento").getValue(String.class);
                        int celular = dataSnapshot.child("telefono").getValue(int.class);
                        String dire = dataSnapshot.child("dir_domicilio").getValue(String.class);
                        String nom_conta = dataSnapshot.child("nomb_cont_emergencia").getValue(String.class);
                        int num_conta = dataSnapshot.child("num_cont_emergencia").getValue(int.class);

                        edt_dni.setText(String.valueOf(dni));
                        edt_name.setText(nombre);
                        edt_ape.setText(apellido);
                        edt_fnac.setText(fecha_nacimiento);
                        edt_telf.setText(String.valueOf(celular));
                        edt_dire.setText(dire);
                        edt_nom_emer.setText(nom_conta);
                        edt_num_emer.setText(String.valueOf(num_conta));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            //OBTENER DATOS DE LA TABLA HISTORIA CLINICA
            ref.child("RegistroAppCovid").child(uid).child("Historia_Clinica").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        int talla = dataSnapshot.child("talla").getValue(int.class);
                        int peso = dataSnapshot.child("peso").getValue(int.class);
                        Boolean embarazo = dataSnapshot.child("sw_Embarazo").getValue(Boolean.class);
                        Boolean obesidad = dataSnapshot.child("sw_Obesidad").getValue(Boolean.class);
                        Boolean diabetes = dataSnapshot.child("sw_Diabetes").getValue(Boolean.class);
                        Boolean hipertension = dataSnapshot.child("sw_Hipertension").getValue(Boolean.class);
                        Boolean inmudodepresion = dataSnapshot.child("sw_Inmunodepresion").getValue(Boolean.class);
                        Boolean cancer = dataSnapshot.child("sw_Cancer").getValue(Boolean.class);
                        Boolean renal = dataSnapshot.child("sw_Insuficiencia_renal").getValue(Boolean.class);
                        Boolean hepatica = dataSnapshot.child("sw_Insuficiencia_hepatica").getValue(Boolean.class);


                        edt_talla.setText(String.valueOf(talla));
                        edt_peso.setText(String.valueOf(peso));
                        edt_sw1.setChecked(embarazo);
                        edt_sw2.setChecked(obesidad);
                        edt_sw3.setChecked(diabetes);
                        edt_sw4.setChecked(hipertension);
                        edt_sw5.setChecked(inmudodepresion);
                        edt_sw6.setChecked(cancer);
                        edt_sw7.setChecked(renal);
                        edt_sw8.setChecked(hepatica);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });



        }else{
            Toast.makeText(getApplicationContext(), "Usuario no existe",Toast.LENGTH_SHORT).show();
        }








       // mDatabase = FirebaseDatabase.getInstance().getReference();
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
        edt_fnac.setText((mMonthIni + 1) + "-" + mDayIni + "-" + mYearIni+" ");
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

        /*

        //INSTANCIAR DATOS
        edt_correo = findViewById(R.id.txt_EditarCorreo);
        edt_name = findViewById(R.id.txt_EditarNombre);


        //OBTENER DATOS DEL USUARIO LOGEADO

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        //ref = FirebaseDatabase.getInstance().getReference();




        //VALIDAR EXISTENCIA DE USUARIUO
        if (user != null){

            String uid = user.getUid();

           edt_name.setText(uid);


        }else{
            Toast.makeText(getApplicationContext(), "Usuario no existe",Toast.LENGTH_SHORT).show();
        }

*/
    }



}