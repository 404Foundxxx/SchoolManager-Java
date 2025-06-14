package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("====== SISTEMA DE GESTIÓN ESCOLAR ======");
            System.out.println("1. Gestión de Estudiantes");
            System.out.println("2. Gestión de Profesores");
            System.out.println("3. Gestión de Cursos");
            System.out.println("4. Gestión de Calificaciones");
            System.out.println("5. Reportes");
            System.out.println("6. Salir");

            System.out.println("Seleccione una opción:");
            int opción = scanner.nextInt();

            switch (opción) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
            scanner.close();
        }
    }

}
