package excepciones;

/**
 * Excepción personalizada para manejar errores relacionados con el catálogo de software.
 * Esta clase extiende la clase {@code Exception} y permite incluir un mensaje de error
 * opcionalmente acompañado de una causa subyacente.
 */
public class CatalogoException extends Exception {

    /**
     * Crea una nueva instancia de {@code CatalogoException} con un mensaje de error específico.
     *
     * @param message El mensaje que describe el error.
     */
    public CatalogoException(String message) {
        super(message);
    }

    /**
     * Crea una nueva instancia de {@code CatalogoException} con un mensaje de error y una causa.
     *
     * @param message El mensaje que describe el error.
     * @param cause   La causa subyacente de la excepción (puede ser {@code null}).
     */
    public CatalogoException(String message, Throwable cause) {
        super(message, cause);
    }
}
