package model;

public class Materia {
    // Atributos
    private String codigo, nombre;

    // Metodo constructor de la clase Materia sin parametros vacio
    public Materia() {

    }

    // Metodo constructor de la clase Materia con parametros
    public Materia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public void mostrarInformacion() {
        System.out.println("Codigo: " + getCodigo() +
                "Materia: " + getNombre() + "\n");
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    // Setteres
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
