package dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para gestionar un catálogo de software.
 */
public class Catalogo {
    private List<Software> listaSoftware; // Lista que almacena los objetos Software

    // Constructor vacío que inicializa la lista
    public Catalogo() {
        this.listaSoftware = new ArrayList<>(); // Inicializa la lista de software
    }

    /**
     * Método para añadir software al catálogo.
     *
     * @param software objeto Software que se desea añadir.
     */
    public void añadirSoftware(Software software) {
        listaSoftware.add(software); // Añade el software a la lista
        System.out.println("Software añadido: " + software.getNombre());
    }

    /**
     * Método para eliminar software del catálogo por ID.
     *
     * @param id ID del software que se desea eliminar.
     * @return true si se eliminó el software, false si no se encontró.
     */
    public boolean eliminarSoftware(int id) {
        Software softwareAEliminar = buscarSoftwarePorId(id);
        if (softwareAEliminar != null) {
            listaSoftware.remove(softwareAEliminar); // Elimina el software de la lista
            System.out.println("Software eliminado: " + softwareAEliminar.getNombre());
            return true; // Se eliminó correctamente
        }
        System.out.println("Software con ID " + id + " no encontrado.");
        return false; // No se encontró el software
    }

    /**
     * Método para modificar software en el catálogo.
     *
     * @param id ID del software que se desea modificar.
     * @param nuevoSoftware objeto Software con los nuevos datos.
     * @return true si se modificó el software, false si no se encontró.
     */
    public boolean modificarSoftware(int id, Software nuevoSoftware) {
        Software softwareExistente = buscarSoftwarePorId(id); // Busca el software existente
        if (softwareExistente != null) {
            // Actualiza los atributos del software existente
            softwareExistente.setNombre(nuevoSoftware.getNombre());
            softwareExistente.setTipoIA(nuevoSoftware.getTipoIA());
            softwareExistente.setLenguaje(nuevoSoftware.getLenguaje());
            softwareExistente.setUsoPrincipal(nuevoSoftware.getUsoPrincipal());
            softwareExistente.setPrecio(nuevoSoftware.getPrecio());
            System.out.println("Software modificado: " + softwareExistente.getNombre());
            return true; // Se modificó correctamente
        }
        System.out.println("Software con ID " + id + " no encontrado.");
        return false; // No se encontró el software
    }

    /**
     * Método para buscar un software por su ID.
     *
     * @param id ID del software que se desea buscar.
     * @return el objeto Software si se encuentra, null si no se encuentra.
     */
    public Software buscarSoftwarePorId(int id) {
        for (Software software : listaSoftware) {
            if (software.getId() == id) {
                return software; // Retorna el software encontrado
            }
        }
        return null; // Retorna null si no se encuentra
    }

    /**
     * Método para listar todos los software en el catálogo.
     */
    public void listarSoftware() {
        if (listaSoftware.isEmpty()) {
            System.out.println("No hay software en el catálogo.");
        } else {
            System.out.println("Lista de Software:");
            for (Software software : listaSoftware) {
                System.out.println(software); // Utiliza el método toString de Software
            }
        }
    }

    public boolean esIdUnico(int id) {
        for (Software software : listaSoftware) {
            if (software.getId() == id) {
                return false; // ID ya existe
            }
        }
        return true; // ID único
    }

    public boolean existeSoftware(int id) {
        for (Software software : listaSoftware) {
            if (software.getId() == id) {
                return true; // El software existe
            }
        }
        return false; // El software no existe
    }

    /**
     * Método para obtener la lista de software.
     *
     * @return la lista de objetos Software.
     */
    public List<Software> getListaSoftware() {
        return listaSoftware; // Retorna la lista de software
    }
}
