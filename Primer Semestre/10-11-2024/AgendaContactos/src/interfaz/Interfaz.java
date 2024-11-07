package interfaz;

import dominio.Agenda;
import dominio.Contacto;
import java.util.Scanner;

/**
 * Clase Interfaz para gestionar la interacción con el usuario en la consola.
 * Permite realizar operaciones sobre la agenda como añadir, listar, modificar y eliminar contactos.
 */
public class Interfaz {

    private Agenda agenda;      // Agenda para gestionar los contactos
    private Scanner sc;         // Scanner para leer la entrada del usuario

    /**
     * Constructor por defecto que inicializa la agenda cargándola desde el archivo de persistencia
     * y el objeto Scanner para la entrada del usuario.
     */
    public Interfaz() {
        this.agenda = Agenda.leer(); // Asume que Agenda tiene un metodo estático leer()
        sc = new Scanner(System.in);
    }

    /**
     * Constructor que permite inicializar la interfaz con una agenda existente.
     *
     * @param agenda La agenda a utilizar en esta interfaz.
     */
    public Interfaz(Agenda agenda) {
        this.agenda = agenda;
        sc = new Scanner(System.in);
    }

    /**
     * Metodo principal que gestiona el ciclo de interacción con el usuario.
     * Procesa las instrucciones y ejecuta las operaciones correspondientes.
     */
    public void InterfazUsuario() {
        mostrarOpciones();  // Muestra las opciones disponibles al usuario

        while (true) {
            System.out.print("Introduzca la instrucción: ");
            String[] instr = procesarPeticion();

            switch (instr[0].toLowerCase()) {
                case "help":
                    help();
                    break;
                case "add":
                    if (instr.length == 3) {
                        aniadir(instr[1], instr[2]);
                    } else {
                        System.out.println("Formato incorrecto para 'add'. Ejemplo: add,Nombre,Telefono");
                    }
                    break;
                case "list":
                    list();
                    break;
                case "remove":
                    if (instr.length == 2) {
                        remove(instr[1]);
                    } else {
                        System.out.println("Formato incorrecto para 'remove'. Ejemplo: remove,Nombre");
                    }
                    break;
                case "modify":
                    if (instr.length == 4) {
                        modificar(instr[1], instr[2], instr[3]);
                    } else {
                        System.out.println("Formato incorrecto para 'modify'. Ejemplo: modify,Nombre,Atributo,NuevoValor");
                    }
                    break;
                case "exit":
                    agenda.guardar();
                    System.out.println("Agenda guardada. Saliendo...");
                    return;
                default:
                    System.out.println("\nINSTRUCCIÓN NO VÁLIDA\n");
                    mostrarOpciones();
                    break;
            }
        }
    }

    /**
     * Procesa la entrada del usuario y convierte la instrucción en un arreglo de cadenas.
     * Cada elemento representa una parte de la instrucción separada por comas.
     *
     * @return Un arreglo de cadenas con los parámetros de la instrucción.
     */
    private String[] procesarPeticion() {
        String instr = sc.nextLine();
        return instr.split(",");
    }

    /**
     * Muestra todos los contactos en la agenda.
     */
    private void list() {
        System.out.println(agenda.toString());
    }

    /**
     * Muestra las instrucciones de uso de la interfaz.
     */
    private void help() {
        System.out.println("Comandos disponibles:\n" +
                "- help: Muestra este menú de ayuda con detalles de los comandos.\n" +
                "- list: Muestra todos los contactos de la agenda.\n" +
                "- add: Añade un nuevo contacto en el formato:\n\tadd,<Nombre>,<NumeroDeTelefono>\n" +
                "- remove: Elimina un contacto por nombre en el formato:\n\tremove,<Nombre>\n" +
                "- modify: Modifica un contacto en el formato:\n\tmodify,<Nombre>,<Atributo>,<NuevoValor>\n" +
                "  Atributos modificables: nombre, numeroDeTelefono.\n" +
                "- exit: Guarda y cierra la agenda.\n\n" +
                "Cada comando debe ser introducido con el formato adecuado, de lo contrario, se mostrará un error.");
    }

    /**
     * Muestra solo las opciones disponibles.
     */
    private void mostrarOpciones() {
        System.out.println("Instrucciones disponibles para el uso de la agenda:\n" +
                "- help: Muestra este menú de ayuda.\n" +
                "- list: Muestra todos los contactos de la agenda.\n" +
                "- add: Añade un contacto.\n" +
                "- remove: Elimina un contacto.\n" +
                "- modify: Modifica un contacto.\n" +
                "- exit: Guarda y cierra la agenda.");
    }

    /**
     * Añade un nuevo contacto a la agenda.
     *
     * @param nombre          Nombre del contacto.
     * @param numeroDeTelefono Número de teléfono del contacto.
     */
    private void aniadir(String nombre, String numeroDeTelefono) {
        agenda.add(new Contacto(nombre, numeroDeTelefono));
        System.out.println("Contacto añadido.");
    }

    /**
     * Elimina un contacto de la agenda utilizando el nombre.
     *
     * @param nombre Nombre del contacto.
     */
    private void remove(String nombre) {
        agenda.borrarContacto(new Contacto(nombre, ""));
        System.out.println("Contacto borrado.");
    }

    /**
     * Modifica un atributo específico de un contacto.
     *
     * @param nombre   Nombre del contacto a modificar.
     * @param atributo Atributo a modificar ("nombre", "numeroDeTelefono").
     * @param nuevo    Nuevo valor para el atributo.
     */
    private void modificar(String nombre, String atributo, String nuevo) {
        if (atributo.equals("nombre") || atributo.equals("telefono")) {
            agenda.modificarContacto(new Contacto(nombre, ""), atributo, nuevo);
            System.out.println("Contacto modificado.");
        } else {
            System.out.println("ATRIBUTO NO VÁLIDO");
        }
    }
}
