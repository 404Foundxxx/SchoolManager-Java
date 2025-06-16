package service;

import java.util.ArrayList;
import java.util.Scanner;

import model.Estudiante;

public class GestionEstudiantes {
    private ArrayList<Estudiante> estudiantes;

    public GestionEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }

    public void subMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion, edad;
        // String id, nombre;
        do {

            System.out.println("====== Gestión de Estudiantes ======");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Buscar estudiante");
            System.out.println("4. Editar estudiante");
            System.out.println("5. Eliminar estudiante");
            System.out.println("0. Volver al menú principal");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.println("\n====== Agregar Estudiantes ======\n");
                    System.out.print("Ingrese el ID del estudiante: ");
                    String id = scanner.nextLine();
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingresa la edad del estudiante: ");
                    edad = scanner.nextInt();
                    Estudiante estudiante = new Estudiante(id, nombre, edad);
                    estudiantes.add(estudiante);
                    break;
                case 2:
                    System.out.println("====== Estudiantes ======");
                    for (Estudiante e : estudiantes) {
                        System.out.println(
                                "ID: " + e.getId() +
                                        "\nNombre: " + e.getNombre() +
                                        "\nEdad: " + e.getEdad() + "\n");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("Volviendo.....");
                    break;
                default:
                    System.out.println("Error: Opcion invalida, intente de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }

    // Getters
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    // Setters
    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

}