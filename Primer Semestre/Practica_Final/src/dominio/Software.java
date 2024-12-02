package dominio;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase que representa un software.
 * Esta clase incluye atributos específicos para un software, como
 * el tipo de inteligencia artificial, el lenguaje y su uso principal.
 */
public class Software implements Serializable {
    /**
     * Identificador único del software.
     */
    private final int id;

    /**
     * Nombre del software.
     */
    private String nombre;

    /**
     * Precio del software.
     */
    private double precio;

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
        this.id = id;
        this.nombre = nombre;
        this.tipoIA = tipoIA;
        this.lenguaje = lenguaje;
        this.usoPrincipal = usoPrincipal;
        this.precio = precio;
    }

    /**
     * Obtiene el identificador único del software.
     *
     * @return El identificador único del software.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del software.
     *
     * @return El nombre del software.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del software.
     *
     * @param nombre El nombre del software.
     * @throws IllegalArgumentException Si el nombre es nulo o está vacío.
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del software.
     *
     * @return El precio del software.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del software.
     *
     * @param precio El precio del software.
     * @throws IllegalArgumentException Si el precio es menor o igual a 0.
     */
    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0.");
        }
        this.precio = precio;
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
     * Compara este objeto Software con el objeto especificado para determinar si son iguales.
     *
     * @param o El objeto a comparar con este Software.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Software software = (Software) o;
        return id == software.id &&
                Double.compare(software.precio, precio) == 0 &&
                Objects.equals(nombre, software.nombre) &&
                Objects.equals(tipoIA, software.tipoIA) &&
                Objects.equals(lenguaje, software.lenguaje) &&
                Objects.equals(usoPrincipal, software.usoPrincipal);
    }

    /**
     * Devuelve un código hash para este objeto Software.
     *
     * @return Un valor de código hash para este Software.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio, tipoIA, lenguaje, usoPrincipal);
    }
    /**
     * Devuelve una representación en formato de cadena del objeto Software.
     *
     * @return Una cadena que describe el software con sus atributos.
     */
    @Override
    public String toString() {
        return "Software - ID: " + id +
                ", Nombre: '" + nombre + '\'' +
                ", Precio: $" + String.format("%.2f", precio) +
                ", Tipo de IA: '" + tipoIA + '\'' +
                ", Lenguaje: '" + lenguaje + '\'' +
                ", Uso Principal: '" + usoPrincipal + '\'';
    }
}