package aplicacion;

import dominio.Catalogo;
import excepciones.CatalogoException;
import interfaz.Menu;

/**
 * Clase principal de la aplicación, que inicia la ejecución del programa.
 */
public class Principal {

    /**
     * Metodo principal que inicia la ejecución de la aplicación.
     * En este metodo se inicializa un catálogo y se crea un menú para
     * gestionar los elementos del catálogo. Si ocurre una excepción
     * relacionada con el catálogo, se captura y se informa al usuario.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        try {
            // Inicializa el catálogo
            Catalogo catalogo = new Catalogo();
            // Crea el menú asociado al catálogo
            Menu menu = new Menu(catalogo);
            // Muestra el menú al usuario
            menu.mostrarMenu();
        } catch (CatalogoException e) {
            // Captura y muestra cualquier error relacionado con el catálogo
            System.out.println("Error al iniciar la aplicación: " + e.getMessage());
        }
    }
}
