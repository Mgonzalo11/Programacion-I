import java.util.Random;
import java.util.Scanner;

public class Exercise32 {
    public static void main(String[] args) {
        // Creamos un objeto Scanner para leer las entradas del usuario
        Scanner scanner = new Scanner(System.in);

        // Mensaje de bienvenida
        System.out.println("Bienvenido al generador de números aleatorios. 🎲");

        // Bucle para repetir el proceso hasta que el usuario ingrese "exit"
        while (true) {
            // Mostrar las opciones de comandos
            System.out.println("\n📄 Mostrar ayuda: 'help' ");
            System.out.println("🎰 Generar un número aleatorio: 'generate <limSup>' ");
            System.out.println("❌ Salir: 'exit' ");

            // Mensaje para ingresar un comando
            System.out.println("\nPor favor, ingresa un comando: ");

            // Leer la entrada del usuario
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("help")) {
                // Si el comando es 'help', mostramos la ayuda
                mostrarAyuda();
            } else if (input.startsWith("generate")) {
                // Si el comando es 'generate', intentamos obtener el límite superior
                try {
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        int limSup = Integer.parseInt(parts[1]);

                        if (limSup < 1) {
                            System.out.println("El número debe ser mayor o igual a 1.");
                        } else {
                            Random random = new Random();
                            int numeroAleatorio = random.nextInt(limSup) + 1;  // Genera un número entre 1 y limSup inclusive
                            System.out.println("Número aleatorio generado: " + numeroAleatorio);
                        }
                    } else {
                        System.out.println("Uso incorrecto del comando. Debe ser 'generate <limSup>'");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: El límite superior debe ser un número entero.");
                }
            } else if (input.equals("exit")) {
                // Si el comando es 'exit', salimos del programa
                System.out.println("¡Hasta luego! 👋");
                break;
            } else {
                // Si el comando no es reconocido, mostramos un mensaje de error
                System.out.println("Comando no reconocido. Ingresa 'help', 'generate <limSup>' o 'exit'.");
            }
        }

        scanner.close();
    }

    // Metodo para mostrar el texto de ayuda
    private static void mostrarAyuda() {
        System.out.println("\n**Generador de Números Aleatorios** 🎲");
        System.out.println("Este programa genera un número aleatorio entre 1 y un número límite superior.");
        System.out.println("Para usar el programa, tienes tres comandos:");
        System.out.println("\n*'help'* 📄: Muestra este texto de ayuda.");
        System.out.println("*'generate <limSup>'* 🎰: Genera un número aleatorio entre 1 y <limSup> (inclusive).");
        System.out.println("   Ejemplo: 'generate 50' generará un número entre 1 y 50.");
        System.out.println("*'exit'* ❌: Cierra el programa.");
        System.out.println("\n🔑 Recuerda: <limSup> debe ser un número entero mayor o igual a 1.");
    }
}
