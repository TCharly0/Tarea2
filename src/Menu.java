import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    protected static List<Alumno> alumnos = new ArrayList<>();
    protected static List<Catedratico> catedraticos = new ArrayList<>();
    protected static List<Curso> cursos = new ArrayList<>();
    protected static Scanner scanner = new Scanner(System.in);

    public void ejecutar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            switch (opcion) {
                case 1:
                    agregarAlumno();
                    break;
                case 2:
                    agregarCatedratico();
                    break;
                case 3:
                    agregarCurso();
                    break;
                case 4:
                    inscribirCursoAlumno();
                    break;
                case 5:
                    asignarCursoCatedratico();
                    break;
                case 6:
                    mostrarDetalles();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Agregar Alumno");
        System.out.println("2. Agregar Catedratico");
        System.out.println("3. Agregar Curso");
        System.out.println("4. Inscribir Curso a Alumno");
        System.out.println("5. Asignar Curso a Catedratico");
        System.out.println("6. Mostrar Detalles");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarAlumno() {
        System.out.print("Ingrese nombre del alumno: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese ID del alumno: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese carrera del alumno: ");
        String carrera = scanner.nextLine();
        Alumno alumno = new Alumno(nombre, id, carrera);
        alumnos.add(alumno);
        System.out.println("Alumno agregado exitosamente.");
    }

    private static void agregarCatedratico() {
        System.out.print("Ingrese nombre del catedratico: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese ID del catedratico: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese profesión del catedratico: ");
        String profesion = scanner.nextLine();
        Catedratico catedratico = new Catedratico(nombre, id, profesion);
        catedraticos.add(catedratico);
        System.out.println("Catedratico agregado exitosamente.");
    }

    private static void agregarCurso() {
        System.out.print("Ingrese nombre del curso: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese código del curso: ");
        String codigo = scanner.nextLine();
        Curso curso = new Curso(nombre, codigo);
        cursos.add(curso);
        System.out.println("Curso agregado exitosamente.");
    }

    private static void inscribirCursoAlumno() {
        System.out.print("Ingrese ID del alumno: ");
        String idAlumno = scanner.nextLine();
        Alumno alumno = buscarAlumno(idAlumno);
        if (alumno != null) {
            System.out.print("Ingrese código del curso: ");
            String codigoCurso = scanner.nextLine();
            Curso curso = buscarCurso(codigoCurso);
            if (curso != null) {
                alumno.inscribirCurso(curso);
            } else {
                System.out.println("Curso no encontrado.");
            }
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    private static void asignarCursoCatedratico() {
        System.out.print("Ingrese ID del catedratico: ");
        String idCatedratico = scanner.nextLine();
        Catedratico catedratico = buscarCatedratico(idCatedratico);
        if (catedratico != null) {
            System.out.print("Ingrese código del curso: ");
            String codigoCurso = scanner.nextLine();
            Curso curso = buscarCurso(codigoCurso);
            if (curso != null) {
                catedratico.asignarCurso(curso);
            } else {
                System.out.println("Curso no encontrado.");
            }
        } else {
            System.out.println("Catedratico no encontrado.");
        }
    }

    private static void mostrarDetalles() {
        System.out.println("\n--- Detalles de Alumnos ---");
        for (Alumno alumno : alumnos) {
            alumno.mostrarDetalles();
        }
        System.out.println("\n--- Detalles de Catedraticos ---");
        for (Catedratico catedratico : catedraticos) {
            catedratico.mostrarDetalles();
        }
    }

    private static Alumno buscarAlumno(String id) {
        for (Alumno alumno : alumnos) {
            if (alumno.getId().equals(id)) {
                return alumno;
            }
        }
        return null;
    }

    private static Catedratico buscarCatedratico(String id) {
        for (Catedratico catedratico : catedraticos) {
            if (catedratico.getId().equals(id)) {
                return catedratico;
            }
        }
        return null;
    }

    private static Curso buscarCurso(String codigo) {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        return null;
    }
}
