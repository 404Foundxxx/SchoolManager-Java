package service;

import java.util.ArrayList;
import java.util.Scanner;
import model.Estudiante;

public class GestionEstudiantes {
    // Atributos de la clase
    private ArrayList<Estudiante> estudiantes;
    private String id, nombre;
    private int edad, opcion;

    public GestionEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }

    // Instancias
    Scanner scanner = new Scanner(System.in);
    // Estudiante estudiante = new Estudiante(); => Prueba

    /*
     * Metodo que resgistra a los estudiantes guardandolo en el array local
     * "estudiantes"
     */
    public void agregarEstudiante() {
        scanner.nextLine();
        System.out.println("====== Registrar Estudiante ======\n");
        System.out.print("ID: ");
        id = scanner.nextLine();
        System.out.print("Nombre: ");
        nombre = scanner.nextLine();
        System.out.print("Edad: ");
        edad = scanner.nextInt();
        Estudiante estudiante = new Estudiante(id, nombre, edad);
        estudiantes.add(estudiante);
    }

    /*
     * Metodo que lista todos los estudiantes de la lista estudiante de la clase
     * GestionEstudiantes
     */
    public void listarEstudiantes() {
        System.out.println("====== Estudiantes ======");
        for (Estudiante e : estudiantes) {
            e.mostrarInformacion();
        }
    }

    // Metodo principal de la clase GestionEstudiantes como subMenu
    public void subMenu() {
        System.out.println("====== Gestion de Estudiates ======");
        System.out.println("1. Agregar Estudiates");
        System.out.println("2. Listar Estudiates");
        System.out.println("3. Buscar Estudiates");
        System.out.println("4. Editar Estudiates");
        System.out.println("5. Eliminar Estudiates");
        System.out.println("0. Volver al menu principal");

        System.out.print("Seleccione una opcion: ");
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                agregarEstudiante();
                break;
            case 2:
                listarEstudiantes();
                break;
            case 3:
                // Logica para buscar estudiante
                break;
            case 4:
                // Logica para editar estudiante
                break;
            case 5:
                // Logica para eliminar estudiante
                break;
            case 0:
                System.out.println("Volviendo al menu principal...");
                break;
            default:
                System.out.println("Opcion no valida, intente nuevamente.");
        }
    }
}