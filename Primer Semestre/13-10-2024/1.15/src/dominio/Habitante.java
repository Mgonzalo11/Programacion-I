package dominio; // Paquete 'dominio', donde se encuentran las clases que representan entidades del sistema, en este caso, Habitante.
public class Habitante {
    // Atributos privados que almacenan el nombre y apellidos del habitante.
    private String nombre, apellido1, apellido2;
    // Constructor de la clase Habitante que inicializa los atributos con los valores proporcionados.
    public Habitante(String nombre, String apellido1, String apellido2) {
        this.nombre = nombre; // Inicializa el atributo 'nombre' con el valor proporcionado.
        this.apellido1 = apellido1; // Inicializa el atributo 'apellido1' con el valor proporcionado.
        this.apellido2 = apellido2; // Inicializa el atributo 'apellido2' con el valor proporcionado.
    }
    // Metodo getter para obtener el valor del atributo 'nombre'.
    public String getNombre() {
        return nombre; // Devuelve el nombre del habitante.
    }
    // Metodo getter para obtener el valor del atributo 'apellido1'.
    public String getApellido1() {
        return apellido1; // Devuelve el primer apellido del habitante.
    }
    // Metodo getter para obtener el valor del atributo 'apellido2'.
    public String getApellido2() {
        return apellido2; // Devuelve el segundo apellido del habitante.
    }
    // Metodo que devuelve el nombre completo del habitante, concatenando nombre y apellidos.
    public String getNombreCompleto() {
        return nombre + " " + apellido1 + " " + apellido2; // Devuelve el nombre completo en formato "Nombre Apellido1 Apellido2".
    }
}
