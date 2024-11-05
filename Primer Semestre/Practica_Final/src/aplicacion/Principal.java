package aplicacion;
// Declaraciones de Importación
import dominio.Catalogo;
import interfaz.Menu;
/**
 * Clase principal para ejecutar la aplicación de gestión de software.
 * Esta clase es el punto de entrada del programa. Crea una instancia del catálogo de software y del menú interactivo que permite al usuario
 * gestionar el catálogo a través de opciones como añadir, modificar, eliminar y listar software.
 */
public class Principal {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo(); // Crea el catálogo
        // Crea la instancia del menú
        Menu menu = new Menu(catalogo); // Pasa el catálogo al menú
        menu.mostrarMenu(); // Muestra el menú
    }
}
