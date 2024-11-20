/**
 * Paquete que contiene las clases del dominio de la aplicación.
 */
package dominio;
/**
 * Clase abstracta que representa a un participante en una actuación.
 * Los participantes tienen un nombre y deben implementar su propia representación como cadena.
 */
public abstract class Participante {
    /** Nombre del participante. */
    protected String nombre;
    /**
     * Constructor que inicializa un participante con un nombre.
     *
     * @param nombre el nombre del participante.
     */
    public Participante(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo abstracto que debe ser implementado por las clases derivadas para
     * proporcionar una representación en forma de cadena del participante.
     *
     * @return una representación en forma de cadena del participante.
     */
    @Override
    public abstract String toString();
}
