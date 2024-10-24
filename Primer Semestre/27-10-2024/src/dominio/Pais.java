package dominio;
import java.io.*;
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
    public void grabar(){
        try {
            ObjectOutputStream fo=new ObjectOutputStream (new FileOutputStream("pais.ser"));
            fo.writeObject(this);
            fo.close();
        } catch (Exception e){
            System.out.println("error de escritura");
        }
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
