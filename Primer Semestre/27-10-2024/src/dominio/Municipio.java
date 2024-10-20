package dominio;

import java.util.ArrayList;
import java.util.List;

public class Municipio {
    private String nombre; // Atributo para almacenar el nombre del municipio
    private List<Localidad> localidades; // Lista que almacena las localidades que pertenecen al municipio

    // Constructor que inicializa el nombre del municipio y la lista de localidades
    public Municipio(String nombre) {
        this.nombre = nombre;
        this.localidades = new ArrayList<>(); // Inicializa la lista de localidades vacía
    }

    // Método getter para obtener el nombre del municipio
    public String getNombre() {
        return nombre;
    }

    // Método para añadir una localidad al municipio
    public void addLocalidad(Localidad localidad) {
        localidades.add(localidad); // Añade la localidad a la lista
    }

    // Método para contar el número total de habitantes del municipio
    public int contarHabitantes() {
        int totalHabitantes = 0; // Variable que acumula el número total de habitantes
        for (Localidad localidad : localidades) {
            totalHabitantes += localidad.getNumeroDeHabitantes(); // Suma los habitantes de cada localidad
        }
        return totalHabitantes; // Devuelve el total
    }

    // Método getter para obtener la lista de localidades
    public List<Localidad> getLocalidades() {
        return localidades;
    }

    // Método toString para representar el municipio como una cadena
    @Override
    public String toString() {
        return "Municipio: " + nombre + ", Localidades: " + localidades;
    }
}

