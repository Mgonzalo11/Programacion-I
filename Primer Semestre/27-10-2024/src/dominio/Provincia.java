package dominio;
import java.util.ArrayList;
import java.io.Serializable;
public class Provincia implements Serializable {
    private String nombre;
    private ArrayList<Municipio> municipios;
    public Provincia(String nombre_) {
        nombre = nombre_;
        municipios = new ArrayList<Municipio>();
    }
    public Provincia add(Municipio municipio) {
        municipios.add(municipio);
        return this;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPoblacion() {
        int poblacion = 0;
        for (Municipio municipio : municipios) {
            poblacion += municipio.getPoblacion();
        }
        return poblacion;
    }
    public ArrayList<Municipio> getMunicipios() {
        return municipios;
    }
    public Municipio getMunicipio(int i) {
        return municipios.get(i);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Provincia: ").append(nombre)
                .append(" Población: ").append(getPoblacion())
                .append(" habitantes\n");
        // Añadir información sobre los municipios
        sb.append("Municipios:\n");
        for (Municipio municipio : municipios) {
            sb.append(municipio.toString()); // Llama al toString de Municipio
        }
        return sb.toString(); // Devuelve el contenido del StringBuilder como String
    }
    public int size() {
        return municipios.size();
    }
}