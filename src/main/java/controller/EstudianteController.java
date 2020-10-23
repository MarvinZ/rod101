/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.EstudianteGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Estudiante;

/**
 *
 * @author User
 */
@Named(value = "estudianteController")
@SessionScoped
public class EstudianteController extends Estudiante implements Serializable {

    /**
     * Creates a new instance of EstudianteController
     */
    public EstudianteController() {
    }

    public List<Estudiante> getEstudiantes() {
        return EstudianteGestion.getEstudiantes();
    }

    //Este metodo se encarga de llamar el edita.xhtml por un estudiante
    public String editaEstudiante(String idEstudiante) {
        Estudiante elEstudiante = EstudianteGestion.getEstudiante(idEstudiante);
        if (elEstudiante != null) {
            this.setIdEstudiante(elEstudiante.getIdEstudiante());
            this.setNombre(elEstudiante.getNombre());
            this.setApellido1(elEstudiante.getApellido1());
            this.setApellido2(elEstudiante.getApellido2());
            this.setFechaNaci(elEstudiante.getFechaNaci());
            this.setFechaIngr(elEstudiante.getFechaIngr());
            this.setGenero(elEstudiante.getGenero());
            return "edita.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posiblemente el Registro no exista.");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "list.xhtml";
        }
    }

    //Metodo Encargado de Insertar Estudiantes.
    public String insertaEstudiante() {
        if (EstudianteGestion.insertarEstudiante(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posiblemente el Registro se encuentre duplicado.");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "edita.xhtml";
        }

    }

    //Metodo Encargado de Modificar Estudiantes.
    public String modificarEstudiante() {        
        if (EstudianteGestion.modificarEstudiante(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Ocurrio un error al modificar el registro.");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "edita.xhtml";
        }

    }

    //Metodo Encargado de Modificar Estudiantes.
    public String eliminarEstudiante() {
        if (EstudianteGestion.eliminarEstudiante(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Ocurrio un error al eliminar el registro.");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "edita.xhtml";
        }

    }

}
