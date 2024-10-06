package dominio; // Definimos el paquete dominio que contiene las clases del dominio de la aplicación
public class Habitante {
    private String nombre, apellido1, apellido2; // Declaramos atributos para el nombre y apellidos del habitante
    // Constructor para inicializar los atributos del habitante
    public Habitante(String nombre, String apellido1, String apellido2) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }
    // Metodo getter para obtener el nombre
    public String getNombre() { return nombre; }
    // Metodo getter para obtener el primer apellido
    public String getApellido1() { return apellido1; }
    // Metodo getter para obtener el segundo apellido
    public String getApellido2() { return apellido2; }
    // Metodo para obtener el nombre completo del habitante
    public String getNombreCompleto() { return nombre + " " + apellido1 + " " + apellido2; }
}
