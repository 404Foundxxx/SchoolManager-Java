package service;

import java.util.Scanner;

public class GestionCursos {
    Scanner scanner = new Scanner(System.in);
    int opcion;

    public void subMenu() {

        do {
            System.out.println("====== Gestión de Cursos ======");
            System.out.println("1. Agregar curso");
            System.out.println("2. Listar cursos");
            System.out.println("3. Buscar curso");
            System.out.println("4. Editar curso");
            System.out.println("5. Eliminar curso");
            System.out.println("0. Volver al menú principal");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Lógica para agregar curso
                    break;
                case 2:
                    // Lógica para listar cursos
                    break;
                case 3:
                    // Lógica para buscar curso
                    break;
                case 4:
                    // Lógica para editar curso
                    break;
                case 5:
                    // Lógica para eliminar curso
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
