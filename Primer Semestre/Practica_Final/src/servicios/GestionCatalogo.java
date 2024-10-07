package servicios;

import dominio.Catalogo;
import dominio.Software;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GestionCatalogo {
    private Catalogo catalogo;
    private String rutaArchivo;

    public GestionCatalogo(Catalogo catalogo, String rutaArchivo) {
        this.catalogo = catalogo;
        this.rutaArchivo = rutaArchivo;
    }

    public void cargarCatalogo() {
        // Implementa la carga del catálogo desde el archivo
    }

    public void guardarCatalogo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            // Escribe el encabezado
            writer.write("ID,Nombre,Tipo de IA,Lenguaje,Uso Principal,Precio");
            writer.newLine(); // Nueva línea después del encabezado

            // Escribe los datos de cada software en una nueva línea
            List<Software> listaSoftware = catalogo.getListaSoftware();
            for (Software software : listaSoftware) {
                writer.write(software.getId() + "," +
                        software.getNombre() + "," +
                        software.getTipoIA() + "," +
                        software.getLenguaje() + "," +
                        software.getUsoPrincipal() + "," +
                        software.getPrecio());
                writer.newLine(); // Nueva línea para cada software
            }
            System.out.println("Catálogo guardado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el catálogo: " + e.getMessage());
        }
    }

    // Otros métodos para añadir, modificar y eliminar software
    public boolean añadirSoftware(Software software) {
        // Añade el software al catálogo
        boolean added = catalogo.getListaSoftware().add(software);
        if (added) {
            guardarCatalogo(); // Guarda el catálogo después de añadir
        }
        return added;
    }

    public boolean modificarSoftware(int id, Software nuevoSoftware) {
        // Suponiendo que el catálogo tiene un método para buscar por ID
        Software softwareExistente = catalogo.buscarSoftwarePorId(id);
        if (softwareExistente != null) {
            // Aquí podrías aplicar la lógica para reemplazar los atributos, o si decides reemplazar el objeto:
            catalogo.getListaSoftware().remove(softwareExistente); // Elimina el viejo
            catalogo.getListaSoftware().add(nuevoSoftware); // Añade el nuevo
            return true;
        }
        return false; // No se encontró el software
    }


    public boolean eliminarSoftware(int id) {
        // Lógica para eliminar software del catálogo
        // Si se encuentra y se elimina
        guardarCatalogo(); // Guarda el catálogo después de eliminar
        return true; // Cambiar según la lógica real
    }
}
