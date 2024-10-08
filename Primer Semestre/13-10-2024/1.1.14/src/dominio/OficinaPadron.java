package dominio; // El paquete 'dominio' contiene las clases relacionadas con los datos principales del sistema.
import java.io.File; // Importa la clase File para trabajar con archivos.
import java.io.IOException; // Importa la clase IOException para manejar excepciones de entrada/salida.
import java.util.ArrayList; // Importa la clase ArrayList para almacenar listas de objetos.
import java.util.Scanner; // Importa la clase Scanner para leer el contenido de archivos.
public class OficinaPadron {
    private ArrayList<Habitante> habitantesPadron = new ArrayList<>(); // Lista que almacena los habitantes registrados en el padrón.
    // Constructor que se ejecuta al crear una instancia de OficinaPadron y carga los habitantes desde el archivo CSV.
    public OficinaPadron() {
        cargarHabitantes(); // Llama al metodo para cargar los habitantes desde el archivo CSV al crear la instancia.
    }
    // Metodo para añadir un habitante al padrón.
    public void annadir(Habitante habitante) {
        habitantesPadron.add(habitante); // Añade el habitante recibido como parámetro a la lista de habitantes.
    }
    // Metodo para obtener la lista completa de habitantes en el padrón.
    public ArrayList<Habitante> getHabitantesPadron() {
        return habitantesPadron; // Retorna la lista de habitantes.
    }
    // Metodo para calcular el número total de habitantes en el padrón.
    public int calcularNumeroHabitantes() {
        return habitantesPadron.size(); // Devuelve el tamaño de la lista, que es el número de habitantes.
    }
    // Metodo privado para cargar los habitantes desde un archivo CSV.
    private void cargarHabitantes() {
        try {
            File fichero = new File("padron.csv"); // Ruta del archivo CSV que contiene los habitantes.
            // Crea el archivo si no existe (esto es opcional, ya que el archivo se está leyendo).
            if (!fichero.exists()) {
                fichero.createNewFile(); // Si el archivo no existe, lo crea.
            }
            Scanner sc = new Scanner(fichero); // Crea un escáner para leer el archivo.
            sc.useDelimiter(",|\n"); // Establece el delimitador como coma (,) o nueva línea (\n) para dividir los campos.
            // Lee cada habitante del archivo CSV y lo añade a la lista de habitantes.
            while (sc.hasNext()) {
                // Crea un nuevo objeto Habitante con los datos leídos del archivo.
                Habitante habitante = new Habitante(sc.next(), sc.next(), sc.next());
                habitantesPadron.add(habitante); // Añade el nuevo habitante a la lista de habitantes.
            }
            sc.close(); // Cierra el escáner una vez que ha terminado de leer el archivo.
        } catch (IOException ex) {
            System.out.println("No hay habitantes inscritos"); // Si ocurre un error al leer el archivo, muestra un mensaje.
        }
    }
}
