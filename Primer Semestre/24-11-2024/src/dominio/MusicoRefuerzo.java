/**
 * Paquete que contiene las clases del dominio de la aplicación.
 */
package dominio;
import java.math.BigDecimal;
/**
 * Representa a un músico de refuerzo que participa en una actuación.
 * Un músico de refuerzo tiene un nombre, un instrumento y un pago por su participación.
 */
public class MusicoRefuerzo extends Musico {
    /** Pago recibido por el músico de refuerzo. */
    private BigDecimal pago;
    /**
     * Constructor que inicializa un músico de refuerzo con su nombre, instrumento y pago.
     *
     * @param nombre      el nombre del músico.
     * @param instrumento el instrumento que toca el músico.
     * @param pago        el pago que recibirá el músico por su participación.
     */
    public MusicoRefuerzo(String nombre, String instrumento, BigDecimal pago) {
        super(nombre, instrumento);
        this.pago = pago;
    }
    /**
     * Devuelve una representación en forma de cadena del músico de refuerzo.
     * Incluye el nombre, el instrumento y el pago recibido.
     *
     * @return una cadena con la información del músico de refuerzo.
     */
    @Override
    public String toString() {
        return nombre + ", " + instrumento + ", " + pago + " €";
    }
}