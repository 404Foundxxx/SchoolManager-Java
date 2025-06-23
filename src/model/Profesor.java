package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Profesor implements Serializable {
    private String id;
    private String nombre;
    private ArrayList<String> materias; // Materias que imparte

    public Profesor(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.materias = new ArrayList<>();
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public ArrayList<String> getMaterias() { return materias; }
    public void agregarMateria(String materia) { this.materias.add(materia); }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Materias: " + materias;
    }
}