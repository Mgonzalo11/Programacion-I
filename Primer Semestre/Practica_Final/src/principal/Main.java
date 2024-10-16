package principal;
// Declaraciones de Importación
import dominio.Catalogo;
import interfaz.Menu;
import servicios.GestionCatalogo;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo(); // Crea el catálogo
        // Definición de la Ruta del Archivo
        String rutaArchivo = "C:\\Users\\TESTER\\Desktop\\GitHub Repositorios\\Programacion-I\\Primer Semestre\\Practica_Final\\doc.csv"; // Asegúrate de especificar el archivo correcto

        // Crea la instancia de GestionCatalogo
        GestionCatalogo GestionCatalogo = new GestionCatalogo(catalogo, rutaArchivo);
        GestionCatalogo.cargarCatalogo(); // Carga el catálogo desde el archivo

        // Pasar la ruta del archivo al constructor del menú
        Menu menu = new Menu(catalogo, rutaArchivo); // Modificado aquí
        menu.mostrarMenu(); // Muestra el menú
    }
}

