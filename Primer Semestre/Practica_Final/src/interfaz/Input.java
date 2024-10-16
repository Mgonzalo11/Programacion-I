package interfaz;

import java.util.Scanner;

/* Clase para manejar la entrada del usuario. */
public class Input {
    private Scanner scanner; // Scanner para leer entradas del usuario

    // Constructor que inicializa el Scanner
    public Input() {
        this.scanner = new Scanner(System.in);
    }

    // Metodo para leer una cadena (String) introducida por el usuario.
    public String leerString(String mensaje) {
        System.out.print(mensaje); // Muestra el mensaje solicitado
        return scanner.nextLine(); // Lee y retorna la entrada del usuario como String
    }

    // Metodo para leer un entero (int) introducido por el usuario.
    public int leerInt(String mensaje) {
        System.out.print(mensaje); // Muestra el mensaje solicitado
        return Integer.parseInt(scanner.nextLine()); // Lee la entrada, la convierte a int y la retorna
    }

    // Metodo para leer un número decimal (double) introducido por el usuario.
    public double leerDouble(String mensaje) {
        System.out.print(mensaje); // Muestra el mensaje solicitado
        return Double.parseDouble(scanner.nextLine()); // Lee la entrada, la convierte a double y la retorna
    }
}
