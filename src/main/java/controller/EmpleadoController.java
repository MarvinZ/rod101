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

    public List<Empleado> getEmpleados() {
        return EmpleadoGestion.getEmpleados();

    }
}
