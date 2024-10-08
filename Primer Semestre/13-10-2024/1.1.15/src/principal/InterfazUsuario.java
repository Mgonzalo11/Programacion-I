package principal; // Paquete principal donde se encuentran las clases relacionadas con la interfaz de usuario y la ejecución del programa.
import dominio.Habitante; // Importa la clase Habitante desde el paquete dominio.
import dominio.OficinaPadron; // Importa la clase OficinaPadron desde el paquete dominio.
import java.util.ArrayList; // Importa la clase ArrayList para almacenar y manipular listas de objetos.
public class InterfazUsuario {
    // Metodo que ejecuta la instrucción del usuario, procesando el comando proporcionado.
    public static void ejecutar(String instruccion) {
        OficinaPadron padron = new OficinaPadron(); // Crea una instancia de la clase OficinaPadron para acceder a los habitantes.
        // Verifica si la instrucción proporcionada es "mostrar", ignorando mayúsculas/minúsculas.
        if (instruccion.equalsIgnoreCase("mostrar")) {
            mostrarOficinaPadron(padron); // Si la instrucción es correcta, llama al metodo para mostrar el padrón de habitantes.
        } else {
            System.out.println("Error en la instrucción"); // Si la instrucción es incorrecta, muestra un mensaje de error.
        }
    }
    // Metodo privado que muestra los habitantes en el padrón.
    private static void mostrarOficinaPadron(OficinaPadron padron) {
        ArrayList<Habitante> habitantes = padron.getHabitantesPadron(); // Obtiene la lista de habitantes del padrón.
        // Itera sobre la lista de habitantes y muestra sus nombres completos.
        for (Habitante habitante : habitantes) {
            System.out.println(habitante.getNombre() + " " + habitante.getApellido1() + " " + habitante.getApellido2());
        }
        // Muestra el número total de habitantes en el padrón.
        System.out.println("El número total de habitantes es " + padron.calcularNumeroHabitantes());
    }
}
