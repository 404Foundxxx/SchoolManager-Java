// src/service/GestionCalificaciones.java
package service;

import model.Estudiante;
import model.Curso;
import util.Validador;
import java.util.Scanner;

public class GestionCalificaciones {
    private Scanner scanner;
    private Validador validador;
    private GestionEstudiantes gestionEstudiantes; // Para buscar estudiantes
    private GestionCursos gestionCursos; // Para buscar cursos

    public GestionCalificaciones(Scanner scanner, Validador validador, GestionEstudiantes gestionEstudiantes, GestionCursos gestionCursos) {
        this.scanner = scanner;
        this.validador = validador;
        this.gestionEstudiantes = gestionEstudiantes;
        this.gestionCursos = gestionCursos;
    }

    public void agregarCalificacion() {
        System.out.println("\n--- Agregar Calificación ---");
        Estudiante estudiante = gestionEstudiantes.buscarEstudiantePorId();
        if (estudiante == null) {
            return;
        }

        double calificacion;
        do {
            System.out.print("Ingrese la calificación para " + estudiante.getNombre() + " (0-100): ");
            String calificacionStr = scanner.nextLine();
            if (validador.esNotaValida(calificacionStr)) {
                calificacion = Double.parseDouble(calificacionStr);
                estudiante.agregarCalificacion(calificacion);
                System.out.println("✅ Calificación agregada exitosamente.");
                return;
            } else {
                System.out.println("⚠️ Calificación inválida. Debe ser un número entre 0 y 100.");
            }
        } while (true);
    }

    public void consultarNotasPorEstudiante() {
        System.out.println("\n--- Consultar Notas por Estudiante ---");
        Estudiante estudiante = gestionEstudiantes.buscarEstudiantePorId();
        if (estudiante == null) {
            return;
        }

        if (estudiante.getCalificaciones().isEmpty()) {
            System.out.println("El estudiante '" + estudiante.getNombre() + "' no tiene calificaciones registradas.");
            return;
        }

        System.out.println("Calificaciones de " + estudiante.getNombre() + ":");
        for (double nota : estudiante.getCalificaciones()) {
            System.out.println("- " + nota);
        }
        System.out.println("Promedio: " + String.format("%.2f", calcularPromedioEstudiante(estudiante)));
    }

    public void consultarNotasPorCurso() {
        System.out.println("\n--- Consultar Notas por Curso ---");
        Curso curso = gestionCursos.buscarCursoPorNombre();
        if (curso == null) {
            return;
        }

        if (curso.getEstudiantes().isEmpty()) {
            System.out.println("El curso '" + curso.getNombre() + "' no tiene estudiantes inscritos.");
            return;
        }

        System.out.println("Calificaciones para el curso '" + curso.getNombre() + "':");
        boolean cursoConCalificaciones = false;
        for (Estudiante estudiante : curso.getEstudiantes()) {
            if (!estudiante.getCalificaciones().isEmpty()) {
                cursoConCalificaciones = true;
                System.out.println("  Estudiante: " + estudiante.getNombre() + " (ID: " + estudiante.getId() + ")");
                for (double nota : estudiante.getCalificaciones()) {
                    System.out.println("    - " + nota);
                }
                System.out.println("    Promedio: " + String.format("%.2f", calcularPromedioEstudiante(estudiante)));
            }
        }
        if (!cursoConCalificaciones) {
            System.out.println("Ningún estudiante en este curso tiene calificaciones registradas.");
        }
    }

    public double calcularPromedioEstudiante(Estudiante estudiante) {
        if (estudiante.getCalificaciones().isEmpty()) {
            return 0.0;
        }
        double suma = 0;
        for (double nota : estudiante.getCalificaciones()) {
            suma += nota;
        }
        return suma / estudiante.getCalificaciones().size();
    }

    public double calcularPromedioCurso(Curso curso) {
        if (curso.getEstudiantes().isEmpty()) {
            return 0.0;
        }
        double sumaPromedios = 0;
        int estudiantesConCalificaciones = 0;
        for (Estudiante estudiante : curso.getEstudiantes()) {
            if (!estudiante.getCalificaciones().isEmpty()) {
                sumaPromedios += calcularPromedioEstudiante(estudiante);
                estudiantesConCalificaciones++;
            }
        }
        return estudiantesConCalificaciones == 0 ? 0.0 : sumaPromedios / estudiantesConCalificaciones;
    }
}