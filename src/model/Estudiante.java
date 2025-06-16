package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estudiante {

    // Atributos
    private String id;
    private String nombre;
    private int edad;
    private List<Curso> cursosInscritos;
    private Map<Curso, Double> calificaciones;
    private List<Estudiante> estudiantes;

    // Metodo constructor de la clase Estudiante
    public Estudiante(String id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.cursosInscritos = new ArrayList<>();
        this.calificaciones = new HashMap<>();
        this.estudiantes = new ArrayList<>();
    }

    // Metodo inscribe un estudiante a un curso
    public void inscribirseEnCurso(Curso curso) {
        if (!cursosInscritos.contains(curso)) {
            cursosInscritos.add(curso);
            System.out.println(getNombre() + " se ha inscrito en el curso: " + curso.getNombre());
        } else {
            System.out.println(getNombre() + " ya esta inscrito en ese curso.");
        }
    }

    // Este método da de baja al estudiante de un curso
    public void cancelarInscripcionCurso(Curso curso) {
        if (cursosInscritos.contains(curso)) {
            cursosInscritos.remove(curso);
            System.out.println(getNombre() + " se ha dado debaja del curso: " + curso.getNombre());
        } else {
            System.out.println(getNombre() + " no estaba inscrito en ese curso.");
        }
    }

    // Asigna una calificación a un curso específico del estudiante
    public void asignarCalificacion(Curso curso, Double calificacion) {
        if (curso == null) {
            System.out.println("El curso no puede ser nulo.");
            return;
        }
        if (calificacion < 0.0 || calificacion > 100) {
            System.out.println("La calificacion debe de estar entre (0 y 100).");
            return;
        }
        calificaciones.put(curso, calificacion);
        System.out.println("Calificacion asignada para el curso: " + curso.getNombre() + ": " + calificacion);
    }

    /*
     * Método que muestra todas las calificaciones de los cursos en los que el
     * estudiante está inscrito
     */
    public void mostrarCalificacion() {
        for (Map.Entry<Curso, Double> entry : calificaciones.entrySet()) {
            System.out.println("Curso: " + entry.getKey().getNombre() + ", Nota: " + entry.getValue());
        }
    }

    // Registra un estudiante en la lista de estudiantes
    public void registrarEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
            System.out
                    .println("El estudiante: " + getNombre() +
                            " con ID: " + getId() +
                            " se a inscrito exitosamente.");
        } else {
            System.out.println(getNombre() + " ya esta inscrito en el instituto.");
        }
    }

    // Metodo muestra toda las informacion del estudiante
    public void mostrarInformacion() {
        System.out.println("====== Datos del estudiante ======");
        System.out.println(
                "ID: " + getId() +
                        "\nNombre: " + getNombre() +
                        "\nEdad: " + getEdad() +
                        "\nCursos inscritos: ");
        if (cursosInscritos.isEmpty()) {
            System.out.println("  Ninguno");
        } else {
            for (Curso curso : cursosInscritos) {
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

    public int getEdad() {
        return edad;
    }

    public List<Curso> getCursosInscritos() {
        return cursosInscritos;
    }

    public Map<Curso, Double> getCalificaciones() {
        return calificaciones;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
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

    public void setCursosInscritos(List<Curso> cursosInscritos) {
        this.cursosInscritos = cursosInscritos;
    }

    public void setCalificaciones(Map<Curso, Double> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

}