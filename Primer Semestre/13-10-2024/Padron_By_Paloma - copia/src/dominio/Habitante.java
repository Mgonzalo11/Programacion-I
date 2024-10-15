package dominio;
import java.io.Serializable;
// Clase que representa a un habitante del padrón
// Implementa Serializable para poder guardar objetos de esta clase en archivos
public class Habitante implements Serializable {
	// Atributos privados que almacenan el nombre y apellidos del habitante
	private String nombre;
	private String apellido1;
	private String apellido2;
	// Constructor que inicializa los atributos del habitante
	public Habitante(String nombre, String apellido1, String apellido2) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}
	// Método para establecer el nombre del habitante
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	// Método para establecer el primer apellido del habitante
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	// Método para establecer el segundo apellido del habitante
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	// Método para obtener el nombre del habitante
	public String getNombre() {
		return nombre;
	}
	// Método para obtener el primer apellido del habitante
	public String getApellido1() {
		return apellido1;
	}
	// Método para obtener el segundo apellido del habitante
	public String getApellido2() {
		return apellido2;
	}
	// Método que devuelve una representación en texto del habitante
	// en el formato "apellido1 apellido2, nombre"
	public String toString() {
		return apellido1 + " " + apellido2 + ", " + nombre;
	}
}