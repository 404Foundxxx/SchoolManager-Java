package model;

import java.util.ArrayList;

public class Curso {
    // Atributos
    private String nombre;
    private Profesor profesorAsignado;
    private ArrayList<Estudiante> estudiantes;

    // Metodo constructor de la clase Curso sin parametros vacio
    public Curso() {

    }

    // Metodo constructor de la clase Curso con parametros
    public Curso(String nombre, Profesor profesorAsignado) {
        this.nombre = nombre;
        this.profesorAsignado = profesorAsignado;
        this.estudiantes = new ArrayList<>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesorAsignado() {
        return profesorAsignado;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProfesorAsignado(Profesor profesorAsignado) {
        this.profesorAsignado = profesorAsignado;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

}
