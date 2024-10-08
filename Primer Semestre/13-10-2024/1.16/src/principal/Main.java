package principal; // Paquete principal que contiene la clase principal para ejecutar el programa.
import java.util.Scanner; // Importa la clase Scanner para permitir la lectura de datos introducidos por el usuario desde la consola.
public class Main {
    // Metodo principal que ejecuta el flujo principal del programa.
    public static void main(String[] args) {
        // Crea un objeto Scanner para capturar las entradas del usuario desde la consola.
        Scanner scanner = new Scanner(System.in);
        // Solicita al usuario que introduzca una instrucción, informándole de lo que debe escribir.
        System.out.println("Introduce una instrucción (mostrar):");
        // Lee la línea completa introducida por el usuario. Se espera una instrucción para ejecutar.
        String instruccion = scanner.nextLine(); // Almacena la instrucción introducida en la variable 'instruccion'.
        // Llama al metodo 'ejecutar' de la clase 'InterfazUsuario' y le pasa la instrucción para que la procese.
        InterfazUsuario.ejecutar(instruccion); // Ejecuta la acción asociada a la instrucción proporcionada por el usuario.
        // Cierra el objeto Scanner para liberar los recursos que ha utilizado, ya que ya no se necesita.
        scanner.close(); // Cierra el escáner para evitar posibles fugas de recursos.
    }
}
