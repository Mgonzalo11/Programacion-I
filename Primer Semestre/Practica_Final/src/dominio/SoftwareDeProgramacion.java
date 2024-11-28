package dominio;

/**
 * Representa un software de programación.
 */
public class SoftwareDeProgramacion extends Software {
    private String lenguajeSoportado;

    public SoftwareDeProgramacion(int id, String nombre, String tipoIA, String lenguaje, String usoPrincipal, double precio, String lenguajeSoportado) {
        super(id, nombre, tipoIA, lenguaje, usoPrincipal, precio);
        this.lenguajeSoportado = lenguajeSoportado;
    }

    public String getLenguajeSoportado() {
        return lenguajeSoportado;
    }

    public void setLenguajeSoportado(String lenguajeSoportado) {
        this.lenguajeSoportado = lenguajeSoportado;
    }

    @Override
    public String toString() {
        return super.toString() + ", Lenguaje Soportado: " + lenguajeSoportado;
    }
}