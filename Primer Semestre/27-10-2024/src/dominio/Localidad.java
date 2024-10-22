package dominio;
import java.io.Serializable;
public class Localidad implements Serializable {
    private String nombre;
    private int poblacion;
    public Localidad(String nombre_, int poblacion_) {
        nombre = nombre_;
        poblacion = poblacion_;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Localidad: ").append(nombre)
                .append(" Población: ").append(poblacion)
                .append(" habitantes\n");
        return sb.toString(); // Devuelve el contenido del StringBuilder como String
    }
    public int getPoblacion() {
        return poblacion;
    }
    public String getNombre() {
        return nombre;
    }
    public Localidad setNombre(String nombre) {
        this.nombre = nombre; // Asegúrate de usar 'this' para referirse al atributo de la clase
        return this;
    }
    public Localidad setPoblacion(int poblacion) {
        this.poblacion = poblacion; // Asegúrate de usar 'this' para referirse al atributo de la clase
        return this;
    }
}