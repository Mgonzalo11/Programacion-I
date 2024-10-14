package dominio;
import java.io.*;
import java.util.*;
// Clase que representa una oficina del padrón, que gestiona una lista de habitantes
// Implementa Serializable para poder guardar objetos de esta clase en archivos
public class OficinaPadron implements Serializable {
	// Lista que almacena los habitantes del padrón
	private List<Habitante> habitantesPadron = new ArrayList<>(); // Cambiado a List para seguir la recomendación
	// Método para añadir un nuevo habitante al padrón
	public void annadir(Habitante habitante) {
		habitantesPadron.add(habitante);
	}
	// Método para obtener la lista de habitantes en el padrón
	public List<Habitante> getHabitantesPadron() {
		return habitantesPadron; // Cambiado a List para seguir la recomendación
	}
	// Método para calcular el número total de habitantes en el padrón
	public int calcularNumeroHabitantes() {
		return habitantesPadron.size(); // Usar size() es más eficiente que iterar
	}
	// Método que devuelve una representación en texto del padrón
	public String toString() {
		StringBuilder cad = new StringBuilder(); // Usar StringBuilder para eficiencia
		// Itera a través de la lista de habitantes y añade cada uno a la cadena
		for (Habitante h : habitantesPadron) {
			cad.append(h).append("\n"); // Añade la representación de cada habitante y un salto de línea
		}
		cad.append("Total de habitantes: ").append(calcularNumeroHabitantes()).append("\n"); // Añade el total de habitantes
		return cad.toString(); // Devuelve la cadena completa
	}
}
