package dominio;

/* Clase para representar un software en el catálogo. */
public class Software {
    private int id; // Identificador único del software
    private String nombre; // Nombre del software
    private String tipoIA; // Tipo de inteligencia artificial que utiliza
    private String lenguaje; // Lenguaje de programación en el que está desarrollado
    private String usoPrincipal; // Uso principal o función del software
    private double precio; // Precio del software

    // Constructor que inicializa todos los atributos del software
    public Software(int id, String nombre, String tipoIA, String lenguaje, String usoPrincipal, double precio) {
        this.id = id; // Asigna el ID
        this.nombre = nombre; // Asigna el nombre
        this.tipoIA = tipoIA; // Asigna el tipo de IA
        this.lenguaje = lenguaje; // Asigna el lenguaje
        this.usoPrincipal = usoPrincipal; // Asigna el uso principal
        setPrecio(precio); // Usa el setter para aplicar la validación del precio
    }

    // Métodos de acceso (getters y setters)
    public int getId() {
        return id; // Devuelve el ID del software
    }

    public String getNombre() {
        return nombre; // Devuelve el nombre del software
    }

    /* Metodo para establecer el nombre del software. */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre; // Asigna el nuevo nombre
    }

    public String getTipoIA() {
        return tipoIA; // Devuelve el tipo de IA
    }

    // Metodo para establecer el tipo de IA del software.
    public void setTipoIA(String tipoIA) {
        if (tipoIA == null || tipoIA.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de IA no puede estar vacío.");
        }
        this.tipoIA = tipoIA; // Asigna el nuevo tipo de IA
    }

    public String getLenguaje() {
        return lenguaje; // Devuelve el lenguaje de programación
    }

    // Metodo para establecer el lenguaje de programación del software.
    public void setLenguaje(String lenguaje) {
        if (lenguaje == null || lenguaje.trim().isEmpty()) {
            throw new IllegalArgumentException("El lenguaje no puede estar vacío.");
        }
        this.lenguaje = lenguaje; // Asigna el nuevo lenguaje
    }

    public String getUsoPrincipal() {
        return usoPrincipal; // Devuelve el uso principal del software
    }

    // Metodo para establecer el uso principal del software.
    public void setUsoPrincipal(String usoPrincipal) {
        if (usoPrincipal == null || usoPrincipal.trim().isEmpty()) {
            throw new IllegalArgumentException("El uso principal no puede estar vacío.");
        }
        this.usoPrincipal = usoPrincipal; // Asigna el nuevo uso principal
    }

    public double getPrecio() {
        return precio; // Devuelve el precio del software
    }

    //Metodo para establecer el precio del software.
    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0.");
        }
        this.precio = precio; // Asigna el nuevo precio
    }

    // Metodo para obtener una representación en cadena del software.
    public String toString() {
        return String.format("Software{id=%d, nombre='%s', tipoIA='%s', lenguaje='%s', usoPrincipal='%s', precio=%.2f}",
                id, nombre, tipoIA, lenguaje, usoPrincipal, precio);
    }
}
