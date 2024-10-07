package interfaz;

import dominio.Catalogo;
import dominio.Software; // Asegúrate de importar la clase Software
import servicios.GestionCatalogo;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Catalogo catalogo;
    private GestionCatalogo gestionCatalogo;
    private Scanner scanner;

    public Menu(Catalogo catalogo, String rutaArchivo) {
        this.catalogo = catalogo;
        this.gestionCatalogo = new GestionCatalogo(catalogo, rutaArchivo);
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("1. Añadir Software");
            System.out.println("2. Modificar Software");
            System.out.println("3. Eliminar Software");
            System.out.println("4. Listar Software");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    añadirSoftware();
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
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void añadirSoftware() {
        try {
            System.out.print("Ingrese ID (mayor que 0): ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            // Validar que el ID sea mayor que 0 y único
            if (id <= 0) {
                System.out.println("El ID debe ser mayor que 0.");
                return;
            }
            if (!catalogo.esIdUnico(id)) {
                System.out.println("El ID ya está en uso. Por favor, ingrese un ID único.");
                return;
            }

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

            // Validar que el precio sea positivo y mayor que 0
            if (precio <= 0) {
                System.out.println("El precio debe ser mayor que 0.");
                return;
            }

            Software software = new Software(id, nombre, tipoIA, lenguaje, usoPrincipal, precio);
            gestionCatalogo.añadirSoftware(software);
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número.");
            scanner.nextLine(); // Limpiar el buffer
        }
    }

    private void modificarSoftware() {
        // Verificar si hay software en el catálogo
        if (catalogo.getListaSoftware().isEmpty()) {
            System.out.println("No hay software en el catálogo para modificar.");
            return;
        }

        try {
            System.out.print("Ingrese el ID del software a modificar (mayor que 0): ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            // Validar que el ID sea mayor que 0
            if (id <= 0) {
                System.out.println("El ID debe ser mayor que 0.");
                return;
            }

            // Verificar si el software con el ID existe
            if (!catalogo.existeSoftware(id)) {
                System.out.println("No se encontró el software con ID " + id + ".");
                return;
            }

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

            // Validar que el precio sea positivo y mayor que 0
            if (precio <= 0) {
                System.out.println("El precio debe ser mayor que 0.");
                return;
            }

            Software nuevoSoftware = new Software(id, nombre, tipoIA, lenguaje, usoPrincipal, precio);
            boolean modificado = gestionCatalogo.modificarSoftware(id, nuevoSoftware);
            if (modificado) {
                System.out.println("Software modificado con éxito.");
            } else {
                System.out.println("No se encontró el software con ID " + id);
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número.");
            scanner.nextLine(); // Limpiar el buffer
        }
    }

    private void eliminarSoftware() {
        // Verificar si hay software en el catálogo
        if (catalogo.getListaSoftware().isEmpty()) {
            System.out.println("No hay software en el catálogo para eliminar.");
            return;
        }

        try {
            System.out.print("Ingrese el ID del software a eliminar (mayor que 0): ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            // Validar que el ID sea mayor que 0
            if (id <= 0) {
                System.out.println("El ID debe ser mayor que 0.");
                return;
            }

            // Verificar si el software con el ID existe
            if (!catalogo.existeSoftware(id)) {
                System.out.println("No se encontró el software con ID " + id + ".");
                return;
            }

            boolean eliminado = gestionCatalogo.eliminarSoftware(id);
            if (eliminado) {
                System.out.println("Software eliminado con éxito.");
            } else {
                System.out.println("No se encontró el software con ID " + id);
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número.");
            scanner.nextLine(); // Limpiar el buffer
        }
    }

    private void listarSoftware() {
        if (catalogo.getListaSoftware().isEmpty()) {
            System.out.println("No hay software en el catálogo para listar.");
        } else {
            catalogo.listarSoftware(); // Muestra la lista de software
        }
    }
}
