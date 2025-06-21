package model;

public class Profesor {

    // Atributos
    private String id;
    private String nombre;

    // Metodo Construtro de la clase Profesor
    public Profesor(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void mostrarInformacion() {
        System.out.println(
                "ID: " + getId() +
                        "\nNombre: " + getNombre() + "\n");
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}