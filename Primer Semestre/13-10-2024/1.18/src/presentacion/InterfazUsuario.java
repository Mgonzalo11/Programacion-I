package presentacion; // Paquete principal donde se encuentran las clases relacionadas con la interfaz de usuario y la ejecución del programa.
import dominio.Habitante; // Importa la clase Habitante desde el paquete dominio.
import dominio.OficinaPadron; // Importa la clase OficinaPadron desde el paquete dominio.
import java.util.ArrayList; // Importa la clase ArrayList para almacenar y manipular listas de objetos.
import java.util.Scanner; // Importa la clase Scanner para leer datos desde la consola.
public class InterfazUsuario {
    // Metodo que ejecuta la instrucción del usuario, procesando el comando proporcionado.
    // El parámetro 'instruccion' es una cadena que puede ser "mostrar" o "añadir".
    public static void ejecutar(String instruccion) {
        OficinaPadron padron = new OficinaPadron(); // Crea una instancia de la clase OficinaPadron para acceder a los habitantes.

        // Verifica si la instrucción proporcionada es "mostrar", ignorando mayúsculas/minúsculas.
        if (instruccion.equalsIgnoreCase("mostrar")) {
            mostrarOficinaPadron(padron); // Si la instrucción es correcta, llama al metodo para mostrar el padrón de habitantes.
        } else if (instruccion.equalsIgnoreCase("añadir")) {
            // Si la instrucción es "añadir", ejecuta el metodo para añadir un nuevo habitante.
            annadirHabitante(padron);
        } else {
            // Si la instrucción es incorrecta, muestra un mensaje de error.
            System.out.println("Error en la instrucción");
        }
    }

    // Metodo privado que muestra los habitantes en el padrón.
    private static void mostrarOficinaPadron(OficinaPadron padron) {
        // Obtiene la lista de habitantes del padrón utilizando el metodo 'getHabitantesPadron'.
        ArrayList<Habitante> habitantes = padron.getHabitantesPadron();

        // Verifica si hay habitantes en el padrón.
        if (habitantes.isEmpty()) {
            // Si no hay habitantes, muestra un mensaje informativo.
            System.out.println("No hay habitantes registrados en el padrón.");
        } else {
            // Itera sobre la lista de habitantes y muestra sus nombres completos.
            for (Habitante habitante : habitantes) {
                System.out.println(habitante.getNombre() + " " + habitante.getApellido1() + " " + habitante.getApellido2());
            }
        }
        // Muestra el número total de habitantes en el padrón utilizando el metodo 'calcularNumeroHabitantes'.
        System.out.println("El número total de habitantes es " + padron.calcularNumeroHabitantes());
    }
    // Metodo privado para añadir un nuevo habitante al padrón.
    private static void annadirHabitante(OficinaPadron padron) {
        // Utiliza Scanner para recoger los datos del nuevo habitante desde la consola.
        Scanner scanner = new Scanner(System.in); // Crea una instancia de Scanner para leer desde la consola.
        // Pide al usuario que ingrese los datos del nuevo habitante.
        System.out.print("Introduce el nombre del habitante: ");
        String nombre = scanner.nextLine(); // Lee el nombre.
        System.out.print("Introduce el primer apellido del habitante: ");
        String apellido1 = scanner.nextLine(); // Lee el primer apellido.
        System.out.print("Introduce el segundo apellido del habitante: ");
        String apellido2 = scanner.nextLine(); // Lee el segundo apellido.
        // Crea un nuevo objeto Habitante con los datos proporcionados.
        Habitante nuevoHabitante = new Habitante(nombre, apellido1, apellido2);
        // Añade el nuevo habitante al padrón usando el metodo 'añadir' de la clase OficinaPadron.
        padron.annadir(nuevoHabitante);
        // Muestra un mensaje confirmando que el nuevo habitante ha sido añadido.
        System.out.println("Nuevo habitante añadido: " + nuevoHabitante.getNombre() + " " +
                nuevoHabitante.getApellido1() + " " + nuevoHabitante.getApellido2());
        // Cierra el scanner para evitar fugas de recursos.
        scanner.close();
    }
}

