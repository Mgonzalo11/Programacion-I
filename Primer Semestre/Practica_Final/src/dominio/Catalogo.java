package dominio;

import java.io.*;
import java.util.ArrayList;
import java.util.List; // Importar la interfaz List

/**
 * La clase Catalogo gestiona un catálogo de software.
 * Permite añadir, eliminar, modificar y listar software.
 */
public class Catalogo implements Serializable {
    private List<Software> listaSoftware; // Cambiar a List
    private static final String FILE_NAME = "catalogo.dat"; // Nombre del archivo donde se guardará el catálogo

    /**
     * Constructor de la clase Catalogo.
     * Inicializa la lista de software y carga los datos del catálogo desde el archivo.
     */
    public Catalogo() {
        listaSoftware = new ArrayList<>(); // Inicializa la lista
        leer(); // Leer el catálogo al iniciar
    }

    /**
     * Añade un nuevo software al catálogo y guarda el cambio en el archivo.
     *
     * @param software El objeto Software a añadir al catálogo.
     */
    public void anadirSoftware(Software software) {
        listaSoftware.add(software);
        escribir(); // Guardar después de añadir
    }

    /**
     * Elimina un software del catálogo basado en su ID y guarda el cambio en el archivo.
     *
     * @param id El ID del software a eliminar.
     * @return true si el software fue eliminado, false si no fue encontrado.
     */
    public boolean eliminarSoftware(int id) {
        Software softwareAEliminar = buscarSoftwarePorId(id);
        if (softwareAEliminar != null) {
            listaSoftware.remove(softwareAEliminar);
            escribir(); // Guardar después de eliminar
            return true;
        }
        return false;
    }

    /**
     * Modifica un software existente en el catálogo basado en su ID.
     *
     * @param id El ID del software a modificar.
     * @param nuevoSoftware El nuevo objeto Software con los datos actualizados.
     * @return true si el software fue modificado, false si no fue encontrado.
     */
    public boolean modificarSoftware(int id, Software nuevoSoftware) {
        Software softwareExistente = buscarSoftwarePorId(id);
        if (softwareExistente != null) {
            softwareExistente.setNombre(nuevoSoftware.getNombre());
            softwareExistente.setTipoIA(nuevoSoftware.getTipoIA());
            softwareExistente.setLenguaje(nuevoSoftware.getLenguaje());
            softwareExistente.setUsoPrincipal(nuevoSoftware.getUsoPrincipal());
            softwareExistente.setPrecio(nuevoSoftware.getPrecio());
            escribir(); // Guardar después de modificar
            return true;
        }
        return false;
    }

    /**
     * Busca un software en el catálogo por su ID.
     *
     * @param id El ID del software a buscar.
     * @return El objeto Software si se encuentra, null en caso contrario.
     */
    public Software buscarSoftwarePorId(int id) {
        for (Software software : listaSoftware) {
            if (software.getId() == id) {
                return software;
            }
        }
        return null;
    }

    /**
     * Metodo para listar todos los software en el catálogo de manera compacta.
     */
    public void listarSoftware() {
        System.out.printf("%n=========================%n");
        System.out.printf("    📋 Software Listado    %n");
        System.out.printf("=========================%n");
        System.out.printf("%-4s | %-20s | %-10s | %-10s | $%-8s%n",
                "ID", "Nombre", "Tipo IA", "Lenguaje", "Precio");
        System.out.println("---------------------------------------------------------------");

        for (Software software : listaSoftware) {
            System.out.printf("%-4d | %-20s | %-10s | %-10s | $%-8.2f%n",
                    software.getId(),
                    software.getNombre(),
                    software.getTipoIA(),
                    software.getLenguaje(),
                    software.getPrecio());
        }
    }

    /**
     * Lee los datos del catálogo desde el archivo y los inicializa.
     * Si ocurre un error, inicializa la lista de software en vacío.
     */
    public void leer() {
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            listaSoftware = (ArrayList<Software>) oi.readObject();
        } catch (Exception e) {
            listaSoftware = new ArrayList<>(); // Inicializa la lista si hay un error
        }
    }

    /**
     * Guarda la lista de software en el archivo.
     * Maneja excepciones en caso de error al guardar.
     */
    public void escribir() {
        try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oo.writeObject(listaSoftware);
        } catch (Exception e) {
            System.out.print("Error al guardar los datos en el fichero: " + e.getMessage());
        }
    }

    /**
     * Verifica si el ID del software es único.
     *
     * @param id El ID a verificar.
     * @return true si el ID es único, false en caso contrario.
     */
    public boolean esIdUnico(int id) {
        return buscarSoftwarePorId(id) == null;
    }

    /**
     * Obtiene la lista de software.
     *
     * @return La lista de software.
     */
    public List<Software> getListaSoftware() { // Cambiar a List como tipo de retorno
        return listaSoftware;
    }

    /**
     * Verifica si existe un software con el ID dado.
     *
     * @param id El ID del software a verificar.
     * @return true si existe, false en caso contrario.
     */
    public boolean existeSoftware(int id) {
        return buscarSoftwarePorId(id) != null;
    }
}
