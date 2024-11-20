/**
 * Paquete que contiene las clases del dominio de la aplicación.
 */
package dominio;
/**
 * Representa a un músico socio que forma parte de una banda de música.
 * Un músico socio tiene un nombre, un instrumento y un número de socio.
 */
public class MusicoSocio extends Musico {
    /** Número de socio del músico. */
    private int numeroSocio;
    /**
     * Constructor que inicializa un músico socio con su nombre, instrumento y número de socio.
     *
     * @param nombre      el nombre del músico.
     * @param instrumento el instrumento que toca el músico.
     * @param numeroSocio el número de socio del músico.
     */
    public MusicoSocio(String nombre, String instrumento, int numeroSocio) {
        super(nombre, instrumento);
        this.numeroSocio = numeroSocio;
    }
    /**
     * Devuelve una representación en forma de cadena del músico socio.
     * Incluye el nombre, el instrumento y el número de socio.
     *
     * @return una cadena con la información del músico socio.
     */
    @Override
    public String toString() {
        return nombre + ", " + instrumento + ", número de socio: " + numeroSocio;
    }
}