// src/service/GestionCursos.java
package service;

import model.Curso;
import model.Profesor;
import model.Estudiante;
import util.Validador;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionCursos {
    private ArrayList<Curso> cursos;
    private Scanner scanner;
    private Validador validador;

    public GestionCursos(Scanner scanner, Validador validador) {
        this.cursos = new ArrayList<>();
        this.scanner = scanner;
        this.validador = validador;
    }

    public void crearCurso(ArrayList<Profesor> profesoresDisponibles) {
        System.out.println("\n--- Crear Curso ---");
        String nombreCurso;
        do {
            System.out.print("Ingrese nombre del curso: ");
            nombreCurso = scanner.nextLine();
            if (!validador.entradaNoVacia(nombreCurso)) {
                System.out.println("⚠️ El nombre del curso no puede estar vacío.");
            } else if (!validador.esNombreCursoUnico(nombreCurso, cursos)) {
                System.out.println("⚠️ Ya existe un curso con ese nombre. Intente con otro.");
            }
        } while (!validador.entradaNoVacia(nombreCurso) || !validador.esNombreCursoUnico(nombreCurso, cursos));

        Curso nuevoCurso = new Curso(nombreCurso);

        if (!profesoresDisponibles.isEmpty()) {
            System.out.println("Profesores disponibles:");
            for (int i = 0; i < profesoresDisponibles.size(); i++) {
                System.out.println((i + 1) + ". " + profesoresDisponibles.get(i).getNombre());
            }
            System.out.print("Ingrese el número del profesor a asignar (0 si no desea asignar ahora): ");
            String opcionProfesorStr = scanner.nextLine();
            if (validador.esNumeroValido(opcionProfesorStr)) {
                int opcionProfesor = Integer.parseInt(opcionProfesorStr);
                if (opcionProfesor > 0 && opcionProfesor <= profesoresDisponibles.size()) {
                    Profesor profesorAsignado = profesoresDisponibles.get(opcionProfesor - 1);
                    nuevoCurso.setProfesorAsignado(profesorAsignado);
                    System.out.println("Profesor '" + profesorAsignado.getNombre() + "' asignado al curso.");
                } else if (opcionProfesor != 0) {
                    System.out.println("Opción de profesor inválida.");
                }
            } else {
                System.out.println("Entrada inválida para el profesor.");
            }
        } else {
            System.out.println("No hay profesores disponibles para asignar. Cree profesores primero.");
        }

        cursos.add(nuevoCurso);
        System.out.println("✅ Curso '" + nombreCurso + "' creado exitosamente.");
    }

    public void listarCursos() {
        System.out.println("\n--- Lista de Cursos ---");
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
            return;
        }
        for (Curso curso : cursos) {
            System.out.println(curso);
            if (!curso.getEstudiantes().isEmpty()) {
                System.out.println("  Estudiantes inscritos:");
                for (Estudiante est : curso.getEstudiantes()) {
                    System.out.println("    - " + est.getNombre() + " (ID: " + est.getId() + ")");
                }
            }
        }
    }

    public Curso buscarCursoPorNombre() {
        System.out.print("Ingrese el nombre del curso a buscar: ");
        String nombreBuscar = scanner.nextLine();
        if (!validador.entradaNoVacia(nombreBuscar)) {
            System.out.println("⚠️ El nombre del curso no puede estar vacío.");
            return null;
        }
        for (Curso curso : cursos) {
            if (curso.getNombre().equalsIgnoreCase(nombreBuscar)) {
                return curso;
            }
        }
        System.out.println("⚠️ Curso con nombre '" + nombreBuscar + "' no encontrado.");
        return null;
    }

    public void asignarEstudianteACurso(ArrayList<Estudiante> estudiantesDisponibles) {
        System.out.println("\n--- Asignar Estudiante a Curso ---");
        if (estudiantesDisponibles.isEmpty()) {
            System.out.println("No hay estudiantes para asignar.");
            return;
        }
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos disponibles.");
            return;
        }

        System.out.println("Estudiantes disponibles:");
        for (Estudiante est : estudiantesDisponibles) {
            System.out.println("- " + est.getNombre() + " (ID: " + est.getId() + ")");
        }
        System.out.print("Ingrese el ID del estudiante a asignar: ");
        String idEstudiante = scanner.nextLine();
        Estudiante estudianteSeleccionado = null;
        for (Estudiante est : estudiantesDisponibles) {
            if (est.getId().equals(idEstudiante)) {
                estudianteSeleccionado = est;
                break;
            }
        }
        if (estudianteSeleccionado == null) {
            System.out.println("⚠️ Estudiante con ID '" + idEstudiante + "' no encontrado.");
            return;
        }

        System.out.println("Cursos disponibles:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNombre());
        }
        System.out.print("Ingrese el número del curso al que desea asignar al estudiante: ");
        String opcionCursoStr = scanner.nextLine();
        if (!validador.esNumeroValido(opcionCursoStr)) {
            System.out.println("⚠️ Entrada inválida. Ingrese un número.");
            return;
        }
        int opcionCurso = Integer.parseInt(opcionCursoStr);

        if (opcionCurso > 0 && opcionCurso <= cursos.size()) {
            Curso cursoSeleccionado = cursos.get(opcionCurso - 1);
            if (estudianteSeleccionado.getCurso() != null) {
                // Si el estudiante ya estaba en otro curso, removerlo de ese curso
                estudianteSeleccionado.getCurso().eliminarEstudiante(estudianteSeleccionado);
                System.out.println("Estudiante removido de su curso anterior: " + estudianteSeleccionado.getCurso().getNombre());
            }
            cursoSeleccionado.agregarEstudiante(estudianteSeleccionado);
            estudianteSeleccionado.setCurso(cursoSeleccionado);
            System.out.println("✅ Estudiante '" + estudianteSeleccionado.getNombre() + "' asignado al curso '" + cursoSeleccionado.getNombre() + "' exitosamente.");
        } else {
            System.out.println("⚠️ Opción de curso inválida.");
        }
    }

    // Método para obtener la lista de cursos (útil para otras clases de gestión)
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
}