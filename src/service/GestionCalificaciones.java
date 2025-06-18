package service;

import java.util.Scanner;

public class GestionCalificaciones {
    Scanner scanner = new Scanner(System.in);
    int opcion;

    public void subMenu() {
        do {
            System.out.println("====== Gestión de Calificaciones ======");
            System.out.println("1. Agregar calificación");
            System.out.println("2. Listar calificaciones");
            System.out.println("3. Buscar calificación");
            System.out.println("4. Editar calificación");
            System.out.println("5. Eliminar calificación");
            System.out.println("0. Volver al menú principal");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Lógica para agregar calificación
                    break;
                case 2:
                    // Lógica para listar calificaciones
                    break;
                case 3:
                    // Lógica para buscar calificación
                    break;
                case 4:
                    // Lógica para editar calificación
                    break;
                case 5:
                    // Lógica para eliminar calificación
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
