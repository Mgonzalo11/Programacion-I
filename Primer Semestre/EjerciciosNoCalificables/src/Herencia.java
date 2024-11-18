import java.util.ArrayList;

public class Herencia {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();
        Profesor profesor = new Profesor("Miguel", "Gonzalo", "Calle Melilla nº8", "Matemáticas");
        Alumno alumno = new Alumno("Pablo", "Molina", "Calle calle de la calle", 30);
        AlumnoInternacional alumnoInternacional = new AlumnoInternacional("Luis", "Luisillo", "Calle de su casa", 20, "España");
        personas.add(profesor);
        personas.add(alumno);
        personas.add(alumnoInternacional);
        for (Persona persona : personas) {
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Información completa: " + persona);
            System.out.println("Clase: " + persona.getClass().getName());
            System.out.println("Superclase: " + persona.getClass().getSuperclass().getName());
            System.out.println();
        }
    }
}

class Persona {
    private String nombre;
    private String apellidos;
    private String direccion;
    // Constructor
    public Persona(String nombre, String apellidos, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }
    // Métodos de consulta (getters)
    public String getNombre() {return nombre;}
    public String getApellidos() {return apellidos;}
    public String getDireccion() {return direccion;}
    // Métodos de actualización (setters)
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    // Metodo toString
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}

class Profesor extends Persona {
    private String materia;
    public Profesor(String nombre, String apellidos, String direccion, String materia) {
        super(nombre, apellidos, direccion);
        this.materia = materia;
    }
    public String getMateria() {return materia;}
    public void setMateria(String materia) {this.materia = materia;}
    @Override
    public String toString() {
        return super.toString() + ", materia='" + materia + '\'' + '}';
    }
}

class Alumno extends Persona {
    private int numeroCreditos;
    public Alumno(String nombre, String apellidos, String direccion, int numeroCreditos) {
        super(nombre, apellidos, direccion);
        this.numeroCreditos = numeroCreditos;
    }
    public int getNumeroCreditos() {return numeroCreditos;}
    public void setNumeroCreditos(int numeroCreditos) {this.numeroCreditos = numeroCreditos;}
    @Override
    public String toString() {
        return super.toString() + ", numeroCreditos=" + numeroCreditos + '}';
    }
}

class AlumnoInternacional extends Alumno {
    private String pais;
    public AlumnoInternacional(String nombre, String apellidos, String direccion, int numeroCreditos, String pais) {
        super(nombre, apellidos, direccion, numeroCreditos);
        this.pais = pais;
    }
    public String getPais() {return pais;}
    public void setPais(String pais) {this.pais = pais;}
    @Override
    public String toString() {
        return super.toString() + ", pais='" + pais + '\'' + '}';
    }
}