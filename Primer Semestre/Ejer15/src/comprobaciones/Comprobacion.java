package comprobaciones; // Encabezado del paquete
import dominio.Habitante; // Importar la clase Habitante
import dominio.OficinaPadron; // Importar la clase OficinaPadron
import java.util.ArrayList;
public class Comprobacion {
    public static void realizarComprobacion() {
        OficinaPadron padron = new OficinaPadron(); // Crear una instancia de OficinaPadron
        ArrayList<Habitante> habitantes = padron.getHabitantesPadron(); // Obtener la lista de habitantes
        for (Habitante habitante : habitantes) {
            System.out.println(habitante.getNombreCompleto()); // Imprimir el nombre completo de cada habitante
        }
        System.out.println("El número total de habitantes es " + padron.calcularNumeroHabitantes()); // Imprimir el total de habitantes
    }
    public static void main(String[] args) {
        realizarComprobacion(); // Llamar al método de comprobación
    }
}
