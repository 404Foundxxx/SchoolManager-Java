package service;

import java.util.ArrayList;
import java.util.Scanner;
import model.Estudiante;

public class GestionEstudiantes {
    // Atributos de la clase
    private ArrayList<Estudiante> estudiantes;
    private String id, nombre;
    private int edad, opcion;
    private boolean encontrado;

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
        int contador = 1;
        for (Estudiante e : estudiantes) {
            if (e.equals(e)) {
                System.out.println("====== Estudiante: " + (contador++) + " ======");
                e.mostrarInformacion();

            }
        }
    }

    /*
     * Método que busca a un estudiante especifico mediante su ID
     */
    public void buscarEstudiantePorId() {
        scanner.nextLine();
        System.out.println("====== Buscar Estudiante ======\n");
        System.out.print("Ingrese el ID del estudiante: ");
        id = scanner.nextLine();
        encontrado = false;
        for (Estudiante e : estudiantes) {
            if (e.getId().equals(id)) {
                e.mostrarInformacion();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El estudiante no esta resgistrado.");
        }
    }

    /*
     * Metodo que edita datos de un estudiante X que el usuario desee editar
     */
    public void editarEstudiante() {
        do {
            scanner.nextLine();
            System.out.println("====== Editar Estudiante ======\n");
            System.out.println("Que desea etidar del estudiante?");
            System.out.println("1. Nombre");
            System.out.println("2. ID");
            System.out.println("3. Edad");
            System.out.println("0. Atras");
            System.out.println("Selecciones una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Ingrese el ID del estudiante a editar: ");
                    id = scanner.nextLine();
                    encontrado = false;
                    for (Estudiante e : estudiantes) {
                        if (e.getId().equals(id)) {
                            e.mostrarInformacion();
                            encontrado = true;
                            System.out.print("Ingrese el nuevo nombre: ");
                            nombre = scanner.nextLine();
                            e.setNombre(nombre);
                            System.out.println("El nombre se a editado correctamente.");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("El estudiante no esta resgistrado.");
                    }
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Ingrese el ID del estudiante a editar: ");
                    id = scanner.nextLine();
                    encontrado = false;
                    for (Estudiante e : estudiantes) {
                        if (e.getId().equals(id)) {
                            e.mostrarInformacion();
                            encontrado = true;
                            System.out.print("Ingrese el nuevo ID: ");
                            id = scanner.nextLine();
                            e.setId(id);
                            System.out.println("El ID se a editado correctamente.");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("El estudiante no esta resgistrado.");
                    }
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Ingrese el ID del estudiante a editar: ");
                    id = scanner.nextLine();
                    encontrado = false;
                    for (Estudiante e : estudiantes) {
                        if (e.getId().equals(id)) {
                            e.mostrarInformacion();
                            encontrado = true;
                            System.out.print("Ingrese la nueva edad: ");
                            edad = scanner.nextInt();
                            e.setEdad(edad);
                            System.out.println("La edad se a editado correctamente.");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("El estudiante no esta resgistrado.");
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
     * Este metodo elimina estudiante del array desde consola, segun elija el
     * usuario
     */
    public void eliminarEstudiante() {
        scanner.nextLine();
        System.out.println("====== Eliminar Estudiante ======\n");
        System.out.print("Ingrese el ID del estudiante a elimiar: ");
        id = scanner.nextLine();
        encontrado = false;
        for (Estudiante e : estudiantes) {
            if (e.getId().equals(id)) {
                e.mostrarInformacion();
                encontrado = true;
                System.out.println("Seguro que desea eliminar? [S/N]: ");
                char deccicion = scanner.next().charAt(0);
                if (deccicion != 'S') {
                    System.out.println("Volviendo atras...");
                    break;
                } else {
                    estudiantes.remove(e);
                    System.out.println("El estudiante se a eliminado correctamente.");
                    break;
                }
            }
        }
        if (!encontrado) {
            System.out.println("El estudiante no esta resgistrado.");
        }

    }

    // Funcion que busca estudiante al ser llamada
    public Estudiante buscarEstudiantePorId(String id) {
        for (Estudiante e : estudiantes) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    // Metodo principal de la clase GestionEstudiantes como subMenu
    public void subMenu() {
        do {
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
                    buscarEstudiantePorId();
                    break;
                case 4:
                    editarEstudiante();
                    break;
                case 5:
                    eliminarEstudiante();
                    break;
                case 0:
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("Opcion no valida, intente nuevamente.");
            }
        } while (opcion != 0);
    }
}