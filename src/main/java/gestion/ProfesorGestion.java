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
import model.Profesor;
import model.Conexion;

/**
 *
 * @author rodoc
 */
public class ProfesorGestion {

    private static final String SQL_SELECT_EMPLEADOS = "select * from profesor";

    public static ArrayList<Profesor> getProfesores() {
        ArrayList<Profesor> lista = new ArrayList<>();
        Date fecha = new Date();

        try {
            PreparedStatement consulta = Conexion.getConexion().
                    prepareStatement(SQL_SELECT_EMPLEADOS);
            ResultSet datos = consulta.executeQuery();

            while (datos != null && datos.next()) {
                lista.add(new Profesor(
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getDate(6),
                        datos.getDate(7),
                        datos.getString(8).charAt(0)
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfesorGestion.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
