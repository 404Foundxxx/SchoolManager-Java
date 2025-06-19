package model;

import java.util.ArrayList;

public class Estudiante {

    // Atributos
    private String id;
    private String nombre;
    private int edad;
    private ArrayList<Double> calificaciones;

    // Metodo constructor de la clase Estudiante sin parametros
    public Estudiante() {
    }

    // Metodo constructor de la clase Estudiante con parametros
    public Estudiante(String id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.calificaciones = new ArrayList<>();
    }

    public void mostrarInformacion() {
        System.out.println(
                "ID: " + getId() +
                        "\nNombre: " + getNombre() +
                        "\nEdad: " + getEdad() + "\n");
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

    public ArrayList<Double> getCalificaciones() {
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

    public void setCalificaciones(ArrayList<Double> calificaciones) {
        this.calificaciones = calificaciones;
    }

}