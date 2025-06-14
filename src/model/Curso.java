package model;

import java.util.ArrayList;

public class Curso {
    private String nombre;
    private Profesor profesorAsignado;
    private ArrayList<Estudiante> estudiantes;

    public Curso(String nombre, Profesor profesorAsignado) {
        this.nombre = nombre;
        this.profesorAsignado = profesorAsignado;
        this.estudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getProfesorAsignado() {
        return profesorAsignado;
    }

    public void setProfesorAsignado(Profesor profesorAsignado) {
        this.profesorAsignado = profesorAsignado;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    
}
