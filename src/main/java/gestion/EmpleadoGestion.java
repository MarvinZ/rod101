/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Empleado;
import model.Conexion;

/**
 *
 * @author rodoc
 */
public class EmpleadoGestion {
    
    private static final String SQL_SELECT_EMPLEADOS = "Select * from empleado";
     
    

    public static ArrayList<Empleado> getEmpleados() {
        ArrayList<Empleado> lista = new ArrayList<>();
        Date fecha = new Date();
   
       try {
            PreparedStatement consulta = Conexion.getConexion().
                    prepareStatement(SQL_SELECT_EMPLEADOS);
            ResultSet datos = consulta.executeQuery();

    
            while (datos != null && datos.next()) {
                 lista.add(new Empleado(
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getDate(5),
                        datos.getString(6),
                        datos.getString(7),
                        datos.getBoolean(8)
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoGestion.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}

