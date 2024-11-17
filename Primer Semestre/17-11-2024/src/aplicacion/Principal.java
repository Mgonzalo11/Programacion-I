package aplicacion;
import interfaz.Interfaz;
import dominio.Agenda;
/**
 * Clase principal que ejecuta la aplicación de gestión de contactos.
 * Esta clase contiene el metodo principal que crea una instancia de la
 * Agenda y la Interfaz, y luego inicia la interacción con el usuario.
 */
public class Principal {
    /**
     * Metodo principal que ejecuta la aplicación.
     * Crea una instancia de la Agenda y la Interfaz, y luego inicia
     * la interacción con el usuario.
     *
     * @param args Los argumentos de línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        // Crear una instancia de la Agenda para gestionar los contactos
        Agenda agenda = new Agenda();
        // Crear una instancia de la Interfaz y pasarle la Agenda para que gestione los contactos
        Interfaz interfaz = new Interfaz(agenda);
        // Llamar al metodo para iniciar la interfaz de usuario
        interfaz.InterfazUsuario();
    }
}
