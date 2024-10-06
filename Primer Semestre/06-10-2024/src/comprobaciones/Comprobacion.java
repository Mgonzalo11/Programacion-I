package comprobaciones; // Definimos el paquete comprobaciones
import dominio.Habitante; // Importamos la clase Habitante del paquete dominio
import dominio.OficinaPadron; // Importamos la clase OficinaPadron del paquete dominio
public class Comprobacion {
    // Metodo estático que realiza la comprobación del padrón
    public static void realizarComprobacion() {
        // Creamos tres objetos Habitante con sus respectivos datos
        Habitante habitante1 = new Habitante("Miguel", "Gonzalo", "Vázquez");
        Habitante habitante2 = new Habitante("Pablo", "Molina", "García");
        Habitante habitante3 = new Habitante("Joaquin", "Vicente", "De Abad");
        // Creamos una instancia de OficinaPadron
        OficinaPadron padron = new OficinaPadron();
        // Añadimos los tres habitantes al padrón
        padron.annadir(habitante1);
        padron.annadir(habitante2);
        padron.annadir(habitante3);
        // Recorremos la lista de habitantes y mostramos el nombre completo de cada uno
        for (Habitante habitante : padron.getHabitantesPadron()) {
            System.out.println(habitante.getNombreCompleto()); // Imprime el nombre completo del habitante
        }
        // Mostramos el número total de habitantes en el padrón
        System.out.println("El número total de habitantes es " + padron.calcularNumeroHabitantes());
    }
}
