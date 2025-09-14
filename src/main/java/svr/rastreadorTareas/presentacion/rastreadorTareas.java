package svr.rastreadorTareas.presentacion;

import svr.rastreadorTareas.datos.ITareaDAO;
import svr.rastreadorTareas.datos.TareaDAO;
import svr.rastreadorTareas.dominio.Tarea;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class rastreadorTareas {
    public static void main(String[] args) {
        appRastreadorTareas();
    }

    private static void appRastreadorTareas() {
        // Declaración de variables.
        var salirApp = false;
        Scanner sc = new Scanner(System.in);
        // Creación del objeto para obtener los servicios.
        ITareaDAO objTareaDAO = new TareaDAO();
        // Menú.
        while (!salirApp){
            try {
                var opc = mostrarMenu(sc);
                salirApp = ejecutarMenu(opc, sc, objTareaDAO);
            }catch (Exception e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }finally {
                System.out.println("");
            }
        }
    }

    private static int mostrarMenu(Scanner sc) {
        System.out.println("*** Rastrador de Tareas - 📔 ***");
        System.out.print("""
                Menú:
                1. Ingresar Tarea.
                2. Actualizar Tarea.
                3. Eliminar Tarea.
                4. Marcar tarea en progreso o realizada.
                5. Consultar todas las tareas.
                6. Consultar estado de tareas.
                7. Salir.
                Elige una opción: \s""");
        // Leemos y retornamos la opción elegida.
        return Integer.parseInt(sc.nextLine());
    }

    private static boolean ejecutarMenu(int opc, Scanner sc, ITareaDAO objTareaDAO) {
        var salirApp = false;
        switch (opc){
            case 1 -> insertarTarea(sc, objTareaDAO);
            case 2 -> actualizarTarea(sc, objTareaDAO);
            case 3 -> eliminarTarea(sc, objTareaDAO);
            case 4 -> actualizarStatusTarea(sc, objTareaDAO);
            case 5 -> listarTareas(sc, objTareaDAO);
            case 6 -> listarTareasStatus(sc, objTareaDAO);
            case 7 -> {
                System.out.println("*** ¡Adios! ***");
                salirApp = true;
            }
            default -> System.out.println("Opción invalida: " + opc);
        }
        return salirApp;
    }

    private static void insertarTarea(Scanner sc, ITareaDAO objTareaDAO) {
        System.out.print("Descripción de la tarea: ");
        var descTarea = sc.nextLine();
        System.out.print("Estado de la tarea: (Realizada-En progreso-No realizada) ");
        var statusTarea = sc.nextLine();
        var crearTarea = LocalDateTime.now();
        var actTarea = LocalDateTime.now();
        // Creamos un objeto nuevo de tipo Tarea.
        System.out.println("*** Creando una tarea ***");
        var objTarea = new Tarea(descTarea, statusTarea, crearTarea, actTarea);
        var ingresadoApp = objTareaDAO.agregarTarea(objTarea);
        if (ingresadoApp){
            System.out.println("La tarea fue creada exitosamente: " + objTarea);
        }else{
            System.out.println("La tarea no fue creada. " + objTarea);
        }
    }

    private static void actualizarTarea(Scanner sc, ITareaDAO objTareaDAO){
        System.out.print("Digite la tarea que desea actualizar: ");
        var idAct = Integer.parseInt(sc.nextLine());
        System.out.print("Digite la descripción: ");
        var descAct = sc.nextLine();
        System.out.print("Digite el status: (Realizada-En progreso-No realizada)");
        var statusAct = sc.nextLine();
        var updateAct = LocalDateTime.now();
        // Creamos un nuevo objeto de tipo Tarea.
        System.out.println("*** Actualizando una tarea ***");
        var objTarea = new Tarea(idAct, descAct, statusAct, updateAct);
        var actualizadoApp = objTareaDAO.actualizarTarea(objTarea);
        if (actualizadoApp){
            System.out.println("La tarea fue actualizada exitosamente: " + objTarea);
        }else{
            System.out.println("La tarea no fue actualizada. " + objTarea);
        }
    }

    private static void eliminarTarea(Scanner sc, ITareaDAO objTareaDAO){
        System.out.print("Digita la identificación de la tarea que deseas eliminar: ");
        var idDel = Integer.parseInt(sc.nextLine());
        // Creamos un objeto de tipo cliente.
        System.out.println("*** Eliminando una tarea ***");
        var objTarea = new Tarea(idDel);
        var eliminadoApp = objTareaDAO.eliminarTarea(objTarea);
        if (eliminadoApp){
            System.out.println("La tarea fue eliminada exitosamente: " + objTarea);
        }else{
            System.out.println("La tarea no fue eliminada. " + objTarea);
        }
    }

    private static void actualizarStatusTarea(Scanner sc, ITareaDAO objTareaDAO) {
        System.out.print("Digite la tarea que desea actualizar: ");
        var idAct = Integer.parseInt(sc.nextLine());
        System.out.print("Digite el status: (Realizada-En progreso-No realizada)");
        var statusAct = sc.nextLine();
        var updateAct = LocalDateTime.now();
        // Creamos un nuevo objeto de tipo Tarea.
        System.out.println("*** Actualizando el status de la tarea ***");
        var objTarea = new Tarea(idAct, statusAct, updateAct);
        var actualizadoApp = objTareaDAO.actualizarStatusTarea(objTarea);
        if (actualizadoApp) {
            System.out.println("El status de la tarea fue actualizado exitosamente: " + objTarea);
        } else {
            System.out.println("El status de la tarea no fue actualizado. " + objTarea);
        }
    }

    private static void listarTareas(Scanner sc, ITareaDAO objTareaDAO){
        System.out.println("*** Listado de tareas ***");
        var tareasLista =  objTareaDAO.listarTareas();
        tareasLista.forEach(System.out::println);
    }

    private static void listarTareasStatus(Scanner sc, ITareaDAO objTareaDAO){
        System.out.print("Digita el status que deseas buscar: ");
        var statusTarea = sc.nextLine();
        // Creamos un nuebo objeto de tipo Tarea.
        System.out.println("*** Buscando por Status *** (" + statusTarea + ")");
        List<Tarea> listaTareas = objTareaDAO.buscarTareaPorEstado(statusTarea);
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas con ese status: " + statusTarea);
        }else{
            listaTareas.forEach(System.out::println);
        }
    }
}
