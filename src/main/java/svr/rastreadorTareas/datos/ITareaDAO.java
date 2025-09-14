package svr.rastreadorTareas.datos;

import svr.rastreadorTareas.dominio.Tarea;

import java.util.List;

public interface ITareaDAO {
    // Métodos de comportamiento de la clase DAO.
    List<Tarea> listarTareas();
    List<Tarea> buscarTareaPorEstado(String tareaStatus);
    boolean agregarTarea(Tarea objTarea);
    boolean actualizarTarea(Tarea objTarea);
    boolean actualizarStatusTarea(Tarea objTarea);
    boolean eliminarTarea(Tarea objTarea);
}
