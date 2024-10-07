package dominio;

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

    // Métodos de acceso
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoIA() {
        return tipoIA;
    }

    public void setTipoIA(String tipoIA) {
        this.tipoIA = tipoIA;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getUsoPrincipal() {
        return usoPrincipal;
    }

    public void setUsoPrincipal(String usoPrincipal) {
        this.usoPrincipal = usoPrincipal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
