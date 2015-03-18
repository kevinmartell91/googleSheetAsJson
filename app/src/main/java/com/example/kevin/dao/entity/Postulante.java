package com.example.kevin.dao.entity;

/**
 * Created by kevin on 3/14/2015.
 */
public class Postulante {

    private String Fecha_registro;
    private String Nombre;
    private String Apellido;
    private String DNI;
    private String E_mail;
    private String Alternativa_Elegida;


    public String getFecha_registro() {
        return Fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        Fecha_registro = fecha_registro;
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

    public void setApellido(String apellido) { Apellido = apellido; }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }

    public String getAlternativa_Elegida() {
        return Alternativa_Elegida;
    }

    public void setAlternativa_Elegida(String alternativa_Elegida) {
        Alternativa_Elegida = alternativa_Elegida;
    }
}
