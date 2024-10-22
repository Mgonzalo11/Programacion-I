package dominio;
import java.util.ArrayList;
import java.io.Serializable;
public class Municipio implements Serializable {
    private String nombre;
    private ArrayList<Localidad> localidades;
    public Municipio(String nombre_) {
        nombre = nombre_;
        localidades = new ArrayList<Localidad>();
    }
    public Municipio add(Localidad localidad) {
        localidades.add(localidad);
        return this;
    }
    public int getPoblacion() {
        int poblacion = 0;
        for (Localidad localidad : localidades) {
            poblacion += localidad.getPoblacion();
        }
        return poblacion;
    }
    public int getLocalidades() {
        return localidades.size();
    }
    public Localidad getLocalidad(int i) {
        return localidades.get(i);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Municipio: ").append(nombre)
                .append(" Población: ").append(getPoblacion())
                .append(" habitantes\n");

        // Agrega las localidades al StringBuilder
        sb.append("Localidades:\n");
        for (Localidad localidad : localidades) {
            sb.append(localidad.toString()); // Llama al toString de Localidad
        }
        return sb.toString(); // Devuelve el contenido del StringBuilder como String
    }
    public String getNombre() {
        return nombre;
    }
}