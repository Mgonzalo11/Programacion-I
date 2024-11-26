package dominio;

import java.io.Serializable;

/**
 * Clase base que representa un producto.
 * Un producto tiene un identificador único, un nombre y un precio.
 * Es la clase padre para elementos más específicos como Software.
 */
public class Producto implements Serializable {
    private final int id;
    private String nombre;
    private double precio;

    /**
     * Constructor de la clase Producto.
     * Crea un nuevo producto con los datos proporcionados.
     *
     * @param id El identificador único del producto.
     * @param nombre El nombre del producto.
     * @param precio El precio del producto.
     * @throws IllegalArgumentException Si el nombre es nulo o vacío, o si el precio no es válido.
     */
    public Producto(int id, String nombre, double precio) {
        this.id = id;
        setNombre(nombre);
        setPrecio(precio);
    }

    /**
     * Obtiene el identificador único del producto.
     *
     * @return El identificador único del producto.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nombre del producto.
     * @throws IllegalArgumentException Si el nombre es nulo o está vacío.
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio El precio del producto.
     * @throws IllegalArgumentException Si el precio es menor o igual a 0.
     */
    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0.");
        }
        this.precio = precio;
    }

    /**
     * Devuelve una representación en forma de cadena del producto.
     *
     * @return Una cadena que describe el producto con su ID, nombre y precio.
     */
    @Override
    public String toString() {
        return "Producto - ID: " + id +
                ", Nombre: '" + nombre + '\'' +
                ", Precio: $" + String.format("%.2f", precio);
    }
}
