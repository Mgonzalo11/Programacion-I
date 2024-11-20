/**
 * Paquete que contiene las clases del dominio de la aplicación.
 */
package dominio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Representa una actuación de una banda de música en una fecha específica,
 * con una lista de participantes involucrados.
 */
public class Actuacion {
    /** Fecha de la actuación. */
    private LocalDate fecha;
    /** Lista de participantes que intervienen en la actuación. */
    private List<Participante> participantes;
    /**
     * Constructor que crea una actuación con una fecha específica.
     *
     * @param fecha la fecha en la que se llevará a cabo la actuación.
     */
    public Actuacion(LocalDate fecha) {
        this.fecha = fecha;
        this.participantes = new ArrayList<>();
    }
    /**
     * Añade un participante a la lista de participantes de la actuación.
     *
     * @param participante el participante que se desea añadir.
     */
    public void annadirParticipante(Participante participante) {
        participantes.add(participante);
    }
    /**
     * Devuelve una representación en forma de cadena de la actuación,
     * incluyendo la fecha y los participantes.
     *
     * @return una cadena que describe la actuación y sus participantes.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha de actuación: ").append(fecha).append("\n");
        for (Participante participante : participantes) {
            sb.append(participante).append("\n");
        }
        return sb.toString();
    }
}