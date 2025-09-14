package svr.rastreadorTareas.dominio;

import java.time.LocalDateTime;
import java.util.Objects;

public class Tarea {

    // Declaración de variables.
    private int id;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    // Constructor vacio.
    public Tarea() {
    }

    // Constructor con todos los parámetros.
    public Tarea(int id, String description, String status, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    // Constructor para crear la Tarea.
    public Tarea(String description, String status, LocalDateTime createdAt, LocalDateTime updateAt){
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    // Constructor para eliminar la Tarea.
    public Tarea(int id){
        this.id = id;
    }

    // Constructor para buscar status de la Tarea.
    public Tarea(String status){
        this.status = status;
    }

    // Constructor para actualizar la Tarea.
    public Tarea(int id, String description, String status, LocalDateTime updateAt){
        this.id = id;
        this.description = description;
        this.status = status;
        this.updateAt = updateAt;
    }

    // Constructor para actualizar el status.
    public Tarea(int id, String status, LocalDateTime updateAt){
        this.id = id;
        this.status = status;
        this.updateAt = updateAt;
    }

    // Getter's & Setter's.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    // Métodos hashCode & equals.
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return id == tarea.id && Objects.equals(description, tarea.description) && Objects.equals(status, tarea.status) && Objects.equals(createdAt, tarea.createdAt) && Objects.equals(updateAt, tarea.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, status, createdAt, updateAt);
    }

    // Método toString.

    @Override
    public String toString() {
        return "Tarea:" +
                " - Identificador: " + id +
                " - Descripción: " + description +
                " - Estado: " + status +
                " - Creado: " + createdAt +
                " - Actualizado: " + updateAt;
    }
}
