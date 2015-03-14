package com.example.kevin.entities;

/**
 * Created by kevin on 3/12/2015.
 */
public class Persona {

    private String fecha;
    private Integer dni;
    private String correo;
    private String Pregunta1;
    private Integer codTemporal;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
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

    public Integer getCodTemporal() {
        return codTemporal;
    }

    public void setCodTemporal(Integer codTemporal) {
        this.codTemporal = codTemporal;
    }
}
