/**
 * Paquete que contiene las clases del dominio de la aplicación.
 */
package dominio;
/**
 * Clase abstracta que representa a un músico como participante de una actuación.
 * Un músico toca un instrumento y tiene un nombre.
 */
public abstract class Musico extends Participante {
    /** Instrumento que toca el músico. */
    protected String instrumento;
    /**
     * Constructor que inicializa un músico con un nombre y un instrumento.
     *
     * @param nombre      el nombre del músico.
     * @param instrumento el instrumento que toca el músico.
     */
    public Musico(String nombre, String instrumento) {
        super(nombre);
        this.instrumento = instrumento;
    }
}