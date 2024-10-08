package dominio; // El paquete 'dominio' contiene las clases que representan las entidades del sistema.
public class Habitante {
    // Atributos que representan el nombre y apellidos de un habitante
    private String nombre, apellido1, apellido2;
    // Constructor para inicializar los atributos de la clase Habitante
    public Habitante(String nombre, String apellido1, String apellido2) {
        this.nombre = nombre; // Inicializa el atributo 'nombre'
        this.apellido1 = apellido1; // Inicializa el atributo 'apellido1'
        this.apellido2 = apellido2; // Inicializa el atributo 'apellido2'
    }
    // Metodo para obtener el nombre del habitante
    public String getNombre() {
        return nombre; // Retorna el nombre del habitante
    }
    // Metodo para obtener el primer apellido del habitante
    public String getApellido1() {
        return apellido1; // Retorna el primer apellido
    }
    // Metodo para obtener el segundo apellido del habitante
    public String getApellido2() {
        return apellido2; // Retorna el segundo apellido
    }
    // Metodo para obtener el nombre completo concatenando nombre y apellidos
    public String getNombreCompleto() {
        return nombre + " " + apellido1 + " " + apellido2; // Retorna el nombre completo del habitante
    }
}