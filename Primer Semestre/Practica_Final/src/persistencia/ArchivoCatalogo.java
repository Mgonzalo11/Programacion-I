package persistencia;

import dominio.Catalogo;
import dominio.Software;  // Asegúrate de importar la clase Software
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase para manejar la persistencia del catálogo.
 */
public class ArchivoCatalogo {
    private String rutaArchivo;

    public ArchivoCatalogo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void cargarDesdeArchivo(Catalogo catalogo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(","); // Suponiendo que los campos están separados por comas
                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String tipoIA = partes[2];
                String lenguaje = partes[3];
                String usoPrincipal = partes[4];
                double precio = Double.parseDouble(partes[5]);

                // Verificar que el id sea único
                if (catalogo.buscarSoftwarePorId(id) == null) { // Método que debe existir en Catalogo
                    Software software = new Software(id, nombre, tipoIA, lenguaje, usoPrincipal, precio);
                    catalogo.añadirSoftware(software);
                } else {
                    System.out.println("ID duplicado encontrado: " + id);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
