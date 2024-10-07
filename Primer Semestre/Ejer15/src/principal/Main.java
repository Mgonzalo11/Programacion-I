package principal; // Asegúrate de que este paquete sea correcto
import java.util.Scanner; // Importar Scanner para leer entradas del usuario
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crear un escáner para leer la entrada del usuario
        System.out.println("Introduce una instrucción (mostrar):");
        String instruccion = scanner.nextLine(); // Leer la instrucción del usuario
        InterfazUsuario.ejecutar(instruccion); // Ejecutar la instrucción proporcionada
        scanner.close(); // Cerrar el escáner
    }
}
