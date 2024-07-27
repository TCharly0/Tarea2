import java.util.ArrayList;
import java.util.List;

public class Alumno extends Persona {
    private String carrera;
    private List<Curso> cursos;

    public Alumno(String nombre, String id, String carrera) {
        super(nombre, id);
        if (carrera == null || carrera.isEmpty()) {
            throw new IllegalArgumentException("La carrera no puede ser nula o vacía");
        }
        this.carrera = carrera;
        this.cursos = new ArrayList<>();
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        if (carrera == null || carrera.isEmpty()) {
            throw new IllegalArgumentException("La carrera no puede ser nula o vacía");
        }
        this.carrera = carrera;
    }

    public List<Curso> getCursos() {
        return new ArrayList<>(cursos);
    }

    public void inscribirCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("El curso no puede ser nulo");
        }
        cursos.add(curso);
        System.out.println("Inscrito en el curso: " + curso.getNombre());
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Alumno: " + getNombre() + ", ID: " + getId() + ", Carrera: " + carrera);
        System.out.println("Cursos Inscritos:");
        for (Curso curso : cursos) {
            System.out.println(" - " + curso.getNombre());
        }
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + getNombre() + '\'' +
                ", id='" + getId() + '\'' +
                ", carrera='" + carrera + '\'' +
                ", cursos=" + cursos +
                '}';
    }
}
