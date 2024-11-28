package dominio;

/**
 * Representa un software de aplicación.
 */
public class SoftwareDeAplicacion extends Software {
    private String categoria;

    public SoftwareDeAplicacion(int id, String nombre, String tipoIA, String lenguaje, String usoPrincipal, double precio, String categoria) {
        super(id, nombre, tipoIA, lenguaje, usoPrincipal, precio);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return super.toString() + ", Categoría: " + categoria;
    }
}