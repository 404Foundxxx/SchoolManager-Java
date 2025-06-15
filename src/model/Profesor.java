package model;

import java.util.ArrayList;

public class Profesor {
    private String id;
    private String nombre;
    private ArrayList<Curso> cursos;

    public Profesor(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.cursos = new ArrayList<>();
    }

    public void asignarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void mostrarInformacion() {
        System.out.println("====== Datos del maestro ======");
        System.out.println(
                "ID: " + getId() +
                        "\nNombre: " + getNombre() +
                        "\nCursos que imparte: ");
        if (cursos.isEmpty()) {
            System.out.println("  Ninguan");
        } else {
            for (Curso curso : cursos) {
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

    public ArrayList<Curso> getMaterias() {
        return cursos;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMaterias(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

}