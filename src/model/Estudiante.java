package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Estudiante implements Serializable {
    private String id;
    private String nombre;
    private int edad;
    private Curso curso; // Asociación con la clase Curso
    private ArrayList<Double> calificaciones;

    public Estudiante(String id, String nombre, int edad, Curso curso) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
        this.calificaciones = new ArrayList<>();
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
    public ArrayList<Double> getCalificaciones() { return calificaciones; }
    public void agregarCalificacion(double calificacion) { this.calificaciones.add(calificacion); }

    @Override
    public String toString() {
        String cursoNombre = (curso != null) ? curso.getNombre() : "No asignado";
        return "ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad + ", Curso: " + cursoNombre + ", Calificaciones: " + calificaciones;
    }
}