package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Curso implements Serializable {
    private String nombre;
    private Profesor profesorAsignado; // Asociación con la clase Profesor
    private final ArrayList<Estudiante> estudiantes; // Lista de estudiantes en el curso

    public Curso(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Profesor getProfesorAsignado() { return profesorAsignado; }
    public void setProfesorAsignado(Profesor profesorAsignado) { this.profesorAsignado = profesorAsignado; }
    public ArrayList<Estudiante> getEstudiantes() { return estudiantes; }
    public void agregarEstudiante(Estudiante estudiante) { this.estudiantes.add(estudiante); }
    public void eliminarEstudiante(Estudiante estudiante) { this.estudiantes.remove(estudiante); }

    @Override
    public String toString() {
        String profesorNombre = (profesorAsignado != null) ? profesorAsignado.getNombre() : "No asignado";
        return "Curso: " + nombre + ", Profesor Asignado: " + profesorNombre + ", Estudiantes Inscritos: " + estudiantes.size();
    }
}