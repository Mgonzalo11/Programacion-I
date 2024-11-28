package interfaz;

import dominio.*;
import excepciones.CatalogoException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que proporciona una interfaz de usuario en la consola para interactuar con el catálogo de software.
 * Permite realizar operaciones como añadir, modificar, eliminar y listar software, además de gestionar entradas
 * de usuario de manera segura.
 */
public class Menu {
    private final Catalogo catalogo;
    private final Scanner scanner;

    private static final String MENSAJE_ENTRADA_NO_VALIDA = "❌ Entrada no válida. Por favor, ingrese un número.";
    private static final String MENSAJE_ID_MAYOR_QUE_CERO = "⚠️ El ID debe ser mayor que 0.";
    private static final String MENSAJE_NO_ENCONTRADO = "🛑 No se encontró el software con ID ";

    /**
     * Constructor de la clase Menu.
     *
     * @param catalogo El catálogo de software que será manipulado a través del menú.
     */
    public Menu(Catalogo catalogo) {
        this.catalogo = catalogo;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal al usuario y gestiona las opciones seleccionadas.
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
            System.out.println("5. ℹ️ Ayuda");
            System.out.println("0. 🚪 Salir");
            System.out.print("🔍 Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

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
                    case 5:
                        ayuda();
                        break;
                    case 0:
                        System.out.println("👋 Saliendo...");
                        break;
                    default:
                        System.out.println("❌ Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println(MENSAJE_ENTRADA_NO_VALIDA);
                scanner.nextLine();
                opcion = -1;
            }
        } while (opcion != 0);
    }

    /**
     * Metodo de ayuda que imprime todas las opciones disponibles en el programa.
     */
    public static void ayuda() {
        System.out.println("Tiene las siguientes opciones disponibles: " +
                "\n 1. ➕ Añadir Software: para añadir un software al catálogo." +
                "\n 2. ✏️ Modificar Software: para modificar un software existente." +
                "\n 3. ❌ Eliminar Software: para eliminar un software del catálogo." +
                "\n 4. 📋 Listar Software: para listar todos los software en el catálogo." +
                "\n 0. 🚪 Salir: para salir del programa.");
    }

    /**
     * Añade un nuevo software al catálogo.
     * Solicita al usuario los datos necesarios y válida la entrada antes de añadir el software.
     * Maneja excepciones relacionadas con entradas no válidas y errores de escritura en el catálogo.
     */
    private void anadirSoftware() {
        try {
            System.out.print("Ingrese ID (mayor que 0): ");
            int id = obtenerIdSoftware();
            if (!catalogo.esIdUnico(id)) {
                System.out.println("⚠️ El ID ya está en uso. Por favor, ingrese un ID único.");
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
            scanner.nextLine(); // Limpia el buffer de entrada.
            if (precio <= 0) {
                System.out.println("⚠️ El precio debe ser mayor que 0.");
                return;
            }

            System.out.println("Seleccione el tipo de software:");
            System.out.println("1. Software de Sistema");
            System.out.println("2. Software de Aplicación");
            System.out.println("3. Software de Programación");
            System.out.println("4. Software de Seguridad");
            System.out.println("5. Software de Entretenimiento");
            System.out.print("🔍 Seleccione una opción: ");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer de entrada.

            Software software = null;
            switch (tipo) {
                case 1:
                    System.out.print("Ingrese Sistema Operativo: ");
                    String sistemaOperativo = scanner.nextLine();
                    software = new SoftwareDeSistema(id, nombre, tipoIA, lenguaje, usoPrincipal, precio, sistemaOperativo);
                    break;
                case 2:
                    System.out.print("Ingrese Categoría: ");
                    String categoria = scanner.nextLine();
                    software = new SoftwareDeAplicacion(id, nombre, tipoIA, lenguaje, usoPrincipal, precio, categoria);
                    break;
                case 3:
                    System.out.print("Ingrese Lenguaje Soportado: ");
                    String lenguajeSoportado = scanner.nextLine();
                    software = new SoftwareDeProgramacion(id, nombre, tipoIA, lenguaje, usoPrincipal, precio, lenguajeSoportado);
                    break;
                case 4:
                    System.out.print("Ingrese Tipo de Protección: ");
                    String tipoProteccion = scanner.nextLine();
                    software = new SoftwareDeSeguridad(id, nombre, tipoIA, lenguaje, usoPrincipal, precio, tipoProteccion);
                    break;
                case 5:
                    System.out.print("Ingrese Tipo de Entretenimiento: ");
                    String tipoEntretenimiento = scanner.nextLine();
                    software = new SoftwareDeEntretenimiento(id, nombre, tipoIA, lenguaje, usoPrincipal, precio, tipoEntretenimiento);
                    break;
                default:
                    System.out.println("❌ Opción no válida.");
                    return;
            }

            catalogo.anadirSoftware(software);
            System.out.println("✅ Software añadido con éxito.");
        } catch (InputMismatchException e) {
            System.out.println(MENSAJE_ENTRADA_NO_VALIDA);
            scanner.nextLine(); // Limpia el buffer de entrada.
        } catch (CatalogoException e) {
            System.out.println("Error al añadir software: " + e.getMessage());
        }
    }

    /**
     * Modifica un software existente en el catálogo.
     * Solicita al usuario el ID del software a modificar y los nuevos datos, validando las entradas.
     * Muestra mensajes de error si el ID no es encontrado o si ocurren problemas durante la modificación.
     */
    private void modificarSoftware() {
        if (catalogo.getListaSoftware().isEmpty()) {
            System.out.println("No hay software en el catálogo para modificar.");
            return;
        }

        System.out.print("🔍 Introduzca el ID del software a editar: ");
        int id = obtenerIdSoftware();
        if (!catalogo.existeSoftware(id)) {
            System.out.println(MENSAJE_NO_ENCONTRADO + id + ".");
            return;
        }

        try {
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
            if (precio <= 0) {
                System.out.println("⚠️ El precio debe ser mayor que 0.");
                return;
            }

            Software nuevoSoftware = new Software(id, nombre, tipoIA, lenguaje, usoPrincipal, precio);
            boolean modificado = catalogo.modificarSoftware(id, nuevoSoftware);
            if (modificado) {
                System.out.println("✅ Software modificado con éxito.");
            } else {
                System.out.println(MENSAJE_NO_ENCONTRADO + id);
            }
        } catch (InputMismatchException e) {
            System.out.println(MENSAJE_ENTRADA_NO_VALIDA);
            scanner.nextLine(); // Limpia el buffer de entrada.
        } catch (CatalogoException e) {
            System.out.println("Error al modificar software: " + e.getMessage());
        }
    }

    /**
     * Elimina un software del catálogo.
     * Solicita al usuario el ID del software a eliminar y confirma si la operación fue exitosa.
     * Muestra un mensaje de error si el ID no es encontrado.
     */
    private void eliminarSoftware() {
        if (catalogo.getListaSoftware().isEmpty()) {
            System.out.println("No hay software en el catálogo para eliminar.");
            return;
        }

        System.out.print("🔍 Introduzca el ID del software a eliminar: ");
        int id = obtenerIdSoftware();
        if (!catalogo.existeSoftware(id)) {
            System.out.println(MENSAJE_NO_ENCONTRADO + id + ".");
            return;
        }

        try {
            boolean eliminado = catalogo.eliminarSoftware(id);
            if (eliminado) {
                System.out.println("✅ Software eliminado con éxito.");
            } else {
                System.out.println(MENSAJE_NO_ENCONTRADO + id);
            }
        } catch (CatalogoException e) {
            System.out.println("Error al eliminar software: " + e.getMessage());
        }
    }

    /**
     * Lista todos los software en el catálogo.
     * Muestra una tabla formateada con los detalles de cada software si el catálogo no está vacío.
     * Si no hay software, informa al usuario.
     */
    private void listarSoftware() {
        if (catalogo.getListaSoftware().isEmpty()) {
            System.out.println("No hay software en el catálogo para listar.");
        } else {
            catalogo.listarSoftware();
        }
    }

    /**
     * Obtiene un ID de software válido ingresado por el usuario.
     * Válida que el ID sea un número mayor que cero.
     *
     * @return El ID del software ingresado.
     */
    private int obtenerIdSoftware() {
        int id = 0;
        boolean idValido = false;
        while (!idValido) {
            try {
                id = scanner.nextInt();
                scanner.nextLine(); // Limpia el buffer de entrada.

                if (id <= 0) {
                    System.out.println(MENSAJE_ID_MAYOR_QUE_CERO);
                } else {
                    idValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println(MENSAJE_ENTRADA_NO_VALIDA);
                scanner.nextLine(); // Limpia el buffer de entrada.
            }
        }
        return id;
    }
}
