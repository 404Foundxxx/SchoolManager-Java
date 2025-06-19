package service;

import java.util.Scanner;

public class GestionProfesores {
    Scanner scanner = new Scanner(System.in);
    int opcion;

    public void subMenu() {

        do {
            System.out.println("====== Gestion de Profesores ======");
            System.out.println("1. Agregar Profesor");
            System.out.println("2. Listar Profesor");
            System.out.println("3. Buscar Profesor");
            System.out.println("4. Editar Profesor");
            System.out.println("5. Eliminar Profesor");
            System.out.println("0. Volver al menú principal");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Lógica para agregar Profesor
                    break;
                case 2:
                    // Lógica para listar Profesor
                    break;
                case 3:
                    // Lógica para buscar Profesor
                    break;
                case 4:
                    // Lógica para editar Profesor
                    break;
                case 5:
                    // Lógica para eliminar Profesor
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 0);
    }
}