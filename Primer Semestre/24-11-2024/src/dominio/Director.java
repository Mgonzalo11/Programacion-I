/**
 * Paquete que contiene las clases del dominio de la aplicación.
 */
package dominio;
/**
 * Representa al director de una banda de música.
 * Un director es un tipo específico de participante.
 */
public class Director extends Participante {
    /**
     * Constructor que inicializa un director con su nombre.
     *
     * @param nombre el nombre del director.
     */
    public Director(String nombre) {
        super(nombre);
    }
    /**
     * Devuelve una representación en forma de cadena del director.
     * Incluye el nombre y el título "director".
     *
     * @return una cadena con el nombre del director y su rol.
     */
    @Override
    public String toString() {
        return nombre + ", director";
    }
}