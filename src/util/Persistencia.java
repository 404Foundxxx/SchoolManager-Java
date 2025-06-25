// src/util/Persistencia.java (Ejemplo simple con archivos de texto)
package util;

import model.Curso;
import model.Estudiante;
import model.Profesor;

import java.io.*;
import java.util.ArrayList;

public class Persistencia {
    private static final String ESTUDIANTES_FILE = "data/estudiantes.txt";
    private static final String PROFESORES_FILE = "data/profesores.txt";
    private static final String CURSOS_FILE = "data/cursos.txt";

    public Persistencia() {
        // Asegurarse de que el directorio 'data' exista
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
    }

    // --- Guardar Datos ---
    public void guardarEstudiantes(ArrayList<Estudiante> estudiantes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ESTUDIANTES_FILE))) {
            oos.writeObject(estudiantes);
            System.out.println("Datos de estudiantes guardados.");
        } catch (IOException e) {
            System.err.println("Error al guardar estudiantes: " + e.getMessage());
        }
    }

    public void guardarProfesores(ArrayList<Profesor> profesores) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PROFESORES_FILE))) {
            oos.writeObject(profesores);
            System.out.println("Datos de profesores guardados.");
        } catch (IOException e) {
            System.err.println("Error al guardar profesores: " + e.getMessage());
        }
    }

    // Guardar cursos es más complejo debido a las relaciones con Profesor y Estudiante
    // Para simplificar, guardaremos solo el nombre del curso y las IDs de sus relaciones
    // Esto requerirá un paso de "reconstrucción" al cargar
    public void guardarCursos(ArrayList<Curso> cursos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CURSOS_FILE))) {
            for (Curso curso : cursos) {
                StringBuilder sb = new StringBuilder();
                sb.append(curso.getNombre()).append("::");
                sb.append(curso.getProfesorAsignado() != null ? curso.getProfesorAsignado().getId() : "null").append("::");
                for (Estudiante est : curso.getEstudiantes()) {
                    sb.append(est.getId()).append(",");
                }
                if (!curso.getEstudiantes().isEmpty()) {
                    sb.setLength(sb.length() - 1); // Eliminar la última coma
                }
                writer.write(sb.toString());
                writer.newLine();
            }
            System.out.println("Datos de cursos guardados.");
        } catch (IOException e) {
            System.err.println("Error al guardar cursos: " + e.getMessage());
        }
    }

    // --- Cargar Datos ---
    @SuppressWarnings("unchecked")
    public ArrayList<Estudiante> cargarEstudiantes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ESTUDIANTES_FILE))) {
            System.out.println("Cargando datos de estudiantes...");
            return (ArrayList<Estudiante>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de estudiantes no encontrado. Se iniciará con lista vacía.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar estudiantes: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Profesor> cargarProfesores() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PROFESORES_FILE))) {
            System.out.println("Cargando datos de profesores...");
            return (ArrayList<Profesor>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de profesores no encontrado. Se iniciará con lista vacía.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar profesores: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    // Cargar cursos y reconstruir relaciones
    public ArrayList<Curso> cargarCursos(ArrayList<Profesor> profesores, ArrayList<Estudiante> estudiantes) {
        ArrayList<Curso> cursosCargados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CURSOS_FILE))) {
            System.out.println("Cargando datos de cursos...");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("::");
                String nombreCurso = parts[0];
                String profesorId = parts[1];
                String estudiantesIdsStr = (parts.length > 2 && !parts[2].isEmpty()) ? parts[2] : "";

                Curso curso = new Curso(nombreCurso);

                // Asignar profesor
                if (!profesorId.equals("null")) {
                    for (Profesor prof : profesores) {
                        if (prof.getId().equals(profesorId)) {
                            curso.setProfesorAsignado(prof);
                            break;
                        }
                    }
                }

                // Asignar estudiantes
                if (!estudiantesIdsStr.isEmpty()) {
                    String[] estudianteIds = estudiantesIdsStr.split(",");
                    for (String id : estudianteIds) {
                        for (Estudiante est : estudiantes) {
                            if (est.getId().equals(id)) {
                                curso.agregarEstudiante(est);
                                est.setCurso(curso); // Asegurarse de que el estudiante también tenga la referencia al curso
                                break;
                            }
                        }
                    }
                }
                cursosCargados.add(curso);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de cursos no encontrado. Se iniciará con lista vacía.");
        } catch (IOException e) {
            System.err.println("Error al cargar cursos: " + e.getMessage());
        }
        return cursosCargados;
    }
}