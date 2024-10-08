package comprobaciones; // Paquete que contiene clases encargadas de realizar comprobaciones en el sistema.
import dominio.Habitante; // Importa la clase Habitante desde el paquete 'dominio' para poder manejar la información de los habitantes.
import dominio.OficinaPadron; // Importa la clase OficinaPadron desde el paquete 'dominio' para manejar los datos del padrón.
import java.util.ArrayList; // Importa la clase ArrayList para almacenar y gestionar listas de objetos.
public class Comprobacion {
    // Metodo estático para realizar la comprobación de los habitantes registrados en el padrón.
    public static void realizarComprobacion() {
        // Crea una instancia de la clase OficinaPadron para acceder a los habitantes almacenados en el padrón.
        OficinaPadron padron = new OficinaPadron();
        // Obtiene la lista de habitantes almacenados en el padrón utilizando el metodo 'getHabitantesPadron'.
        ArrayList<Habitante> habitantes = padron.getHabitantesPadron();
        // Itera sobre cada habitante en la lista y muestra su nombre completo en la consola.
        for (Habitante habitante : habitantes) {
            System.out.println(habitante.getNombreCompleto()); // Imprime el nombre completo de cada habitante.
        }
        // Muestra el número total de habitantes en el padrón.
        System.out.println("El número total de habitantes es " + padron.calcularNumeroHabitantes());
        // Imprime el total de habitantes llamando al metodo 'calcularNumeroHabitantes' de la clase OficinaPadron.
    }
    // Metodo principal que ejecuta el proceso de comprobación.
    public static void main(String[] args) {
        // Llama al metodo 'realizarComprobacion' para mostrar los habitantes y el número total en la consola.
        realizarComprobacion();
    }
}
