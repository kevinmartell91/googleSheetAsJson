package com.example.kevin.dao.entity;

/**
 * Created by kevin on 3/12/2015.
 */
public class Persona {

    private String fecha;
    private String dni;
    private String correo;
    private String Pregunta1;
    private String codTemporal;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPregunta1() {
        return Pregunta1;
    }

    public void setPregunta1(String pregunta1) {
        Pregunta1 = pregunta1;
    }

    public String getCodTemporal() {
        return codTemporal;
    }

    public void setCodTemporal(String codTemporal) {
        this.codTemporal = codTemporal;
    }
}