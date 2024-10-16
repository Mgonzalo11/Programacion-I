package dominio;

import java.util.ArrayList;
import java.util.List;

// Clase para gestionar un catálogo de software.
public class Catalogo {
    private List<Software> listaSoftware; // Lista que almacena los objetos Software

    // Constructor vacío que inicializa la lista
    public Catalogo() {
        this.listaSoftware = new ArrayList<>(); // Inicializa la lista de software
    }

    // Metodo para añadir software al catálogo.
    public void añadirSoftware(Software software) {
        listaSoftware.add(software); // Añade el software a la lista
        System.out.println("Software añadido: " + software.getNombre());
    }

    // Metodo para eliminar software del catálogo por ID.
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

    // Metodo para modificar software en el catálogo.
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

    // Metodo para buscar un software por su ID.
    public Software buscarSoftwarePorId(int id) {
        for (Software software : listaSoftware) {
            if (software.getId() == id) {
                return software; // Retorna el software encontrado
            }
        }
        return null; // Retorna null si no se encuentra
    }

    // Metodo para listar todos los software en el catálogo
    public void listarSoftware() {
        if (listaSoftware.isEmpty()) {
            System.out.println("No hay software en el catálogo.");
        } else {
            System.out.println("Lista de Software:");
            for (Software software : listaSoftware) {
                System.out.println(software);
            }
        }
    }

    // Metodo que verifica si un ID es único en la lista de software.
    public boolean esIdUnico(int id) {
        // Itera sobre la lista de software
        for (Software software : listaSoftware) {
            // Si el ID del software coincide con el ID proporcionado, retorna false
            if (software.getId() == id) {
                return false; // El ID ya existe en el catálogo
            }
        }
        return true; // Si no se encuentra el ID, significa que es único
    }

    // Metodo que comprueba si un software con el ID dado existe en el catálogo.
    public boolean existeSoftware(int id) {
        // Itera sobre la lista de software
        for (Software software : listaSoftware) {
            // Si encuentra un software con el ID proporcionado, retorna true
            if (software.getId() == id) {
                return true; // El software con el ID especificado existe
            }
        }
        return false; // Si no se encuentra el software con ese ID, retorna false
    }

    // Metodo para obtener la lista de software.
    public List<Software> getListaSoftware() {
        return listaSoftware; // Retorna la lista de software
    }
}
