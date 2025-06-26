// src/service/GestionProfesores.java
package service;

import model.Profesor;
import model.Curso;
import util.Validador;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionProfesores {
    private ArrayList<Profesor> profesores;
    private Scanner scanner;
    private Validador validador;

    public GestionProfesores(Scanner scanner, Validador validador) {
        this.profesores = new ArrayList<>();
        this.scanner = scanner;
        this.validador = validador;
    }

    public void agregarProfesor() {
        System.out.println("\n--- Agregar Profesor ---");
        String id;
        do {
            System.out.print("Ingrese ID del profesor: ");
            id = scanner.nextLine();
            if (!validador.entradaNoVacia(id)) {
                System.out.println("⚠️ El ID no puede estar vacío.");
            } else if (!validador.esIdUnico(id, profesores)) {
                System.out.println("⚠️ El ID ya existe. Intente con otro.");
            }
        } while (!validador.entradaNoVacia(id) || !validador.esIdUnico(id, profesores));

        String nombre;
        do {
            System.out.print("Ingrese nombre del profesor: ");
            nombre = scanner.nextLine();
            if (!validador.entradaNoVacia(nombre)) {
                System.out.println("⚠️ El nombre no puede estar vacío.");
            }
        } while (!validador.entradaNoVacia(nombre));

        Profesor nuevoProfesor = new Profesor(id, nombre);
        System.out.print("¿Desea agregar materias al profesor? (s/n): ");
        String opcionMaterias = scanner.nextLine();
        if (opcionMaterias.equalsIgnoreCase("s")) {
            String materia;
            do {
                System.out.print("Ingrese materia (deje vacío para terminar): ");
                materia = scanner.nextLine();
                if (!materia.isEmpty()) {
                    nuevoProfesor.agregarMateria(materia);
                }
            } while (!materia.isEmpty());
        }
        profesores.add(nuevoProfesor);
        System.out.println("✅ Profesor agregado exitosamente.");
    }

    public void listarProfesores() {
        System.out.println("\n--- Lista de Profesores ---");
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
            return;
        }
        for (Profesor prof : profesores) {
            System.out.println(prof);
        }
    }

    public Profesor buscarProfesorPorId() {
        System.out.print("Ingrese el ID del profesor a buscar: ");
        String idBuscar = scanner.nextLine();
        if (!validador.entradaNoVacia(idBuscar)) {
            System.out.println("⚠️ El ID no puede estar vacío.");
            return null;
        }
        for (Profesor prof : profesores) {
            if (prof.getId().equals(idBuscar)) {
                return prof;
            }
        }
        System.out.println("⚠️ Profesor con ID '" + idBuscar + "' no encontrado.");
        return null;
    }

    public void asociarProfesorACurso(ArrayList<Curso> cursos) {
        System.out.println("\n--- Asociar Profesor a Curso ---");
        Profesor profesor = buscarProfesorPorId();
        if (profesor == null) {
            return;
        }

        if (cursos.isEmpty()) {
            System.out.println("No hay cursos disponibles para asociar.");
            return;
        }

        System.out.println("Cursos disponibles:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNombre());
        }

        System.out.print("Ingrese el número del curso a asignar: ");
        String opcionCursoStr = scanner.nextLine();
        if (!validador.esNumeroValido(opcionCursoStr)) {
            System.out.println("⚠️ Entrada inválida. Ingrese un número.");
            return;
        }
        int opcionCurso = Integer.parseInt(opcionCursoStr);

        if (opcionCurso > 0 && opcionCurso <= cursos.size()) {
            Curso cursoSeleccionado = cursos.get(opcionCurso - 1);
            if (cursoSeleccionado.getProfesorAsignado() != null) {
                System.out.println("⚠️ El curso '" + cursoSeleccionado.getNombre() + "' ya tiene asignado al profesor: " + cursoSeleccionado.getProfesorAsignado().getNombre());
                System.out.print("¿Desea reasignar? (s/n): ");
                String reasignar = scanner.nextLine();
                if (!reasignar.equalsIgnoreCase("s")) {
                    System.out.println("Operación cancelada.");
                    return;
                }
            }
            cursoSeleccionado.setProfesorAsignado(profesor);
            System.out.println("✅ Profesor '" + profesor.getNombre() + "' asignado al curso '" + cursoSeleccionado.getNombre() + "' exitosamente.");
        } else {
            System.out.println("⚠️ Opción de curso inválida.");
        }
    }

    // Método para obtener la lista de profesores (útil para otras clases de gestión)
    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }
}