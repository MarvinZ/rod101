/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Estudiante;

/**
 *
 * @author User
 */
public class EstudianteGestion {

    private static final String SQL_SELECT_ESTUDIANTES = "Select * from estudiante";
    private static final String SQL_SELECT_ESTUDIANTE = "Select * from estudiante WHERE idEstudiante=?";
    private static final String SQL_INSERT_ESTUDIANTES = "INSERT INTO ESTUDIANTE (idEstudiante,nombre,apellido1,apellido2,fechaNaci,fechaIngr,genero) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_ESTUDIANTES = "UPDATE ESTUDIANTE SET NOMBRE=?,APELLIDO1=?,APELLIDO2=?,FECHANACI=?,FECHAINGR=?,GENERO=? WHERE idEstudiante=?";
    private static final String SQL_DELETE_ESTUDIANTES = "DELETE FROM ESTUDIANTE WHERE idEstudiante=?";

    //Selects-Get Select for all the students 
    public static ArrayList<Estudiante> getEstudiantes() {
        ArrayList<Estudiante> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().
                    prepareStatement(SQL_SELECT_ESTUDIANTES);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new Estudiante(
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
            Logger.getLogger(EstudianteGestion.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    //Select student
    public static Estudiante getEstudiante(String idEstudiante) {
        Estudiante estudiante = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().
                    prepareStatement(SQL_SELECT_ESTUDIANTE);
            consulta.setString(1, idEstudiante);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                estudiante = new Estudiante(
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getDate(6),
                        datos.getDate(7),
                        datos.getString(8).charAt(0));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return estudiante;
    }

    //Insert-Post
    public static boolean insertarEstudiante(Estudiante estudiante) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().
                    prepareStatement(SQL_INSERT_ESTUDIANTES);
            sentencia.setString(1, estudiante.getIdEstudiante());
            sentencia.setString(2, estudiante.getNombre());
            sentencia.setString(3, estudiante.getApellido1());
            sentencia.setString(4, estudiante.getApellido2());
            sentencia.setObject(5, estudiante.getFechaNaci());
            sentencia.setObject(6, estudiante.getFechaIngr());
            sentencia.setString(7, "" + estudiante.getGenero());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return false;

    }

    //Update-Put
    public static boolean modificarEstudiante(Estudiante estudiante) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().
                    prepareStatement(SQL_UPDATE_ESTUDIANTES);
            sentencia.setString(1, estudiante.getNombre());
            sentencia.setString(2, estudiante.getApellido1());
            sentencia.setString(3, estudiante.getApellido2());
            sentencia.setObject(4, estudiante.getFechaNaci());
            sentencia.setObject(5, estudiante.getFechaIngr());
            sentencia.setString(6, "" + estudiante.getGenero());
            sentencia.setString(7, estudiante.getIdEstudiante());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Delete-Delete
    public static boolean eliminarEstudiante(Estudiante estudiante) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().
                    prepareStatement(SQL_DELETE_ESTUDIANTES);
            sentencia.setString(1, estudiante.getIdEstudiante());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
