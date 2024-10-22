package dominio;
import java.io.Serializable;
import java.util.ArrayList;
public class Pais implements Serializable {
    private String nombre;
    private ArrayList<Provincia> provincias;
    public Pais() {
        provincias = new ArrayList<>();
    }
    public static Pais leer() {
        Pais pais = new Pais();
        return pais;
    }
    public void grabar() {
        System.out.println("Guardando el país: " + nombre);
    }
    public void add(Provincia provincia) {
        provincias.add(provincia);
    }
    public Provincia getProvincia(int index) {
        return provincias.get(index);
    }
    public int size() {
        return provincias.size();
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String toString() {
        return "País: " + nombre + ", Provincias: " + provincias;
    }
}
