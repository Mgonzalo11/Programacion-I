package dominio;

import excepciones.CatalogoException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona un catálogo de software.
 * Permite añadir, eliminar, modificar, listar y buscar software en el catálogo.
 * Los datos se almacenan y recuperan de un archivo serializado.
 */
public class Catalogo implements Serializable {
    private List<Software> listaSoftware;
    private static final String FILE_NAME = "catalogo.dat";

    /**
     * Constructor que inicializa el catálogo y lee los datos del archivo.
     *
     * @throws CatalogoException Si ocurre un error al leer el archivo.
     */
    public Catalogo() throws CatalogoException {
        listaSoftware = new ArrayList<>();
        leer();
    }

    /**
     * Añade un nuevo software al catálogo.
     *
     * @param software El software a añadir.
     * @throws CatalogoException Si ocurre un error al escribir en el archivo.
     */
    public void anadirSoftware(Software software) throws CatalogoException {
        listaSoftware.add(software);
        escribir();
    }

    /**
     * Elimina un software del catálogo por su ID.
     *
     * @param id El ID del software a eliminar.
     * @return true si el software fue eliminado, false si no se encontró.
     * @throws CatalogoException Si ocurre un error al escribir en el archivo.
     */
    public boolean eliminarSoftware(int id) throws CatalogoException {
        Software softwareAEliminar = buscarSoftwarePorId(id);
        if (softwareAEliminar != null) {
            listaSoftware.remove(softwareAEliminar);
            escribir();
            return true;
        }
        return false;
    }

    /**
     * Modifica un software existente en el catálogo.
     *
     * @param id            El ID del software a modificar.
     * @param nuevoSoftware El nuevo software con los datos actualizados.
     * @return true si el software fue modificado, false si no se encontró.
     * @throws CatalogoException Si ocurre un error al escribir en el archivo.
     */
    public boolean modificarSoftware(int id, Software nuevoSoftware) throws CatalogoException {
        Software softwareExistente = buscarSoftwarePorId(id);
        if (softwareExistente != null) {
            softwareExistente.setNombre(nuevoSoftware.getNombre());
            softwareExistente.setTipoIA(nuevoSoftware.getTipoIA());
            softwareExistente.setLenguaje(nuevoSoftware.getLenguaje());
            softwareExistente.setUsoPrincipal(nuevoSoftware.getUsoPrincipal());
            softwareExistente.setPrecio(nuevoSoftware.getPrecio());
            escribir();
            return true;
        }
        return false;
    }

    /**
     * Busca un software en el catálogo por su ID.
     *
     * @param id El ID del software a buscar.
     * @return El software encontrado, o null si no se encontró.
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
     * Lista todos los software en el catálogo.
     * Imprime una tabla formateada con los detalles de cada software.
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
     * Lee los datos del catálogo desde un archivo.
     * Si el archivo no existe, inicializa una lista vacía.
     * Si ocurre un error de deserialización, lanza una excepción personalizada.
     *
     * @throws CatalogoException Si ocurre un error al leer el archivo.
     * @throws ClassCastException Si no se puede convertir el contenido del archivo a la lista esperada.
     */
    public void leer() throws CatalogoException {
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            listaSoftware = (List<Software>) oi.readObject();
        } catch (FileNotFoundException e) {
            listaSoftware = new ArrayList<>();
        } catch (Exception e) {
            throw new CatalogoException("Error al leer el catálogo", e);
        }
    }

    /**
     * Escribe los datos del catálogo en un archivo.
     *
     * @throws CatalogoException Si ocurre un error al escribir en el archivo.
     */
    public void escribir() throws CatalogoException {
        try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oo.writeObject(listaSoftware);
        } catch (Exception e) {
            throw new CatalogoException("Error al guardar el catálogo", e);
        }
    }

    /**
     * Verifica si un ID es único en el catálogo.
     *
     * @param id El ID a verificar.
     * @return true si el ID es único, false si ya existe.
     */
    public boolean esIdUnico(int id) {
        return buscarSoftwarePorId(id) == null;
    }

    /**
     * Verifica si un software existe en el catálogo por su ID.
     *
     * @param id El ID del software a verificar.
     * @return true si el software existe, false si no.
     */
    public boolean existeSoftware(int id) {
        return buscarSoftwarePorId(id) != null;
    }

    /**
     * Obtiene la lista de software en el catálogo.
     *
     * @return La lista de software.
     */
    public List<Software> getListaSoftware() {
        return listaSoftware;
    }
}
