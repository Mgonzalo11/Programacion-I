package dominio;

/**
 * Representa un software de seguridad.
 */
public class SoftwareDeSeguridad extends Software {
    private String tipoProteccion;

    public SoftwareDeSeguridad(int id, String nombre, String tipoIA, String lenguaje, String usoPrincipal, double precio, String tipoProteccion) {
        super(id, nombre, tipoIA, lenguaje, usoPrincipal, precio);
        this.tipoProteccion = tipoProteccion;
    }

    public String getTipoProteccion() {
        return tipoProteccion;
    }

    public void setTipoProteccion(String tipoProteccion) {
        this.tipoProteccion = tipoProteccion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo de Protección: " + tipoProteccion;
    }
}