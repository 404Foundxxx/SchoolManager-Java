package app;

import java.util.ArrayList;
import java.util.Scanner;

import model.Curso;
import model.Estudiante;
import model.Profesor;
import service.GestionCalificaciones;
import service.GestionCursos;
import service.GestionEstudiantes;
import service.GestionProfesores;
import util.Validador;
import util.Persistencia;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Validador validador = new Validador();
    private static final Persistencia persistencia = new Persistencia();

    // Las GestonXXX se inicializarán después de cargar los datos
    private static GestionEstudiantes gestionEstudiantes;
    private static GestionProfesores gestionProfesores;
    private static GestionCursos gestionCursos;
    private static GestionCalificaciones gestionCalificaciones;

    public static void main(String[] args) {
        // Cargar datos al inicio
        ArrayList<Profesor> profesoresCargados = persistencia.cargarProfesores();
        ArrayList<Estudiante> estudiantesCargados = persistencia.cargarEstudiantes();
        // Cargar cursos requiere profesores y estudiantes ya cargados para reconstruir
        // relaciones
        ArrayList<Curso> cursosCargados = persistencia.cargarCursos(profesoresCargados, estudiantesCargados);

        // Inicializar las gestiones con los datos cargados
        gestionEstudiantes = new GestionEstudiantes(scanner, validador);
        gestionEstudiantes.getEstudiantes().addAll(estudiantesCargados); // Añadir los estudiantes cargados

        gestionProfesores = new GestionProfesores(scanner, validador);
        gestionProfesores.getProfesores().addAll(profesoresCargados); // Añadir los profesores cargados

        gestionCursos = new GestionCursos(scanner, validador);
        gestionCursos.getCursos().addAll(cursosCargados); // Añadir los cursos cargados

        // Pasar las gestiones a GestionCalificaciones
        gestionCalificaciones = new GestionCalificaciones(scanner, validador, gestionEstudiantes, gestionCursos);

        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    menuGestionEstudiantes();
                    break;
                case 2:
                    menuGestionProfesores();
                    break;
                case 3:
                    menuGestionCursos();
                    break;
                case 4:
                    menuGestionCalificaciones();
                    break;
                case 5:
                    menuReportes();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                    persistencia.guardarEstudiantes(gestionEstudiantes.getEstudiantes());
                    persistencia.guardarProfesores(gestionProfesores.getProfesores());
                    persistencia.guardarCursos(gestionCursos.getCursos());
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            System.out.println("\nPresione Enter para continuar...");
            scanner.nextLine(); // Consumir el salto de línea pendiente
        } while (opcion != 6);

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n====== SISTEMA DE GESTIÓN ESCOLAR ======");
        System.out.println("1. Gestión de Estudiantes");
        System.out.println("2. Gestión de Profesores");
        System.out.println("3. Gestión de Cursos");
        System.out.println("4. Gestión de Calificaciones");
        System.out.println("5. Reportes");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Opción inválida
        }
    }

    // --- Submenús ---

    private static void menuGestionEstudiantes() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Estudiantes ---");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Buscar estudiante");
            System.out.println("4. Editar estudiante");
            System.out.println("5. Eliminar estudiante");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    gestionEstudiantes.agregarEstudiante(gestionCursos.getCursos());
                    break;
                case 2:
                    gestionEstudiantes.listarEstudiantes();
                    break;
                case 3:
                    gestionEstudiantes.buscarEstudiantePorId();
                    break;
                case 4:
                    gestionEstudiantes.editarEstudiante(gestionCursos.getCursos());
                    break;
                case 5:
                    gestionEstudiantes.eliminarEstudiante();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            if (opcion != 0) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcion != 0);
    }

    private static void menuGestionProfesores() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Profesores ---");
            System.out.println("1. Agregar profesor");
            System.out.println("2. Listar profesores");
            System.out.println("3. Asociar profesor a curso");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    gestionProfesores.agregarProfesor();
                    break;
                case 2:
                    gestionProfesores.listarProfesores();
                    break;
                case 3:
                    gestionProfesores.asociarProfesorACurso(gestionCursos.getCursos());
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            if (opcion != 0) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcion != 0);
    }

    private static void menuGestionCursos() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Cursos ---");
            System.out.println("1. Crear curso");
            System.out.println("2. Listar cursos");
            System.out.println("3. Asignar estudiante a curso");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    gestionCursos.crearCurso(gestionProfesores.getProfesores());
                    break;
                case 2:
                    gestionCursos.listarCursos();
                    break;
                case 3:
                    gestionCursos.asignarEstudianteACurso(gestionEstudiantes.getEstudiantes());
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            if (opcion != 0) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcion != 0);
    }

    private static void menuGestionCalificaciones() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Calificaciones ---");
            System.out.println("1. Agregar calificación");
            System.out.println("2. Consultar notas por estudiante");
            System.out.println("3. Consultar notas por curso");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    gestionCalificaciones.agregarCalificacion();
                    break;
                case 2:
                    gestionCalificaciones.consultarNotasPorEstudiante();
                    break;
                case 3:
                    gestionCalificaciones.consultarNotasPorCurso();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            if (opcion != 0) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcion != 0);
    }

    private static void menuReportes() {
        int opcion;
        do {
            System.out.println("\n--- Reportes ---");
            System.out.println("1. Estudiantes con promedio menor a 60");
            System.out.println("2. Ranking de mejores promedios (Top 5)");
            System.out.println("3. Promedios por curso");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    reporteEstudiantesBajoPromedio();
                    break;
                case 2:
                    reporteRankingMejoresPromedios();
                    break;
                case 3:
                    reportePromediosPorCurso();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            if (opcion != 0) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcion != 0);
    }

    // --- Métodos de Reportes ---

    private static void reporteEstudiantesBajoPromedio() {
        System.out.println("\n--- Reporte: Estudiantes con promedio menor a 60 ---");
        boolean encontrado = false;
        for (var estudiante : gestionEstudiantes.getEstudiantes()) {
            double promedio = gestionCalificaciones.calcularPromedioEstudiante(estudiante);
            if (promedio > 0 && promedio < 60) { // Solo si tiene calificaciones
                System.out.println("- " + estudiante.getNombre() + " (ID: " + estudiante.getId() + ") - Promedio: "
                        + String.format("%.2f", promedio));
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay estudiantes con promedio menor a 60 o sin calificaciones.");
        }
    }

    private static void reporteRankingMejoresPromedios() {
        System.out.println("\n--- Reporte: Ranking de Mejores Promedios ---");
        if (gestionEstudiantes.getEstudiantes().isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        // Crear una lista de estudiantes con sus promedios
        ArrayList<Estudiante> estudiantesConPromedio = new ArrayList<>();
        for (var estudiante : gestionEstudiantes.getEstudiantes()) {
            if (!estudiante.getCalificaciones().isEmpty()) {
                estudiantesConPromedio.add(estudiante);
            }
        }

        if (estudiantesConPromedio.isEmpty()) {
            System.out.println("Ningún estudiante tiene calificaciones para calcular un promedio.");
            return;
        }

        // Ordenar la lista por promedio de forma descendente
        estudiantesConPromedio.sort((e1, e2) -> Double.compare(gestionCalificaciones.calcularPromedioEstudiante(e2),
                gestionCalificaciones.calcularPromedioEstudiante(e1)));

        int count = 0;
        for (Estudiante estudiante : estudiantesConPromedio) {
            if (count < 5) { // Mostrar solo el Top 5
                System.out.println(
                        (count + 1) + ". " + estudiante.getNombre() + " (ID: " + estudiante.getId() + ") - Promedio: "
                                + String.format("%.2f", gestionCalificaciones.calcularPromedioEstudiante(estudiante)));
                count++;
            } else {
                break;
            }
        }
    }

    private static void reportePromediosPorCurso() {
        System.out.println("\n--- Reporte: Promedios por Curso ---");
        if (gestionCursos.getCursos().isEmpty()) {
            System.out.println("No hay cursos registrados.");
            return;
        }

        for (var curso : gestionCursos.getCursos()) {
            double promedioCurso = gestionCalificaciones.calcularPromedioCurso(curso);
            System.out.println(
                    "- Curso: " + curso.getNombre() + " - Promedio General: " + String.format("%.2f", promedioCurso));
        }
    }
}