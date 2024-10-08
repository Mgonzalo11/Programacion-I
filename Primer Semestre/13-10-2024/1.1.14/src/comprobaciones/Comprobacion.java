package comprobaciones; // El paquete 'comprobaciones' contiene las clases relacionadas con las verificaciones o comprobaciones de datos.
import dominio.Habitante; // Importa la clase Habitante desde el paquete 'dominio'.
import dominio.OficinaPadron; // Importa la clase OficinaPadron desde el paquete 'dominio'.
import java.util.ArrayList; // Importa la clase ArrayList para manejar listas dinámicas de objetos.
public class Comprobacion {
    // Metodo estático que realiza la comprobación de los habitantes en el padrón.
    public static void realizarComprobacion() {
        OficinaPadron padron = new OficinaPadron(); // Crea una instancia de OficinaPadron, que contiene la lista de habitantes.
        ArrayList<Habitante> habitantes = padron.getHabitantesPadron(); // Obtiene la lista de habitantes del padrón.
        // Itera sobre cada habitante en la lista y muestra su nombre completo en la consola.
        for (Habitante habitante : habitantes) {
            System.out.println(habitante.getNombreCompleto()); // Imprime el nombre completo del habitante en la consola.
        }
        // Imprime el número total de habitantes en el padrón.
        System.out.println("El número total de habitantes es " + padron.calcularNumeroHabitantes()); // Muestra el número total de habitantes.
    }
    // Metodo principal que ejecuta el proceso de comprobación.
    public static void main(String[] args) {
        realizarComprobacion(); // Llama al metodo 'realizarComprobacion' para mostrar los habitantes y el número total.
    }
}
