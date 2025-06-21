package service;

import java.util.ArrayList;
import java.util.Scanner;
import model.Materia;

public class GestionMaterias {
    private ArrayList<Materia> materias;
    private int opcion;
    private String codigo, nombre;
    private boolean encontrado;

    Scanner scanner = new Scanner(System.in);

    public GestionMaterias() {
        this.materias = new ArrayList<>();
    }

    /*
     * Metodo que resgistra una materia guardandola en el array privado
     * "materias"
     */
    public void agregarMateria() {
        scanner.nextLine();
        System.out.println("====== Registrar Materia ======\n");
        System.out.print("Ingrese el codigo de la materia: ");
        codigo = scanner.nextLine();
        System.out.print("Ingrese el nombre de la materia: ");
        nombre = scanner.nextLine();
        Materia materia = new Materia(codigo, nombre);
        materias.add(materia);

    }

    /*
     * Metodo que lista todos las materias de la lista materias de la clase
     * GestionMaterias
     */
    public void listarMaterias() {
        int contador = 1;
        for (Materia m : materias) {
            if (m.equals(m)) {
                System.out.println("====== Materia: " + (contador++) + " ======");
                m.mostrarInformacion();

            }
        }
    }

    /*
     * Método que busca a una materia especifico mediante su codigo
     */
    public void buscarMateriaPorCodigo() {
        System.out.println("====== Buscar Materia ======\n");
        System.out.print("Ingrese el codigo de la materia: ");
        codigo = scanner.nextLine();
        for (Materia m : materias) {
            if (m.getCodigo().equals(codigo)) {
                m.mostrarInformacion();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("La materia no esta resgistrado.");
        }
    }

    /*
     * Metodo que edita datos de una materia X que el usuario desee editar
     */
    public void editarMateria() {
        do {
            scanner.nextLine();
            System.out.println("====== Editar Materia ======\n");
            System.out.println("Que desea etidar de la materia?");
            System.out.println("1. Codigo");
            System.out.println("2. Nombre");
            System.out.println("0. Atras");
            System.out.println("Selecciones una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Ingrese el codigo de la materia a editar: ");
                    codigo = scanner.nextLine();
                    encontrado = false;
                    for (Materia m : materias) {
                        if (m.getCodigo().equals(codigo)) {
                            m.mostrarInformacion();
                            encontrado = true;
                            System.out.print("Ingrese el nuevo nombre: ");
                            nombre = scanner.nextLine();
                            m.setNombre(nombre);
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
                    System.out.print("Ingrese el codigo de la materia a editar: ");
                    codigo = scanner.nextLine();
                    encontrado = false;
                    for (Materia m : materias) {
                        if (m.getCodigo().equals(codigo)) {
                            m.mostrarInformacion();
                            encontrado = true;
                            System.out.print("Ingrese el nuevo codigo: ");
                            codigo = scanner.nextLine();
                            m.setCodigo(codigo);
                            System.out.println("El codigo se a editado correctamente.");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("La materia no esta resgistrado.");
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
     * Este metodo elimina una materia del array desde consola, segun elija el
     * usuario
     */
    public void eliminarMateria() {
        scanner.nextLine();
        System.out.println("====== Eliminar Materia ======\n");
        System.out.print("Ingrese el codigo de la materia a elimiar: ");
        codigo = scanner.nextLine();
        encontrado = false;
        for (Materia m : materias) {
            if (m.getCodigo().equals(codigo)) {
                m.mostrarInformacion();
                encontrado = true;
                System.out.println("Seguro que desea eliminar? [S/N]: ");
                char deccicion = scanner.next().charAt(0);
                if (deccicion != 'S') {
                    System.out.println("Volviendo atras...");
                    break;
                } else {
                    materias.remove(m);
                    System.out.println("La materia se a eliminado correctamente.");
                    break;
                }
            }
        }
        if (!encontrado) {
            System.out.println("La materia no esta resgistrado.");
        }

    }

    public void subMenu() {

        do {
            System.out.println("====== Gestión de Materias ======");
            System.out.println("1. Agregar Materia");
            System.out.println("2. Listar Materia");
            System.out.println("3. Buscar Materia");
            System.out.println("4. Editar Materia");
            System.out.println("5. Eliminar Materia");
            System.out.println("0. Volver al menú principal");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarMateria();
                    break;
                case 2:
                    listarMaterias();
                    break;
                case 3:
                    buscarMateriaPorCodigo();
                    break;
                case 4:
                    editarMateria();
                    break;
                case 5:
                    eliminarMateria();
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
