// src/service/GestionEstudiantes.java
package service;

import model.Estudiante;
import model.Curso;
import util.Validador;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GestionEstudiantes {
    private ArrayList<Estudiante> estudiantes;
    private Scanner scanner;
    private Validador validador;

    public GestionEstudiantes(Scanner scanner, Validador validador) {
        this.estudiantes = new ArrayList<>();
        this.scanner = scanner;
        this.validador = validador;
    }

    public void agregarEstudiante(ArrayList<Curso> cursosDisponibles) {
        System.out.println("\n--- Agregar Estudiante ---");
        String id;
        do {
            System.out.print("Ingrese ID del estudiante: ");
            id = scanner.nextLine();
            if (!validador.entradaNoVacia(id)) {
                System.out.println("⚠️ El ID no puede estar vacío.");
            } else if (!validador.esIdUnico(id, estudiantes)) {
                System.out.println("⚠️ El ID ya existe. Intente con otro.");
            }
        } while (!validador.entradaNoVacia(id) || !validador.esIdUnico(id, estudiantes));

        String nombre;
        do {
            System.out.print("Ingrese nombre del estudiante: ");
            nombre = scanner.nextLine();
            if (!validador.entradaNoVacia(nombre)) {
                System.out.println("⚠️ El nombre no puede estar vacío.");
            }
        } while (!validador.entradaNoVacia(nombre));

        int edad;
        do {
            System.out.print("Ingrese edad del estudiante: ");
            String edadStr = scanner.nextLine();
            if (validador.esNumeroValido(edadStr)) {
                edad = Integer.parseInt(edadStr);
                if (edad <= 0) {
                    System.out.println("⚠️ La edad no puede ser negativa o cero.");
                } else {
                    break;
                }
            } else {
                System.out.println("⚠️ Edad inválida. Ingrese un número.");
            }
        } while (true);

        Curso cursoAsignado = null;
        if (!cursosDisponibles.isEmpty()) {
            System.out.println("Cursos disponibles:");
            for (int i = 0; i < cursosDisponibles.size(); i++) {
                System.out.println((i + 1) + ". " + cursosDisponibles.get(i).getNombre());
            }
            System.out.print("Ingrese el número del curso a asignar (0 si no desea asignar ahora): ");
            String opcionCursoStr = scanner.nextLine();
            if (validador.esNumeroValido(opcionCursoStr)) {
                int opcionCurso = Integer.parseInt(opcionCursoStr);
                if (opcionCurso > 0 && opcionCurso <= cursosDisponibles.size()) {
                    cursoAsignado = cursosDisponibles.get(opcionCurso - 1);
                    System.out.println("Estudiante asignado al curso: " + cursoAsignado.getNombre());
                } else if (opcionCurso != 0) {
                    System.out.println("Opción de curso inválida.");
                }
            } else {
                System.out.println("Entrada inválida para el curso.");
            }
        } else {
            System.out.println("No hay cursos disponibles para asignar. Cree cursos primero.");
        }

        Estudiante nuevoEstudiante = new Estudiante(id, nombre, edad, cursoAsignado);
        estudiantes.add(nuevoEstudiante);
        if (cursoAsignado != null) {
            cursoAsignado.agregarEstudiante(nuevoEstudiante);
        }
        System.out.println("✅ Estudiante agregado exitosamente.");
    }

    public void listarEstudiantes() {
        System.out.println("\n--- Lista de Estudiantes ---");
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        for (Estudiante est : estudiantes) {
            System.out.println(est);
        }
    }

    public Estudiante buscarEstudiantePorId() {
        System.out.print("Ingrese el ID del estudiante a buscar: ");
        String idBuscar = scanner.nextLine();
        if (!validador.entradaNoVacia(idBuscar)) {
            System.out.println("⚠️ El ID no puede estar vacío.");
            return null;
        }
        for (Estudiante est : estudiantes) {
            if (est.getId().equals(idBuscar)) {
                return est;
            }
        }
        System.out.println("⚠️ Estudiante con ID '" + idBuscar + "' no encontrado.");
        return null;
    }

    public void editarEstudiante(ArrayList<Curso> cursosDisponibles) {
        System.out.println("\n--- Editar Estudiante ---");
        Estudiante estudianteAEditar = buscarEstudiantePorId();
        if (estudianteAEditar == null) {
            return;
        }

        System.out.println("Estudiante actual: " + estudianteAEditar);

        System.out.print("Ingrese nuevo nombre (" + estudianteAEditar.getNombre() + "): ");
        String nuevoNombre = scanner.nextLine();
        if (validador.entradaNoVacia(nuevoNombre)) {
            estudianteAEditar.setNombre(nuevoNombre);
        }

        int nuevaEdad;
        do {
            System.out.print("Ingrese nueva edad (" + estudianteAEditar.getEdad() + "): ");
            String nuevaEdadStr = scanner.nextLine();
            if (nuevaEdadStr.isEmpty()) {
                break; // No se cambia la edad
            }
            if (validador.esNumeroValido(nuevaEdadStr)) {
                nuevaEdad = Integer.parseInt(nuevaEdadStr);
                if (nuevaEdad <= 0) {
                    System.out.println("⚠️ La edad no puede ser negativa o cero.");
                } else {
                    estudianteAEditar.setEdad(nuevaEdad);
                    break;
                }
            } else {
                System.out.println("⚠️ Edad inválida. Ingrese un número.");
            }
        } while (true);

        Curso cursoActual = estudianteAEditar.getCurso();
        String cursoActualNombre = (cursoActual != null) ? cursoActual.getNombre() : "Ninguno";
        System.out.println("Curso actual: " + cursoActualNombre);

        if (!cursosDisponibles.isEmpty()) {
            System.out.println("Cursos disponibles:");
            for (int i = 0; i < cursosDisponibles.size(); i++) {
                System.out.println((i + 1) + ". " + cursosDisponibles.get(i).getNombre());
            }
            System.out.print("Ingrese el número del nuevo curso (0 para no cambiar): ");
            String opcionCursoStr = scanner.nextLine();
            if (validador.esNumeroValido(opcionCursoStr)) {
                int opcionCurso = Integer.parseInt(opcionCursoStr);
                if (opcionCurso > 0 && opcionCurso <= cursosDisponibles.size()) {
                    Curso nuevoCurso = cursosDisponibles.get(opcionCurso - 1);
                    if (cursoActual != null) {
                        cursoActual.eliminarEstudiante(estudianteAEditar); // Remover del curso antiguo
                    }
                    estudianteAEditar.setCurso(nuevoCurso);
                    nuevoCurso.agregarEstudiante(estudianteAEditar);
                    System.out.println("Curso del estudiante actualizado a: " + nuevoCurso.getNombre());
                } else if (opcionCurso == 0) {
                    System.out.println("No se cambió el curso.");
                } else {
                    System.out.println("Opción de curso inválida.");
                }
            } else if (!opcionCursoStr.isEmpty()){
                System.out.println("Entrada inválida para el curso.");
            }
        } else {
            System.out.println("No hay cursos disponibles para asignar.");
        }

        System.out.println("✅ Estudiante editado exitosamente.");
    }

    public void eliminarEstudiante() {
        System.out.println("\n--- Eliminar Estudiante ---");
        System.out.print("Ingrese el ID del estudiante a eliminar: ");
        String idEliminar = scanner.nextLine();
        if (!validador.entradaNoVacia(idEliminar)) {
            System.out.println("⚠️ El ID no puede estar vacío.");
            return;
        }

        Iterator<Estudiante> iterator = estudiantes.iterator();
        boolean encontrado = false;
        while (iterator.hasNext()) {
            Estudiante est = iterator.next();
            if (est.getId().equals(idEliminar)) {
                if (est.getCurso() != null) {
                    est.getCurso().eliminarEstudiante(est); // Remover del curso asociado
                }
                iterator.remove();
                encontrado = true;
                System.out.println("✅ Estudiante eliminado exitosamente.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("⚠️ Estudiante con ID '" + idEliminar + "' no encontrado.");
        }
    }

    // Método para obtener la lista de estudiantes (útil para otras clases de gestión)
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}