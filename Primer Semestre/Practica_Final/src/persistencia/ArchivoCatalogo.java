package persistencia;
// Declaraciones de Importación
import dominio.Catalogo;
import dominio.Software;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Clase para manejar la persistencia del catálogo
public class ArchivoCatalogo {
    private String rutaArchivo;

    // Constructor que inicializa la ruta del archivo
    public ArchivoCatalogo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    // Método para cargar el catálogo desde el archivo
    public void cargarDesdeArchivo(Catalogo catalogo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            // Leer la primera línea (encabezado) y no procesarla
            br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(","); // Suponiendo que los campos están separados por comas

                // Verificar que se tengan suficientes partes
                if (partes.length < 6) {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                    continue; // Saltar a la siguiente línea
                }

                try {
                    int id = Integer.parseInt(partes[0].trim());
                    String nombre = partes[1].trim();
                    String tipoIA = partes[2].trim();
                    String lenguaje = partes[3].trim();
                    String usoPrincipal = partes[4].trim();
                    double precio = Double.parseDouble(partes[5].trim());

                    // Verificar que el id sea único
                    if (catalogo.buscarSoftwarePorId(id) == null) {
                        Software software = new Software(id, nombre, tipoIA, lenguaje, usoPrincipal, precio);
                        catalogo.añadirSoftware(software);
                    } else {
                        System.out.println("ID duplicado encontrado: " + id);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error al convertir ID o precio en la línea: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}