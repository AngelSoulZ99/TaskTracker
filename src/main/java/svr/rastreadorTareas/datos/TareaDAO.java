package svr.rastreadorTareas.datos;

import svr.rastreadorTareas.conexion.Conexion;
import svr.rastreadorTareas.dominio.Tarea;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TareaDAO implements ITareaDAO{
    @Override
    public List<Tarea> listarTareas() {
        // Declaramos una lista de tipo Tarea.
        List<Tarea> objListTarea = new ArrayList<>();
        // Declaramos las variables para realizar una consulta.
        PreparedStatement ps;
        ResultSet rs;
        Connection cx = Conexion.getConexion();
        var sql = "SELECT * FROM tareas;";
        // Usamos try-catch para el manejo de excepciones.
        try{
            // Preparamos la sentencia.
            ps = cx.prepareStatement(sql);
            // Realizamos la ejecución de la sentencia.
            rs = ps.executeQuery();
            // Realizamos la iteración de cada resultado en la tabla.
            while (rs.next()){
                var objTarea = new Tarea();
                objTarea.setId(rs.getInt("id"));
                objTarea.setDescription(rs.getString("description"));
                objTarea.setStatus(rs.getString("status"));
                objTarea.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
                objTarea.setUpdateAt(rs.getTimestamp("updatedAt").toLocalDateTime());
                objListTarea.add(objTarea);
            }
        }catch (Exception e){
            System.out.println("No se pudo realizar la consulta: " + e.getMessage());
        }finally {
            try{
            // Cerramos la conexión.
            cx.close();
            }catch (Exception e){
                System.out.println("Error al realizar el cierre de conexión: " + e.getMessage());
            }
        }
        return objListTarea;
    }

    @Override
    public List<Tarea> buscarTareaPorEstado(String statusTarea) {
        // Declaramos un tipo de listaTareas.
        List<Tarea> listaTareas = new ArrayList<>();
        // Declaramos las variables para realizar una consulta.
        PreparedStatement ps;
        ResultSet rs;
        Connection cx = Conexion.getConexion();
        var sql = "SELECT * FROM tareas WHERE status = ?;";
        // Usamos try-catch para el manejo de excepciones.
        try{
            // Preparamos la sentencia.
            ps = cx.prepareStatement(sql);
            // Recibimos el parámetro para realizar la sentencia.
            ps.setString(1, statusTarea);
            // Realizamos la ejecución de la sentencia.
            rs = ps.executeQuery();
            while(rs.next()){
                Tarea objTarea = new Tarea();
                objTarea.setId(rs.getInt("id"));
                objTarea.setDescription(rs.getString("description"));
                objTarea.setStatus(rs.getString("status"));
                objTarea.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
                objTarea.setUpdateAt(rs.getTimestamp("updatedAt").toLocalDateTime());
                listaTareas.add(objTarea);
            }
        }catch (Exception e){
            System.out.println("Error al realizar la busqueda de status." + e.getMessage());
        }finally {
            try {
                cx.close();
            }catch (Exception e){
                System.out.println("Error al realizar el cierre de conexión: " + e.getMessage());
            }
        }
        return listaTareas;
    }

    @Override
    public boolean agregarTarea(Tarea objTarea) {
        // Declaramos las variables para realizar una consulta.
        PreparedStatement ps;
        Connection cx = Conexion.getConexion();
        var sql = "INSERT INTO tareas (description, status, createdAt, updatedAt) " +
                " VALUES (?,?,?,?);";
        // Usamos try-catch para el manejo de excepciones.
        try{
            // Preparamos la sentencia.
            ps = cx.prepareStatement(sql);
            // Recibimos los parámetros para realizar la inserción.
            ps.setString(1, objTarea.getDescription());
            ps.setString(2, objTarea.getStatus());
            ps.setTimestamp(3, Timestamp.valueOf(objTarea.getCreatedAt()));
            ps.setTimestamp(4, Timestamp.valueOf(objTarea.getUpdateAt()));
            // Ejecutamos la sentencia.
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al realizar la inserción a la tabla Tareas." + e.getMessage());
        }finally {
            try{
                cx.close();
            }catch (Exception e){
                System.out.println("Error al realizar el cierre de conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean actualizarTarea(Tarea objTarea) {
        // Declaramos las variables para realizar una consulta.
        PreparedStatement ps;
        Connection cx = Conexion.getConexion();
        var sql = "UPDATE tareas SET description=?, status=?, updatedAt=? " +
                " WHERE id=?";
        // Usamos try-catch para el manejo de excepciones.
        try{
            // Preparamos la sentencia.
            ps = cx.prepareStatement(sql);
            // Recibimos los parámetros para realizar la inserción.
            ps.setString(1, objTarea.getDescription());
            ps.setString(2, objTarea.getStatus());
            ps.setTimestamp(3, Timestamp.valueOf(objTarea.getUpdateAt()));
            ps.setInt(4, objTarea.getId());
            // Ejecutamos la sentencia.
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al realizar la actualización a la tabla Tareas." + e.getMessage());
        }finally {
            try{
                cx.close();
            }catch (Exception e){
                System.out.println("Error al realizar el cierre de conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean actualizarStatusTarea(Tarea objTarea) {
        // Declaramos las variables para realizar una consulta.
        PreparedStatement ps;
        Connection cx = Conexion.getConexion();
        var sql = "UPDATE tareas SET status=?, updatedAt=? " +
                " WHERE id = ?";
        // Usamos try-catch para el manejo de excepciones.
        try{
            // Preparamos la sentencia.
            ps = cx.prepareStatement(sql);
            // Recibimos los parámetros para realizar la inserción.
            ps.setString(1, objTarea.getStatus());
            ps.setTimestamp(2, Timestamp.valueOf(objTarea.getUpdateAt()));
            ps.setInt(3, objTarea.getId());
            // Ejecutamos la sentencia.
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al realizar la actualización a la tabla Tareas." + e.getMessage());
        }finally {
            try{
                cx.close();
            }catch (Exception e){
                System.out.println("Error al realizar el cierre de conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminarTarea(Tarea objTarea) {
        // Declaramos las variables para realizar una consulta.
        PreparedStatement ps;
        Connection cx = Conexion.getConexion();
        var sql = "DELETE FROM tareas WHERE id = ?";
        // Usamos try-catch para el manejo de excepciones.
        try{
            // Preparamos la sentencia.
            ps = cx.prepareStatement(sql);
            // Recibimos los parámetros para realizar la inserción.
            ps.setInt(1, objTarea.getId());
            // Ejecutamos la sentencia.
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al eliminar el dato en la tabla Tareas. " + e.getMessage());
        }finally {
            try {
                cx.close();
            }catch (Exception e){
                System.out.println("Error al realizar el cierre de conexión: " + e.getMessage());
            }
        }
        return false;
    }
}
