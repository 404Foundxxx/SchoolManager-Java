package model;

import java.util.ArrayList;

public class Profesor {
    private String id;
    private String nombre;
    private ArrayList<String> materias;

    public Profesor(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.materias = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<String> materias) {
        this.materias = materias;
    }

}