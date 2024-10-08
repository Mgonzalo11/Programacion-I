package aplicacion;
import presentacion.*;

public class Principal {
    public static void main(String[] args) {
        // Se pasa el primer argumento de 'args' a la función ejecutar
        if (args.length > 0) {
            InterfazUsuario.ejecutar(args[0]); // Pasa el primer argumento
        } else {
            System.out.println("No se proporcionó ninguna instrucción.");
        }
    }
}
