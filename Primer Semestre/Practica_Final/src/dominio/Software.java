package dominio;

/**
 * Clase que representa un software, heredando de Producto.
 * Esta clase incluye atributos específicos para un software, como
 * el tipo de inteligencia artificial, el lenguaje y su uso principal.
 */
public class Software extends Producto {
    /**
     * Tipo de inteligencia artificial que utiliza el software.
     */
    private String tipoIA;

    /**
     * Lenguaje de programación del software.
     */
    private String lenguaje;

    /**
     * Uso principal para el cual está diseñado el software.
     */
    private String usoPrincipal;

    /**
     * Constructor de la clase Software.
     * Inicializa un nuevo objeto Software con los atributos proporcionados.
     *
     * @param id El identificador único del software.
     * @param nombre El nombre del software.
     * @param tipoIA El tipo de inteligencia artificial que utiliza el software.
     * @param lenguaje El lenguaje de programación del software.
     * @param usoPrincipal El uso principal para el cual está diseñado el software.
     * @param precio El precio del software.
     * @throws IllegalArgumentException Si algún argumento no cumple con las validaciones.
     */
    public Software(int id, String nombre, String tipoIA, String lenguaje, String usoPrincipal, double precio) {
        super(id, nombre, precio);
        setTipoIA(tipoIA);
        setLenguaje(lenguaje);
        setUsoPrincipal(usoPrincipal);
    }

    /**
     * Obtiene el tipo de inteligencia artificial del software.
     *
     * @return El tipo de inteligencia artificial.
     */
    public String getTipoIA() {
        return tipoIA;
    }

    /**
     * Establece el tipo de inteligencia artificial del software.
     *
     * @param tipoIA El tipo de inteligencia artificial.
     * @throws IllegalArgumentException Si el tipo de IA es nulo o vacío.
     */
    public void setTipoIA(String tipoIA) {
        if (tipoIA == null || tipoIA.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de IA no puede estar vacío.");
        }
        this.tipoIA = tipoIA;
    }

    /**
     * Obtiene el lenguaje de programación del software.
     *
     * @return El lenguaje de programación.
     */
    public String getLenguaje() {
        return lenguaje;
    }

    /**
     * Establece el lenguaje de programación del software.
     *
     * @param lenguaje El lenguaje de programación.
     * @throws IllegalArgumentException Si el lenguaje es nulo o vacío.
     */
    public void setLenguaje(String lenguaje) {
        if (lenguaje == null || lenguaje.trim().isEmpty()) {
            throw new IllegalArgumentException("El lenguaje no puede estar vacío.");
        }
        this.lenguaje = lenguaje;
    }

    /**
     * Obtiene el uso principal del software.
     *
     * @return El uso principal del software.
     */
    public String getUsoPrincipal() {
        return usoPrincipal;
    }

    /**
     * Establece el uso principal del software.
     *
     * @param usoPrincipal El uso principal del software.
     * @throws IllegalArgumentException Si el uso principal es nulo o vacío.
     */
    public void setUsoPrincipal(String usoPrincipal) {
        if (usoPrincipal == null || usoPrincipal.trim().isEmpty()) {
            throw new IllegalArgumentException("El uso principal no puede estar vacío.");
        }
        this.usoPrincipal = usoPrincipal;
    }

    /**
     * Devuelve una representación en formato de cadena del objeto Software.
     *
     * @return Una cadena que describe el software con sus atributos.
     */
    @Override
    public String toString() {
        return super.toString() +
                ", Tipo de IA: '" + tipoIA + '\'' +
                ", Lenguaje: '" + lenguaje + '\'' +
                ", Uso Principal: '" + usoPrincipal + '\'';
    }
}
