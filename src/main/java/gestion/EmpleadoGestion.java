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

    private static final String SQL_SELECT_ALL = "Select * from empleado";
    private static final String SQL_SELECT_BY_ID = "Select * from empleado WHERE id=?";

    /* ARREGLARLOS*/
    private static final String SQL_INSERT = "INSERT INTO empleado (Id,Cedula,Nombre,Apellido,FechaNacimiento,Correo,Telefono,TieneLicencia) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE empleado SET Cedula=?,Nombre=?,Apellido=?,FechaNacimiento=?,Correo=?,Telefono=?,TieneLicencia=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM empleado WHERE id=?";

    public static ArrayList<Empleado> getList() {
        ArrayList<Empleado> lista = new ArrayList<>();
        Date fecha = new Date();

        try {
            PreparedStatement consulta = Conexion.getConexion().
                    prepareStatement(SQL_SELECT_ALL);
            ResultSet datos = consulta.executeQuery();

            while (datos != null && datos.next()) {
                lista.add(new Empleado(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
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

    public static Empleado getById(String Id) {
        Empleado estudiante = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().
                    prepareStatement(SQL_SELECT_BY_ID);
            consulta.setString(1, Id);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                estudiante = new Empleado(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getString(6),
                        datos.getString(7),
                        datos.getBoolean(8));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return estudiante;
    }

    //Insert-Post
    public static boolean insertar(Empleado empleado) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().
                    prepareStatement(SQL_INSERT);
            sentencia.setString(1, "" + empleado.getId());
            sentencia.setString(2, empleado.getCedula());
            sentencia.setString(3, empleado.getNombre());
            sentencia.setString(4, empleado.getApellido());
            sentencia.setString(5, empleado.getFechaNacimiento().toString());
            sentencia.setString(6, empleado.getCorreo());
            sentencia.setString(7, empleado.getTelefono());
            sentencia.setString(8, empleado.getTieneLicencia()? "1" : "0");
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return false;

    }

    //Update-Put
    public static boolean modificar(Empleado empleado) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().
                    prepareStatement(SQL_UPDATE);
            sentencia.setString(8, "" + empleado.getId());
            sentencia.setString(1, empleado.getCedula());
            sentencia.setString(2, empleado.getNombre());
            sentencia.setString(3, empleado.getApellido());
            sentencia.setString(4, empleado.getFechaNacimiento().toString());
            sentencia.setString(5, empleado.getCorreo());
            sentencia.setString(6, empleado.getTelefono());
            sentencia.setString(7, empleado.getTieneLicencia()? "1" : "0");
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Delete-Delete
    public static boolean eliminar(Empleado empleado) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().
                    prepareStatement(SQL_DELETE);
            sentencia.setString(1, ""+empleado.getId());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
