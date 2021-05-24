package com.example.appcovid.Model;

public class Usuario {
    private String uid;
    private String Correo;
    private String Contraseña;
    private String Conf_contraseña;

    public Usuario() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
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
}
