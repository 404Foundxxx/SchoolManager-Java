package service;

import java.util.ArrayList;
import java.util.Scanner;
import model.Profesor;

public class GestionProfesores {
    private ArrayList<Profesor> profesores;
    int opcion;
    String id, nombre;
    boolean encontrado;

    public GestionProfesores() {
        this.profesores = new ArrayList<>();
    }

    Scanner scanner = new Scanner(System.in);

    /*
     * Metodo que resgistra a los Profesores guardandolo en el array local
     * "profesores
     */
    public void agregarProfesor() {
        scanner.nextLine();
        System.out.println("====== Agregar Profesores ======");
        System.out.print("Ingrese el ID: ");
        id = scanner.nextLine();
        System.out.print("Ingrese el nombre: ");
        nombre = scanner.nextLine();
        Profesor profesor = new Profesor(id, nombre);
        profesores.add(profesor);
    }

    /*
     * Metodo que lista todos los profesor de la lista profesor de la clase
     * GestionProfesores
     */
    public void listarProfesores() {
        int contador = 1;
        System.out.println("====== Listar Profesores ======");
        for (Profesor p : profesores) {
            if (p.equals(p)) {
                System.out.println("====== Profesor: " + (contador++) + " ======");
                p.mostrarInformacion();
            }
        }
    }

    /*
     * Método que busca a un profesor especifico mediante su ID
     */
    public void buscarProfesorPorId() {
        scanner.nextLine();
        System.out.println("====== Buscar Profesor ======\n");
        System.out.print("Ingrese el ID del Profesor: ");
        id = scanner.nextLine();
        encontrado = false;
        for (Profesor p : profesores) {
            if (p.getId().equals(id)) {
                p.mostrarInformacion();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El Profesor no esta resgistrado.");
        }
    }

    /*
     * Metodo que edita datos de un profesor X que el usuario desee editar
     */
    public void editarProfesor() {
        do {
            scanner.nextLine();
            System.out.println("====== Editar Profesor ======\n");
            System.out.println("Que desea etidar del profesor?");
            System.out.println("1. Nombre");
            System.out.println("2. ID");
            System.out.println("0. Atras");
            System.out.println("Selecciones una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Ingrese el ID del profesor a editar: ");
                    id = scanner.nextLine();
                    encontrado = false;
                    for (Profesor p : profesores) {
                        if (p.getId().equals(id)) {
                            p.mostrarInformacion();
                            encontrado = true;
                            System.out.print("Ingrese el nuevo nombre: ");
                            nombre = scanner.nextLine();
                            p.setNombre(nombre);
                            System.out.println("El nombre se a editado correctamente.");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("El profesor no esta resgistrado.");
                    }
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Ingrese el ID del profesor a editar: ");
                    id = scanner.nextLine();
                    encontrado = false;
                    for (Profesor p : profesores) {
                        if (p.getId().equals(id)) {
                            p.mostrarInformacion();
                            encontrado = true;
                            System.out.print("Ingrese el nuevo ID: ");
                            id = scanner.nextLine();
                            p.setId(id);
                            System.out.println("El ID se a editado correctamente.");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("El profesor no esta resgistrado.");
                    }
                    break;
                case 0:
                    System.out.println("Volviendo a atras...");
                    break;

                default:
                    break;
            }
        } while (opcion != 0);
    }

    /*
     * Este metodo elimina profesor del array desde consola, segun elija el
     * usuario
     */
    public void eliminarProfesor() {
        scanner.nextLine();
        System.out.println("====== Eliminar Profesor ======\n");
        System.out.print("Ingrese el ID del profesor a elimiar: ");
        id = scanner.nextLine();
        encontrado = false;
        for (Profesor p : profesores) {
            if (p.getId().equals(id)) {
                p.mostrarInformacion();
                encontrado = true;
                System.out.println("Seguro que desea eliminar? [S/N]: ");
                char deccicion = scanner.next().charAt(0);
                if (deccicion != 'S' || deccicion != 's') {
                    System.out.println("Volviendo atras...");
                    break;
                } else {
                    profesores.remove(p);
                    System.out.println("El profesor se a eliminado correctamente.");
                    break;
                }
            }
        }
        if (!encontrado) {
            System.out.println("El profesor no esta resgistrado.");
        }

    }

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
                    agregarProfesor();
                    break;
                case 2:
                    listarProfesores();
                    break;
                case 3:
                    buscarProfesorPorId();
                    break;
                case 4:
                    editarProfesor();
                    break;
                case 5:
                    eliminarProfesor();
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