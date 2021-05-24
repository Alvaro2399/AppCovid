package com.example.appcovid.Model;

public class Paciente {

    private int Dni;
    private String Nombre;
    private String Apellido;
    private String F_nacimiento;
    private int Telefono;
    private String Dir_domicilio;
    private String Nomb_cont_emergencia;
    private int Num_cont_emergencia;

    public Paciente() {
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
}
