package model;

import java.util.ArrayList;

public class Profesor {

    // Atributos
    private String id;
    private String nombre;
    private ArrayList<Curso> cursos;

    // Metodo Construtro de la clase Profesor
    public Profesor(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.cursos = new ArrayList<>();
    }

    // Metodo asigna un curso al maestro
    public void asignarCurso(Curso curso) {
        cursos.add(curso);
    }

    // Este metodo muestra la informacion del maestro
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