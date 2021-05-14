package com.example.appcovid.Model;

public class Persona {
    private String uid;
    private int Dni;
    private String Nombre;
    private String Apellido;
    private String F_nacimiento;
    private int Telefono;
    private String Correo;
    private String Dir_domicilio;
    private String Nomb_cont_emergencia;
    private int Num_cont_emergencia;
    private int Peso;
    private int Talla;
    private String Contraseña;
    private String Conf_contraseña;
    private Boolean Sw_Embarazo;
    private Boolean Sw_Obesidad;
    private Boolean Sw_Diabetes;
    private Boolean Sw_Hipertension;
    private Boolean Sw_Inmunodepresion;
    private Boolean Sw_Cancer;
    private Boolean Sw_Insuficiencia_renal;
    private Boolean Sw_Insuficiencia_hepatica;

    public Persona() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getDni() {
        return Dni;
    }

    public void setDni(int dni) {
        Dni = dni;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getF_nacimiento() {
        return F_nacimiento;
    }

    public void setF_nacimiento(String f_nacimiento) {
        F_nacimiento = f_nacimiento;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getDir_domicilio() {
        return Dir_domicilio;
    }

    public void setDir_domicilio(String dir_domicilio) {
        Dir_domicilio = dir_domicilio;
    }

    public String getNomb_cont_emergencia() {
        return Nomb_cont_emergencia;
    }

    public void setNomb_cont_emergencia(String nomb_cont_emergencia) {
        Nomb_cont_emergencia = nomb_cont_emergencia;
    }

    public int getNum_cont_emergencia() {
        return Num_cont_emergencia;
    }

    public void setNum_cont_emergencia(int num_cont_emergencia) {
        Num_cont_emergencia = num_cont_emergencia;
    }

    public int getPeso() {
        return Peso;
    }

    public void setPeso(int peso) {
        Peso = peso;
    }

    public int getTalla() {
        return Talla;
    }

    public void setTalla(int talla) {
        Talla = talla;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getConf_contraseña() {
        return Conf_contraseña;
    }

    public void setConf_contraseña(String conf_contraseña) {
        Conf_contraseña = conf_contraseña;
    }

    public Boolean getSw_Embarazo() {
        return Sw_Embarazo;
    }

    public void setSw_Embarazo(Boolean sw_Embarazo) {
        Sw_Embarazo = sw_Embarazo;
    }

    public Boolean getSw_Obesidad() {
        return Sw_Obesidad;
    }

    public void setSw_Obesidad(Boolean sw_Obesidad) {
        Sw_Obesidad = sw_Obesidad;
    }

    public Boolean getSw_Diabetes() {
        return Sw_Diabetes;
    }

    public void setSw_Diabetes(Boolean sw_Diabetes) {
        Sw_Diabetes = sw_Diabetes;
    }

    public Boolean getSw_Hipertension() {
        return Sw_Hipertension;
    }

    public void setSw_Hipertension(Boolean sw_Hipertension) {
        Sw_Hipertension = sw_Hipertension;
    }

    public Boolean getSw_Inmunodepresion() {
        return Sw_Inmunodepresion;
    }

    public void setSw_Inmunodepresion(Boolean sw_Inmunodepresion) {
        Sw_Inmunodepresion = sw_Inmunodepresion;
    }

    public Boolean getSw_Cancer() {
        return Sw_Cancer;
    }

    public void setSw_Cancer(Boolean sw_Cancer) {
        Sw_Cancer = sw_Cancer;
    }

    public Boolean getSw_Insuficiencia_renal() {
        return Sw_Insuficiencia_renal;
    }

    public void setSw_Insuficiencia_renal(Boolean sw_Insuficiencia_renal) {
        Sw_Insuficiencia_renal = sw_Insuficiencia_renal;
    }

    public Boolean getSw_Insuficiencia_hepatica() {
        return Sw_Insuficiencia_hepatica;
    }

    public void setSw_Insuficiencia_hepatica(Boolean sw_Insuficiencia_hepatica) {
        Sw_Insuficiencia_hepatica = sw_Insuficiencia_hepatica;
    }

    @Override
    public String toString() {
        return Nombre;
    }
}
