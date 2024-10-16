package servicios;
// Declaraciones de importación
import persistencia.ArchivoCatalogo;
import dominio.Catalogo;
import dominio.Software;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// Clase para gestionar el catálogo de software
public class GestionCatalogo {
    private Catalogo catalogo;
    private String rutaArchivo;

    // Constructor que inicializa el catálogo y la ruta del archivo
    public GestionCatalogo(Catalogo catalogo, String rutaArchivo) {
        this.catalogo = catalogo;
        this.rutaArchivo = rutaArchivo;
    }

    // Metodo para cargar el catálogo desde el archivo
    public void cargarCatalogo() {
        ArchivoCatalogo archivoCatalogo = new ArchivoCatalogo(rutaArchivo);
        archivoCatalogo.cargarDesdeArchivo(catalogo);
    }

    // Metodo para guardar el catálogo
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
                writer.newLine();
            }
            System.out.println("Catálogo guardado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el catálogo: " + e.getMessage());
        }
    }

    // Metodo para añadir software
    public boolean añadirSoftware(Software software) {
        if (catalogo.buscarSoftwarePorId(software.getId()) != null) {
            System.out.println("El software con ID " + software.getId() + " ya existe.");
            return false; // Evita duplicados
        }
        boolean added = catalogo.getListaSoftware().add(software);
        if (added) {
            guardarCatalogo();
        }
        return added;
    }

    // Metodo para modificar software
    public boolean modificarSoftware(int id, Software nuevoSoftware) {
        Software softwareExistente = catalogo.buscarSoftwarePorId(id);
        if (softwareExistente != null) {
            catalogo.getListaSoftware().remove(softwareExistente); // Elimina el viejo
            catalogo.getListaSoftware().add(nuevoSoftware); // Añade el nuevo
            guardarCatalogo(); // Guarda cambios
            return true;
        }
        return false;
    }

    // Metodo para eliminar software
    public boolean eliminarSoftware(int id) {
        Software softwareExistente = catalogo.buscarSoftwarePorId(id);
        if (softwareExistente != null) {
            catalogo.getListaSoftware().remove(softwareExistente);
            guardarCatalogo();
            return true;
        }
        System.out.println("No se encontró el software con ID " + id);
        return false;
    }
}
