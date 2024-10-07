package dominio;

/**
 * Clase que representa un software de inteligencia artificial.
 */
public class Software {
    private int id;
    private String nombre;
    private String tipoIA;
    private String lenguaje;
    private String usoPrincipal;
    private double precio;

    // Constructor
    public Software(int id, String nombre, String tipoIA, String lenguaje, String usoPrincipal, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.tipoIA = tipoIA;
        this.lenguaje = lenguaje;
        this.usoPrincipal = usoPrincipal;
        this.precio = precio;
    }

    // Métodos de acceso (getters y setters)
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoIA() {
        return tipoIA;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public String getUsoPrincipal() {
        return usoPrincipal;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Software{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipoIA='" + tipoIA + '\'' +
                ", lenguaje='" + lenguaje + '\'' +
                ", usoPrincipal='" + usoPrincipal + '\'' +
                ", precio=" + precio +
                '}';
    }
}
