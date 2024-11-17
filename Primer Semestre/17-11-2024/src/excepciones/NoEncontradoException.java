package excepciones;
/**
 * Excepción personalizada que se lanza cuando no se encuentra un contacto.
 */
public class NoEncontradoException extends Exception {
    private String mensaje;  // Variable para almacenar el mensaje de error
    /**
     * Constructor que inicializa la excepción con un mensaje.
     *
     * @param mensaje El mensaje que describe el error.
     */
    public NoEncontradoException(String mensaje) {
        this.mensaje = mensaje;  // Asignar el mensaje al campo
    }
    /**
     * Constructor por defecto de la excepción.
     */
    /**
     * Obtiene el mensaje de la excepción.
     *
     * @return El mensaje de error.
     */
    public String getMensaje() {
        return mensaje;
    }
}