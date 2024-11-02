package interfaz;

// Declaraciones de Importación.
import dominio.Catalogo;
import dominio.Software;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase para manejar el menú de la aplicación.
 */
public class Menu {
    private final Catalogo catalogo;  // Catálogo de software a gestionar.
    private final Scanner scanner;     // Scanner para entrada de datos.

    // Definición de constantes
    private static final String MENSAJE_ENTRADA_NO_VALIDA = "❌ Entrada no válida. Por favor, ingrese un número.";
    private static final String MENSAJE_ID_MAYOR_QUE_CERO = "⚠️ El ID debe ser mayor que 0.";
    private static final String MENSAJE_NO_ENCONTRADO = "🛑 No se encontró el software con ID ";

    // Constructor que inicializa el catálogo y el escáner.
    public Menu(Catalogo catalogo) {
        this.catalogo = catalogo;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Metodo para mostrar el menú de opciones y gestionar las selecciones del usuario.
     */
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=========================");
            System.out.println("   🌟 Menú de Software   ");
            System.out.println("=========================");
            System.out.println("1. ➕ Añadir Software");
            System.out.println("2. ✏️ Modificar Software");
            System.out.println("3. ❌ Eliminar Software");
            System.out.println("4. 📋 Listar Software");
            System.out.println("0. 🚪 Salir");
            System.out.print("🔍 Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                // Switch para seleccionar la opción.
                switch (opcion) {
                    case 1:
                        anadirSoftware();
                        break;
                    case 2:
                        modificarSoftware();
                        break;
                    case 3:
                        eliminarSoftware();
                        break;
                    case 4:
                        listarSoftware();
                        break;
                    case 0:
                        System.out.println("👋 Saliendo...");
                        break;
                    default:
                        System.out.println("❌ Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println(MENSAJE_ENTRADA_NO_VALIDA);
                scanner.nextLine(); // Limpiar buffer
                opcion = -1; // Forzar que vuelva a mostrar el menú
            }
        } while (opcion != 0);
    }

    /**
     * Metodo para añadir un software al catálogo.
     */
    private void anadirSoftware() {
        try {
            System.out.print("Ingrese ID (mayor que 0): ");
            int id = obtenerIdSoftware();  // Obtener y validar el ID.
            if (id <= 0) return; // Ya verificado en el metodo auxiliar

            // Validar que el ID sea único.
            if (!catalogo.esIdUnico(id)) {
                System.out.println("⚠️ El ID ya está en uso. Por favor, ingrese un ID único.");
                return;
            }
            // Solicitar los datos del software al usuario.
            System.out.print("Ingrese Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese Tipo de IA: ");
            String tipoIA = scanner.nextLine();
            System.out.print("Ingrese Lenguaje: ");
            String lenguaje = scanner.nextLine();
            System.out.print("Ingrese Uso Principal: ");
            String usoPrincipal = scanner.nextLine();
            System.out.print("Ingrese Precio (mayor que 0): ");
            double precio = scanner.nextDouble();
            // Validar que el precio sea positivo y mayor que 0.
            if (precio <= 0) {
                System.out.println("⚠️ El precio debe ser mayor que 0.");
                return;
            }
            // Crear un nuevo software y añadirlo al catálogo.
            Software software = new Software(id, nombre, tipoIA, lenguaje, usoPrincipal, precio);
            catalogo.anadirSoftware(software);
            System.out.println("✅ Software añadido con éxito.");
        } catch (InputMismatchException e) {
            System.out.println(MENSAJE_ENTRADA_NO_VALIDA);
            scanner.nextLine(); // Limpiar el buffer
        }
    }

    /**
     * Metodo para modificar un software en el catálogo.
     */
    private void modificarSoftware() {
        // Verificar si hay software en el catálogo
        if (catalogo.getListaSoftware().isEmpty()) {
            System.out.println("No hay software en el catálogo para modificar.");
            return;
        }

        // Mensaje para introducir el ID
        System.out.print("🔍 Introduzca el ID del software a editar: ");
        int id = obtenerIdSoftware(); // Obtener y validar el ID.
        if (id <= 0) return; // Ya verificado en el metodo auxiliar

        // Verificar si el software con el ID existe
        if (!catalogo.existeSoftware(id)) {
            System.out.println(MENSAJE_NO_ENCONTRADO + id + ".");
            return;
        }

        // Preguntar al usuario si quiere modificar cada atributo.
        System.out.print("Ingrese nuevo Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese nuevo Tipo de IA: ");
        String tipoIA = scanner.nextLine();
        System.out.print("Ingrese nuevo Lenguaje: ");
        String lenguaje = scanner.nextLine();
        System.out.print("Ingrese nuevo Uso Principal: ");
        String usoPrincipal = scanner.nextLine();
        System.out.print("Ingrese nuevo Precio (mayor que 0): ");
        double precio = scanner.nextDouble();
        // Validar que el precio sea positivo y mayor que 0.
        if (precio <= 0) {
            System.out.println("⚠️ El precio debe ser mayor que 0.");
            return;
        }
        // Modificar software con los nuevos datos
        Software nuevoSoftware = new Software(id, nombre, tipoIA, lenguaje, usoPrincipal, precio);
        boolean modificado = catalogo.modificarSoftware(id, nuevoSoftware);
        if (modificado) {
            System.out.println("✅ Software modificado con éxito.");
        } else {
            System.out.println(MENSAJE_NO_ENCONTRADO + id);
        }
    }

    /**
     * Metodo para eliminar un software del catálogo.
     */
    private void eliminarSoftware() {
        // Verificar si hay software en el catálogo
        if (catalogo.getListaSoftware().isEmpty()) {
            System.out.println("No hay software en el catálogo para eliminar.");
            return;
        }

        // Mensaje para introducir el ID
        System.out.print("🔍 Introduzca el ID del software a eliminar: ");
        int id = obtenerIdSoftware(); // Obtener y validar el ID.
        if (id <= 0) return; // Ya verificado en el metodo auxiliar

        // Verificar si el software con el ID existe
        if (!catalogo.existeSoftware(id)) {
            System.out.println(MENSAJE_NO_ENCONTRADO + id + ".");
            return;
        }

        // Eliminar el software del catálogo
        boolean eliminado = catalogo.eliminarSoftware(id);
        if (eliminado) {
            System.out.println("✅ Software eliminado con éxito.");
        } else {
            System.out.println(MENSAJE_NO_ENCONTRADO + id);
        }
    }

    /**
     * Metodo para listar todos los software en el catálogo.
     */
    private void listarSoftware() {
        if (catalogo.getListaSoftware().isEmpty()) {
            System.out.println("No hay software en el catálogo para listar.");
        } else {
            catalogo.listarSoftware(); // Llama al metodo de listar directamente en el catálogo
        }
    }

    private int obtenerIdSoftware() {
        int id = 0;
        boolean idValido = false; // Variable para verificar si el ID es válido

        while (!idValido) { // Bucle hasta obtener un ID válido
            try {
                id = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                if (id <= 0) {
                    System.out.println(MENSAJE_ID_MAYOR_QUE_CERO);
                } else {
                    idValido = true; // ID es válido
                }
            } catch (InputMismatchException e) {
                System.out.println(MENSAJE_ENTRADA_NO_VALIDA);
                scanner.nextLine(); // Limpiar el buffer
            }
        }

        return id; // Retornar el ID válido
    }
}
