package aplicacion; // Paquete principal de la aplicación que contiene la clase Principal
import presentacion.*; // Importa las clases necesarias del paquete presentacion, en este caso, InterfazUsuario.
public class Principal {
    // Metodo principal que se ejecuta cuando se inicia el programa
    public static void main(String[] args) {
        // Verifica si se ha proporcionado al menos un argumento en la línea de comandos
        if (args.length > 0) {
            // Si se proporciona un argumento, ejecuta la instrucción correspondiente utilizando el primer argumento
            // El argumento debe ser "mostrar" o "añadir" según la implementación
            InterfazUsuario.ejecutar(args[0]); // Llama al metodo ejecutar de la clase InterfazUsuario pasando el primer argumento
        } else {
            // Si no se proporciona ningún argumento, muestra un mensaje de error indicando que falta la instrucción
            System.out.println("No se proporcionó ninguna instrucción."); // Mensaje de error
        }
    }
}

 