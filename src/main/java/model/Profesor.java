/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author rodoc
 */
public class Profesor {
    private String idProfesor;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechaNaci;
    private Date fechaIngr;
    private char genero;


    public Profesor() {
    }

    public Profesor(String idProfesor, String nombre, String apellido1, String apellido2, Date fechaNaci, Date fechaIngr, char genero) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNaci = fechaNaci;
        this.fechaIngr = fechaIngr;
        this.genero = genero;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(Date fechaNaci) {
        this.fechaNaci = fechaNaci;
    }

    public Date getFechaIngr() {
        return fechaIngr;
    }

    public void setFechaIngr(Date fechaIngr) {
        this.fechaIngr = fechaIngr;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

  


}