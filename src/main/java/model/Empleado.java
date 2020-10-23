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
public class Empleado {
    private String cedula;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String correo;
    private String telefono;
    private Boolean tieneLicencia;

    public Empleado() {
    }

    public Empleado(String Cedula, String Nombre, String Apellido, Date FechaNacimiento, String Correo, String Telefono, Boolean TieneLicencia) {        
        this.cedula = Cedula;
        this.nombre = Nombre;
        this.apellido = Apellido;
        this.fechaNacimiento = FechaNacimiento;
        this.correo = Correo;
        this.telefono = Telefono;
        this.tieneLicencia = TieneLicencia;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getTieneLicencia() {
        return tieneLicencia;
    }

    public void setTieneLicencia(Boolean tieneLicencia) {
        this.tieneLicencia = tieneLicencia;
    }



}