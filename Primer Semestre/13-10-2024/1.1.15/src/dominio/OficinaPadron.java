package dominio; // Paquete 'dominio', que contiene las clases que representan las entidades del sistema, en este caso, la oficina del padrón.
import java.io.File; // Importa la clase File para manipular archivos en el sistema.
import java.io.IOException; // Importa la clase IOException para manejar errores relacionados con la entrada/salida de archivos.
import java.util.ArrayList; // Importa la clase ArrayList para almacenar una lista de objetos de tipo Habitante.
import java.util.Scanner; // Importa la clase Scanner para leer datos de un archivo.
public class OficinaPadron {
    // Atributo que almacena una lista de objetos Habitante, representando el padrón de habitantes.
    private ArrayList<Habitante> habitantesPadron = new ArrayList<>();
    // Constructor de la clase OficinaPadron, que carga los habitantes desde un archivo CSV al crear una instancia de la clase.
    public OficinaPadron() {
        cargarHabitantes(); // Llama al metodo 'cargarHabitantes' para cargar los datos del archivo CSV.
    }
    // Metodo para añadir un nuevo habitante al padrón.
    public void annadir(Habitante habitante) {
        habitantesPadron.add(habitante); // Añade el habitante a la lista de habitantes.
    }
    // Metodo que devuelve la lista de habitantes almacenados en el padrón.
    public ArrayList<Habitante> getHabitantesPadron() {
        return habitantesPadron; // Devuelve la lista de habitantes.
    }
    // Metodo para calcular el número total de habitantes en el padrón.
    public int calcularNumeroHabitantes() {
        return habitantesPadron.size(); // Devuelve el tamaño de la lista de habitantes, que es igual al número de habitantes.
    }
    // Metodo privado que carga los habitantes desde un archivo CSV.
    private void cargarHabitantes() {
        try {
            File fichero = new File("padron.csv"); // Ruta del archivo CSV donde están almacenados los datos.
            // Crea el archivo si no existe (opcional, ya que solo se lee el archivo en este caso).
            if (!fichero.exists()) {
                fichero.createNewFile(); // Crea el archivo si no está presente.
            }
            // Crea un escáner para leer el contenido del archivo CSV.
            Scanner sc = new Scanner(fichero);
            // Define los delimitadores como coma (',') o nueva línea ('\n') para separar los valores.
            sc.useDelimiter(",|\n");
            // Lee cada habitante del archivo CSV, donde se espera que cada línea tenga tres valores: nombre, apellido1, apellido2.
            while (sc.hasNext()) {
                // Crea un nuevo objeto Habitante con los datos leídos del archivo.
                Habitante habitante = new Habitante(sc.next(), sc.next(), sc.next());
                // Añade el nuevo habitante a la lista de habitantes del padrón.
                habitantesPadron.add(habitante);
            }
            sc.close(); // Cierra el escáner después de haber terminado de leer el archivo.
        } catch (IOException ex) {
            // Si ocurre un error al leer el archivo (por ejemplo, si el archivo no existe o no se puede acceder), muestra un mensaje de error.
            System.out.println("No hay habitantes inscritos");
        }
    }
}
