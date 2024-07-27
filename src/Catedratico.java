import java.util.ArrayList;
import java.util.List;

public class Catedratico extends Persona {
    private String profesion;
    private List<Curso> cursos;

    public Catedratico(String nombre, String id, String profesion) {
        super(nombre, id);
        if (profesion == null || profesion.isEmpty()) {
            throw new IllegalArgumentException("La profesion no puede ser nula o vacia");
        }
        this.profesion = profesion;
        this.cursos = new ArrayList<>();
    }
// agregamos que no se pueda dejar la casilla profesion vacia

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        if (profesion == null || profesion.isEmpty()) {
            throw new IllegalArgumentException("La profesion no puede ser nula o vacia");
        }
        this.profesion = profesion;
    }

    public List<Curso> getCursos() {
        return new ArrayList<>(cursos);
    }

    public void asignarCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("El curso no puede ser nulo");
        }
        cursos.add(curso);
        System.out.println("Asignado al curso: " + curso.getNombre());
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Catedratico: " + getNombre() + ", ID: " + getId() + ", Profesion: " + profesion);
        System.out.println("Cursos Asignados:");
        for (Curso curso : cursos) {
            System.out.println(" - " + curso.getNombre());
        }
    }

    @Override
    public String toString() {
        return "Catedratico{" +
                "nombre='" + getNombre() + '\'' +
                ", id='" + getId() + '\'' +
                ", profesion='" + profesion + '\'' +
                ", cursos=" + cursos +
                '}';
    }
}
