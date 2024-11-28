package dominio;

/**
 * Representa un software de sistema.
 */
public class SoftwareDeSistema extends Software {
    private String sistemaOperativo;

    public SoftwareDeSistema(int id, String nombre, String tipoIA, String lenguaje, String usoPrincipal, double precio, String sistemaOperativo) {
        super(id, nombre, tipoIA, lenguaje, usoPrincipal, precio);
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Sistema Operativo: " + sistemaOperativo;
    }
}