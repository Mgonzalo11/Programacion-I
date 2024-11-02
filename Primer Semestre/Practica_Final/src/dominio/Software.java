package dominio;
import java.io.Serializable;
/**
 * La clase Software representa un producto de software con información detallada sobre su nombre, tipo de inteligencia artificial,
 * lenguaje de programación, uso principal y precio. Proporciona métodos para acceder y modificar estos atributos, y asegura la
 * validez de los datos mediante verificaciones en los métodos de establecimiento.
 */
public class Software implements Serializable {
    private final int id; // Identificador único del software
    private String nombre; // Nombre del software
    private String tipoIA; // Tipo de inteligencia artificial utilizada
    private String lenguaje; // Lenguaje de programación
    private String usoPrincipal; // Uso principal o función del software
    private double precio; // Precio del software
    /**
     * Constructor que inicializa todos los atributos de Software.
     *
     * @param id Identificador único del software.
     * @param nombre Nombre del software.
     * @param tipoIA Tipo de inteligencia artificial que utiliza.
     * @param lenguaje Lenguaje de programación utilizado.
     * @param usoPrincipal Uso principal del software.
     * @param precio Precio del software.
     * @throws IllegalArgumentException si alguno de los valores es inválido.
     */
    public Software(int id, String nombre, String tipoIA, String lenguaje, String usoPrincipal, double precio) {
        this.id = id; // Inicializa el ID del software
        setNombre(nombre); // Establece el nombre del software, validando su contenido
        setTipoIA(tipoIA); // Establece el tipo de inteligencia artificial, validando su contenido
        setLenguaje(lenguaje); // Establece el lenguaje de programación, validando su contenido
        setUsoPrincipal(usoPrincipal); // Establece el uso principal del software, validando su contenido
        setPrecio(precio); // Establece el precio, validando que sea mayor a 0
    }
    // Métodos getter y setter (no modificados)
    public int getId() {
        return id; // Retorna el ID del software
    }
    public String getNombre() {
        return nombre; // Retorna el nombre del software
    }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío."); // Valida que el nombre no sea nulo o vacío
        }
        this.nombre = nombre; // Asigna el nuevo nombre
    }
    public String getTipoIA() {
        return tipoIA; // Retorna el tipo de IA del software
    }
    public void setTipoIA(String tipoIA) {
        if (tipoIA == null || tipoIA.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de IA no puede estar vacío."); // Valida que el tipo de IA no sea nulo o vacío
        }
        this.tipoIA = tipoIA; // Asigna el nuevo tipo de IA
    }
    public String getLenguaje() {
        return lenguaje; // Retorna el lenguaje de programación del software
    }
    public void setLenguaje(String lenguaje) {
        if (lenguaje == null || lenguaje.trim().isEmpty()) {
            throw new IllegalArgumentException("El lenguaje no puede estar vacío."); // Valida que el lenguaje no sea nulo o vacío
        }
        this.lenguaje = lenguaje; // Asigna el nuevo lenguaje
    }
    public String getUsoPrincipal() {
        return usoPrincipal; // Retorna el uso principal del software
    }
    public void setUsoPrincipal(String usoPrincipal) {
        if (usoPrincipal == null || usoPrincipal.trim().isEmpty()) {
            throw new IllegalArgumentException("El uso principal no puede estar vacío."); // Valida que el uso principal no sea nulo o vacío
        }
        this.usoPrincipal = usoPrincipal; // Asigna el nuevo uso principal
    }
    public double getPrecio() {
        return precio; // Retorna el precio del software
    }
    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0."); // Valida que el precio sea mayor que 0
        }
        this.precio = precio; // Asigna el nuevo precio
    }
    /**
     * Devuelve una representación en cadena del software con todos sus atributos.
     *
     * @return Representación en formato String del software.
     */
    @Override
    public String toString() {
        return "Software - ID: " + id +
                ", Nombre: '" + nombre + '\'' +
                ", Tipo de IA: '" + tipoIA + '\'' +
                ", Lenguaje: '" + lenguaje + '\'' +
                ", Uso Principal: '" + usoPrincipal + '\'' +
                ", Precio: $" + String.format("%.2f", precio); // Representación legible del objeto
    }
}
