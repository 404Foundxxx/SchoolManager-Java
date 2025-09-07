# Sistema de Gestión Escolar

Proyecto en Java para gestionar un sistema escolar desde consola. El sistema permite la administración de estudiantes, profesores, cursos y calificaciones. Más adelante será migrado a una versión web (full-stack).

## 🎯 Objetivo General

Desarrollar un sistema de consola en Java que permita registrar, consultar y gestionar estudiantes, profesores, asignaturas, inscripciones y calificaciones, con el objetivo de practicar programación orientada a objetos, estructuras de datos, lógica de negocio y separación de responsabilidades.

---

## 🧩 Características Principales

- 📚 Gestión de Estudiantes

  - Registrar nuevo estudiante
  - Modificar o eliminar datos de estudiantes
  - Listar todos los estudiantes

- 👨‍🏫 Gestión de Profesores

  - Registrar nuevo profesor
  - Modificar o eliminar datos
  - Listar profesores

- 🏫 Gestión de Asignaturas

  - Crear, modificar o eliminar materias
  - Asignar profesores a materias

- 📅 Inscripciones

  - Inscribir estudiantes en materias
  - Mostrar lista de inscritos por materia

- 📝 Calificaciones

  - Registrar notas por estudiante y materia
  - Calcular promedio individual
  - Mostrar boletín académico por estudiante

- 🔒 Sistema de Menús
  - Menú principal y submenús organizados
  - Validaciones de entrada
  - Navegación amigable por consola

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Java (JDK 17 o superior recomendado)
- **Paradigma**: Programación Orientada a Objetos (POO)
- **IDE sugerido**: IntelliJ IDEA, Eclipse o VSCode

---

## 📁 Estructura del Proyecto

```
SistemaGestionEscolar/
│
├── src/
│   ├── model/             # Clases: Estudiante, Profesor, Asignatura, Inscripcion, Nota
│   ├── service/           # Lógica de gestión y reglas del negocio
│   ├── util/           # Clases auxiliares (validaciones, menús, etc.)
│   └── Main.java           # Punto de entrada del sistema
│
├── README.md               # Documentación general
└── .gitignore              # Archivos ignorados por Git
```

---

## 🧪 Cómo Ejecutar

1. Clona el repositorio:

   ```bash
   git clone https://github.com/tu-usuario/SistemaGestionEscolar.git
   ```

2. Abre el proyecto con tu IDE favorito (Eclipse, IntelliJ, VSCode, etc).

3. Compila y ejecuta la clase `Main.java`.

---

## 🔮 Próximos Pasos

- Migrar a aplicación web (Spring Boot + MySQL + React)
- Exportar boletines en PDF
- Control de usuarios con login y roles (admin, profesor)
- Conexión a base de datos

---

## 👨‍💻 Autor

- [@404Foundxxx](https://github.com/404Foundxxx) 
- Aprendiendo Java y desarrollo full-stack paso a paso 🚀

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Puedes usarlo libremente con fines educativos o personales.
