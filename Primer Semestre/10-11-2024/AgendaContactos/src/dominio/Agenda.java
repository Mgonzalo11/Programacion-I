package dominio;

import java.util.ArrayList;
import java.io.*;

/**
 * Clase Agenda que gestiona una lista de contactos. Permite agregar, buscar,
 * modificar, borrar y listar contactos, además de persistir la agenda en un archivo.
 */
public class Agenda implements Serializable {

    private ArrayList<Contacto> listaDeContactos;

    /**
     * Constructor por defecto que inicializa una nueva lista de contactos vacía.
     */
    public Agenda() {
        listaDeContactos = new ArrayList<>();
    }

    /**
     * Busca un contacto en la agenda por su nombre.
     *
     * @param c El contacto a buscar.
     * @return El contacto encontrado o null si no existe en la agenda.
     */
    public Contacto buscar(Contacto c) {
        int indice = listaDeContactos.indexOf(c);
        return (indice != -1) ? listaDeContactos.get(indice) : null;
    }

    /**
     * Añade un nuevo contacto a la agenda.
     *
     * @param c El contacto a añadir.
     * @return La instancia actual de Agenda para encadenamiento de métodos.
     */
    public Agenda add(Contacto c) {
        listaDeContactos.add(c);
        return this;
    }

    /**
     * Genera una representación en cadena de la lista de contactos en la agenda.
     *
     * @return Una cadena que contiene todos los contactos en la agenda.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contactos:\n");
        for (Contacto contacto : listaDeContactos) {
            sb.append(contacto.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Modifica un atributo específico de un contacto en la agenda.
     *
     * @param contacto El contacto a modificar.
     * @param atributo El atributo a modificar ("nombre", "numeroDeTelefono").
     * @param valor    El nuevo valor para el atributo.
     */
    public void modificarContacto(Contacto contacto, String atributo, String valor) {
        Contacto encontrado = buscar(contacto);
        if (encontrado != null) {
            switch (atributo.toLowerCase()) {
                case "nombre":
                    encontrado.setNombre(valor);
                    break;
                case "telefono":
                    encontrado.setNumeroDeTelefono(valor);
                    break;
                default:
                    System.out.println("Atributo no reconocido.");
                    break;
            }
        }
    }

    /**
     * Elimina un contacto de la agenda.
     *
     * @param contacto El contacto a eliminar.
     */
    public void borrarContacto(Contacto contacto) {
        listaDeContactos.remove(contacto);
    }

    /**
     * Obtiene el número de contactos en la agenda.
     *
     * @return El tamaño de la lista de contactos.
     */
    public int size() {
        return listaDeContactos.size();
    }

    /**
     * Lee una agenda desde un archivo de almacenamiento ("contactos.dat").
     *
     * @return La agenda leída del archivo o una nueva agenda si ocurre algún error.
     */
    public static Agenda leer() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("contactos.dat"))) {
            return (Agenda) ois.readObject();
        } catch (Exception e) {
            System.out.println("No se encontró el archivo o ocurrió un error al leer. Se crea una nueva agenda.");
            return new Agenda();
        }
    }

    /**
     * Guarda la agenda en un archivo ("contactos.dat") para su persistencia.
     */
    public void guardar() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("contactos.dat"))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println("Error al guardar la agenda.");
        }
    }
}
