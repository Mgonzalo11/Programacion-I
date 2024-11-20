/**
 * Paquete que contiene las clases del dominio de la aplicación.
 */
package dominio;
import java.util.ArrayList;
import java.util.List;
/**
 * Representa una banda de música, incluyendo su nombre y las actuaciones que realiza.
 */
public class BandaMusica {
    /** Nombre de la banda de música. */
    private String nombre;
    /** Lista de actuaciones asociadas a la banda. */
    private List<Actuacion> actuaciones;
    /**
     * Constructor que crea una banda de música con un nombre específico.
     *
     * @param nombre el nombre de la banda de música.
     */
    public BandaMusica(String nombre) {
        this.nombre = nombre;
        this.actuaciones = new ArrayList<>();
    }
    /**
     * Añade una actuación a la lista de actuaciones de la banda.
     *
     * @param actuacion la actuación que se desea añadir.
     */
    public void annadirActuacion(Actuacion actuacion) {
        actuaciones.add(actuacion);
    }
    /**
     * Devuelve una representación en forma de cadena de la banda de música,
     * incluyendo su nombre y las actuaciones.
     *
     * @return una cadena que representa la banda y sus actuaciones.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre.toUpperCase()).append("\n");
        for (Actuacion actuacion : actuaciones) {
            sb.append(actuacion).append("\n");
        }
        return sb.toString();
    }
}
