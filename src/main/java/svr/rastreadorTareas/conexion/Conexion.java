package svr.rastreadorTareas.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase conexión para realizar aunque suene redundante la conexión
 * con la base de datos, en este caso, MySQL WorkBench.
 */
public class Conexion {

    /**
     * Método para realizar y comprobar la conexión hacía la BD.
     * @return objCx.
     */
    public static Connection getConexion(){

        // Creación de objeto conexión.
        Connection objCx = null;
        // Definición para la variable de BD.
        var baseDatos = "rastreador_tareas";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var password = "AngelZ$2499";

        // Usamos un bloque try-catch para manejar las excepciones.
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            objCx = DriverManager.getConnection(url, usuario, password);
        }catch (Exception e){
            System.out.println("Error al realizar la conexión de la BD: " + e.getMessage());
        }
        return objCx;
    }
}
