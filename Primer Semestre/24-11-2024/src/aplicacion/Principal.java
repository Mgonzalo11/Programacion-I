/**
 * Paquete principal de la aplicación que gestiona una banda de música y sus actuaciones.
 */
package aplicacion;
import java.math.BigDecimal;
import java.time.LocalDate;
import dominio.*;
/**
 * Clase principal que inicia la aplicación de gestión de una banda de música.
 * Se crean objetos relacionados con la banda, actuaciones, participantes y se muestran los datos por consola.
 */
public class Principal {
    /**
     * Metodo principal de la aplicación.
     *
     * @param args argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Crear una banda de música
        BandaMusica bd = new BandaMusica("Banda de Música de Villar del Monte");
        // Crear la primera actuación
        Actuacion act1 = new Actuacion(LocalDate.of(2024, 11, 24));
        bd.annadirActuacion(act1); // Añadir la actuación a la banda
        // Crear y añadir un director a la actuación
        Director dir = new Director("Miguel Gonzalo Vázquez");
        act1.annadirParticipante(dir);
        // Crear y añadir un músico socio a la actuación
        MusicoSocio msc1 = new MusicoSocio("Pablo Molina", "Ukelele", 28534);
        act1.annadirParticipante(msc1);
        // Crear y añadir un músico de refuerzo a la actuación
        MusicoRefuerzo msr1 = new MusicoRefuerzo("Luis Luisillo", "Guitarra Española", new BigDecimal("121.00"));
        act1.annadirParticipante(msr1);
        // Crear una segunda actuación
        Actuacion act2 = new Actuacion(LocalDate.of(2028, 6, 21));
        bd.annadirActuacion(act2); // Añadir la actuación a la banda
        // Añadir participantes a la segunda actuación
        act2.annadirParticipante(dir);
        act2.annadirParticipante(msc1);
        MusicoRefuerzo msr2 = new MusicoRefuerzo("Joaquín De Vicente Abad", "Maracas", new BigDecimal("130.00"));
        act2.annadirParticipante(msr2);
        // Mostrar los datos de la banda por consola
        System.out.println(bd);
    }
}
