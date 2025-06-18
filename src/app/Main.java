package app;

import java.util.Scanner;

import service.GestionCalificaciones;
import service.GestionCursos;
import service.GestionEstudiantes;
import service.GestionProfesores;

public class Main {
    Scanner scanner = new Scanner(System.in);
    int opcion;

    public void main(String[] args) {

        // Instancias únicas de las clases de gestión
        GestionEstudiantes gestionEstudiantes = new GestionEstudiantes();
        GestionProfesores gestionProfesores = new GestionProfesores();
        GestionCursos gestionCursos = new GestionCursos();
        GestionCalificaciones gestionCalificaciones = new GestionCalificaciones();

        do {
            System.out.println("====== SISTEMA DE GESTION ESCOLAR ======");
            System.out.println("1. Gestión de Estudiantes");
            System.out.println("2. Gestión de Profesores");
            System.out.println("3. Gestión de Cursos");
            System.out.println("4. Gestión de Calificaciones");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    gestionEstudiantes.subMenu();
                    break;
                case 2:
                    gestionProfesores.subMenu();
                    break;
                case 3:
                    gestionCursos.subMenu();
                    break;
                case 4:
                    gestionCalificaciones.subMenu();
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