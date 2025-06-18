package util;

public class Validador {
    // Valida si un ID es numérico
    public static boolean validarId(String id) {
        return id != null && id.matches("\\d+");
    }

    // Valida si un nombre no está vacío
    public static boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    // Valida si una calificación está en el rango de 0 a 100
    public static boolean validarCalificacion(double calificacion) {
        return calificacion >= 0 && calificacion <= 100;
    }
    // Valida si un curso tiene un nombre no vacío
    public static boolean validarCurso(String curso) {
        return curso != null && !curso.trim().isEmpty();
    }
    // Valida si un estudiante tiene una edad válida (mayor o igual a 18)
    public static boolean validarEdad(int edad) {
        return edad >= 18;
    }
    // Valida si un curso tiene un profesor asignado
    public static boolean validarProfesorAsignado(String profesor) {
        return profesor != null && !profesor.trim().isEmpty();
    }
    // Valida si un estudiante tiene un ID único
    public static boolean validarIdUnico(String id, String[] idsExistentes) {
        if (id == null || id.trim().isEmpty()) {
            return false;
        }
        for (String idExistente : idsExistentes) {
            if (id.equals(idExistente)) {
                return false; // ID ya existe
            }
        }
        return true; // ID es único
    }
    // Valida si un curso tiene un ID único
    public static boolean validarCursoUnico(String curso, String[] cursosExistentes) {
        if (curso == null || curso.trim().isEmpty()) {
            return false;
        }
        for (String cursoExistente : cursosExistentes) {
            if (curso.equals(cursoExistente)) {
                return false; // Curso ya existe
            }
        }
        return true; // Curso es único
    }
    // Valida si un estudiante tiene un ID numérico y único
    public static boolean validarEstudiante(String id, String nombre, int edad, String[] idsExistentes) {
        return validarId(id) && validarNombre(nombre) && validarEdad(edad) && validarIdUnico(id, idsExistentes);
    }
    // Valida si un curso tiene un nombre no vacío y único
    public static boolean validarCurso(String curso, String[] cursosExistentes) {
        return validarCurso(curso) && validarCursoUnico(curso, cursosExistentes);
    }    
}
