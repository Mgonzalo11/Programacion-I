package principal; // Asegúrate de que este paquete sea correcto
import dominio.Habitante; // Importar la clase Habitante
import dominio.OficinaPadron; // Importar la clase OficinaPadron
import java.util.ArrayList; // Importar ArrayList
public class InterfazUsuario {
    // Método que ejecuta la instrucción del usuario
    public static void ejecutar(String instruccion) {
        OficinaPadron padron = new OficinaPadron(); // Crear una instancia de OficinaPadron
        // Comprobar si la instrucción es "mostrar"
        if (instruccion.equalsIgnoreCase("mostrar")) {
            mostrarOficinaPadron(padron); // Llamar al método para mostrar el padrón
        } else {
            System.out.println("Error en la instrucción"); // Mensaje de error si la instrucción es incorrecta
        }
    }
    // Método que muestra los habitantes en el padrón
    private static void mostrarOficinaPadron(OficinaPadron padron) {
        ArrayList<Habitante> habitantes = padron.getHabitantesPadron(); // Obtener la lista de habitantes
        // Recorrer y mostrar cada habitante
        for (Habitante habitante : habitantes) {
            System.out.println(habitante.getNombre() + " " + habitante.getApellido1() + " " + habitante.getApellido2());
        }
        // Mostrar el número total de habitantes
        System.out.println("El número total de habitantes es " + padron.calcularNumeroHabitantes());
    }
}
