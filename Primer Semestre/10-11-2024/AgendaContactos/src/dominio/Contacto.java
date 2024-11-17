package dominio;
import java.io.Serializable;
/**
 * Clase Contacto que representa un contacto con nombre, número de teléfono y un atributo
 * para marcar si es favorito. Implementa la interfaz Serializable para permitir su persistencia
 * en archivos.
 */
public class Contacto implements Serializable {
    private String nombre;              // Nombre del contacto
    private String numeroDeTelefono;    // Número de teléfono del contacto
    private boolean favorito;           // Estado para marcar si el contacto es favorito
    /**
     * Constructor completo que inicializa todos los atributos del contacto.
     *
     * @param nombre           Nombre del contacto.
     * @param numeroDeTelefono Número de teléfono del contacto.
     */
    public Contacto(String nombre, String numeroDeTelefono) {
        this.nombre = nombre;
        this.numeroDeTelefono = numeroDeTelefono;
        this.favorito = false; // Inicializa el contacto como no favorito por defecto
    }
    // Métodos getters para acceder a los atributos del contacto
    /**
     * Obtiene el nombre del contacto.
     *
     * @return Nombre del contacto.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Obtiene el número de teléfono del contacto.
     *
     * @return Número de teléfono del contacto.
     */
    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }
    // Métodos setters con retorno del objeto actual para encadenamiento de métodos (fluidez)
    /**
     * Establece el nombre del contacto.
     *
     * @param nombre Nombre del contacto.
     * @return El objeto actual para encadenamiento de métodos.
     */
    public Contacto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    /**
     * Establece el número de teléfono del contacto.
     *
     * @param numeroDeTelefono Número de teléfono del contacto.
     * @return El objeto actual para encadenamiento de métodos.
     */
    public Contacto setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
        return this;
    }
    /**
     * Establece si el contacto es favorito o no.
     *
     * @param favorito Booleano que indica si el contacto es favorito.
     * @return El objeto actual para encadenamiento de métodos.
     */
    public Contacto setFavorito(boolean favorito) {
        this.favorito = favorito;
        return this;
    }
    /**
     * Obtiene el estado de si el contacto es favorito o no.
     *
     * @return true si el contacto es favorito, false en caso contrario.
     */
    public boolean getFavorito() {
        return favorito;
    }
    /**
     * Representación en forma de cadena del contacto, mostrando el nombre y el número de teléfono.
     *
     * @return Cadena con la información del contacto.
     */
    @Override
    public String toString() {
        return String.format("Nombre: %s, Teléfono: %s", nombre, numeroDeTelefono);
    }
    /**
     * Metodo para comparar dos contactos. Se consideran iguales si tienen el mismo nombre
     * y número de teléfono.
     *
     * @param o Objeto a comparar.
     * @return true si los contactos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacto contacto = (Contacto) o;
        return nombre.equals(contacto.nombre) && numeroDeTelefono.equals(contacto.numeroDeTelefono);
    }
    /**
     * Genera un código hash para el contacto, utilizando el nombre y número de teléfono.
     *
     * @return Código hash del contacto.
     */
    @Override
    public int hashCode() {
        return nombre.hashCode() * 31 + numeroDeTelefono.hashCode();
    }
}