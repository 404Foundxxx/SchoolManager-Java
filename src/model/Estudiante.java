package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estudiante {
    private String id;
    private String nombre;
    private int edad;
    private List<Curso> cursosInscritos;
    private Map<Curso, Double> calificaciones;

    public Estudiante(String id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.cursosInscritos = new ArrayList<>();
        this.calificaciones = new HashMap<>();
    }

    public void mostrarInformacion() {
        System.out.println(
                "ID: " + getId() +
                        "\nNombre: " + getNombre() +
                        "\nEdad: " + getEdad() +
                        "\nCursos inscritos: ");
        if (cursosInscritos.isEmpty()) {
            System.out.println("  Ninguno");
        } else {
            for (Curso curso : cursosInscritos) {
                System.out.println("  - " + curso.getNombre());
            }
        }
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public List<Curso> getCursosInscritos() {
        return cursosInscritos;
    }

    public Map<Curso, Double> getCalificaciones() {
        return calificaciones;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCursosInscritos(List<Curso> cursosInscritos) {
        this.cursosInscritos = cursosInscritos;
    }

    public void setCalificaciones(Map<Curso, Double> calificaciones) {
        this.calificaciones = calificaciones;
    }

}