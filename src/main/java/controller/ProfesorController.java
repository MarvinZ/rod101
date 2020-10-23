/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.ProfesorGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import model.Profesor;

/**
 *
 * @author rodoc
 */
@Named(value = "profesorController")
@SessionScoped
public class ProfesorController extends Profesor implements Serializable {

    /**
     * Creates a new instance of EmpleadoController
     */
    public ProfesorController() {
    }

    public List<Profesor> getProfesores() {
        return ProfesorGestion.getProfesores();

    }
}
