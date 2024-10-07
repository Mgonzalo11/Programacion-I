package dominio; // Asegúrate de que el paquete es correcto

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OficinaPadron {
    private ArrayList<Habitante> habitantesPadron = new ArrayList<>(); // Lista de habitantes

    // Constructor que carga los habitantes desde el fichero CSV
    public OficinaPadron() {
        cargarHabitantes(); // Cargar habitantes al crear una instancia
    }

    // Método para añadir un habitante al padrón
    public void annadir(Habitante habitante) {
        habitantesPadron.add(habitante);
    }

    // Método para obtener la lista de habitantes
    public ArrayList<Habitante> getHabitantesPadron() {
        return habitantesPadron;
    }

    // Método para calcular el número total de habitantes
    public int calcularNumeroHabitantes() {
        return habitantesPadron.size(); // Devuelve el tamaño de la lista
    }

    // Método para cargar los habitantes desde el fichero CSV
    private void cargarHabitantes() {
        try {
            File fichero = new File("padron.csv"); // Ruta del archivo CSV
            // Crea el archivo si no existe (opcional, ya que lo estás leyendo)
            if (!fichero.exists()) {
                fichero.createNewFile();
            }
            Scanner sc = new Scanner(fichero); // Crea un escáner para leer el archivo
            sc.useDelimiter(",|\n"); // Establece el delimitador como coma o nueva línea

            // Lee cada habitante del archivo CSV
            while (sc.hasNext()) {
                // Crea un nuevo Habitante con los datos leídos
                Habitante habitante = new Habitante(sc.next(), sc.next(), sc.next());
                habitantesPadron.add(habitante); // Añade el nuevo Habitante a la lista
            }
            sc.close(); // Cierra el escáner
        } catch (IOException ex) {
            System.out.println("No hay habitantes inscritos"); // Manejo de errores si el archivo no se puede leer
        }
    }
}
