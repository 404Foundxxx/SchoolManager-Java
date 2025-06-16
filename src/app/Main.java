package app;

import java.util.Scanner;

import service.GestionCalificaciones;
import service.GestionCursos;
import service.GestionEstudiantes;
import service.GestionProfesores;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("====== SISTEMA DE GESTION ESCOLAR ======");
            System.out.println("1. Gestión de Estudiantes");
            System.out.println("2. Gestión de Profesores");
            System.out.println("3. Gestión de Cursos");
            System.out.println("4. Gestión de Calificaciones");
            System.out.println("5. Reportes");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    GestionEstudiantes gestionEstudiantes = new GestionEstudiantes();
                    gestionEstudiantes.subMenu();
                    break;
                case 2:
                    GestionProfesores gestionProfesores = new GestionProfesores();
                    gestionProfesores.subMenu();
                    break;
                case 3:
                    GestionCursos gestionCursos = new GestionCursos();
                    gestionCursos.subMenu();
                    break;
                case 4:
                    GestionCalificaciones gestionCalificaciones = new GestionCalificaciones();
                    gestionCalificaciones.subMenu();
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Hasta Luego...");
                    return;
                default:
                    System.out.println("Error: Opcion invalida, intente de nuevo.");
                    break;
            }
        } while (opcion != 7);
    }

}
