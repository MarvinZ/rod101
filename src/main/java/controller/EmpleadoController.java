/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.EmpleadoGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Empleado;

/**
 *
 * @author rodoc
 */
@Named(value = "empleadoController")
@SessionScoped
public class EmpleadoController extends Empleado implements Serializable {

    /**
     * Creates a new instance of EmpleadoController
     */
    public EmpleadoController() {
    }

    public List<Empleado> getList() {
        return EmpleadoGestion.getList();

    }

    public String editar(String Cedula) {
        Empleado elEmpleado = EmpleadoGestion.getById(Cedula);
        if (elEmpleado != null) {

            this.setId(elEmpleado.getId());
            this.setNombre(elEmpleado.getNombre());
            this.setApellido(elEmpleado.getApellido());
            this.setCorreo(elEmpleado.getCorreo());
            this.setFechaNacimiento(elEmpleado.getFechaNacimiento());
            this.setTieneLicencia(elEmpleado.getTieneLicencia());
            this.setTelefono(elEmpleado.getTelefono());
            this.setCedula(elEmpleado.getCedula());

            return "edita.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posiblemente el Registro no exista.");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "list.xhtml";
        }
    }

    public String insertar() {
        if (EmpleadoGestion.insertar(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posiblemente el Registro se encuentre duplicado.");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "edita.xhtml";
        }

    }

    //Metodo Encargado de Modificar Estudiantes.
    public String modificar() {
        if (EmpleadoGestion.modificar(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Ocurrio un error al modificar el registro.");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "edita.xhtml";
        }

    }

    //Metodo Encargado de Modificar Estudiantes.
    public String eliminar() {
        if (EmpleadoGestion.eliminar(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Ocurrio un error al eliminar el registro.");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "edita.xhtml";
        }

    }
}
