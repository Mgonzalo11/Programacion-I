package dominio;

/**
 * Representa un software de entretenimiento.
 */
public class SoftwareDeEntretenimiento extends Software {
    private String tipoEntretenimiento;

    public SoftwareDeEntretenimiento(int id, String nombre, String tipoIA, String lenguaje, String usoPrincipal, double precio, String tipoEntretenimiento) {
        super(id, nombre, tipoIA, lenguaje, usoPrincipal, precio);
        this.tipoEntretenimiento = tipoEntretenimiento;
    }

    public String getTipoEntretenimiento() {
        return tipoEntretenimiento;
    }

    public void setTipoEntretenimiento(String tipoEntretenimiento) {
        this.tipoEntretenimiento = tipoEntretenimiento;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo de Entretenimiento: " + tipoEntretenimiento;
    }
}