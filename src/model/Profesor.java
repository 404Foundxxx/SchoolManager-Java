package model;

import java.util.ArrayList;

public class Profesor {

    // Atributos
    private String id;
    private String nombre;
    private ArrayList<String> materias;

    // Metodo Construtro de la clase Profesor
    public Profesor(String id, String nombre, String materias) {
        this.id = id;
        this.nombre = nombre;
        this.materias.add(materias);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getMaterias() {
        return materias;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMaterias(ArrayList<String> materias) {
        this.materias = materias;
    }
}