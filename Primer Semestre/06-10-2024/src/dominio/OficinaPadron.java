package dominio; // Definimos el paquete dominio
import java.util.ArrayList; // Importamos la clase ArrayList para manejar una lista dinámica
public class OficinaPadron {
    // Declaramos una lista de objetos Habitante que representa el padrón
    private ArrayList<Habitante> habitantesPadron = new ArrayList<>();
    // Metodo para añadir un habitante a la lista del padrón
    public void annadir(Habitante habitante) { habitantesPadron.add(habitante); }
    // Metodo para obtener la lista de habitantes del padrón
    public ArrayList<Habitante> getHabitantesPadron() { return habitantesPadron; }
    // Metodo para calcular el número total de habitantes en el padrón
    public int calcularNumeroHabitantes() {
        return habitantesPadron.size(); // Retorna el tamaño de la lista de habitantes
    }
}
