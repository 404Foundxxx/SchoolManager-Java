// src/util/Validador.java
package util;

import model.Estudiante;
import model.Profesor;
import model.Curso;

import java.util.ArrayList;

public class Validador {

    public boolean esNumeroValido(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Sobrecarga para números decimales
    public boolean esDecimalValido(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public <T> boolean esIdUnico(String id, ArrayList<T> lista) {
        if (lista == null || lista.isEmpty()) {
            return true;
        }
        for (T item : lista) {
            if (item instanceof Estudiante) {
                if (((Estudiante) item).getId().equals(id)) {
                    return false;
                }
            } else if (item instanceof Profesor) {
                if (((Profesor) item).getId().equals(id)) {
                    return false;
                }
            }
            // Agrega más tipos si es necesario (ej. para Curso si tuvieran ID)
        }
        return true;
    }

    public boolean esNotaValida(String input) {
        if (!esDecimalValido(input)) {
            return false;
        }
        double nota = Double.parseDouble(input);
        return nota >= 0 && nota <= 100;
    }

    public boolean entradaNoVacia(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public boolean esNombreCursoUnico(String nombre, ArrayList<Curso> cursos) {
        if (cursos == null || cursos.isEmpty()) {
            return true;
        }
        for (Curso curso : cursos) {
            if (curso.getNombre().equalsIgnoreCase(nombre)) {
                return false;
            }
        }
        return true;
    }
}