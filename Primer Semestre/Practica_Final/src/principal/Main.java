package principal;

import dominio.Catalogo;
import interfaz.Menu;
import servicios.GestionCatalogo;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo(); // Crea el catálogo
        String rutaArchivo = "C:\\Users\\TESTER\\Desktop\\GitHub Repositorios\\Programacion-I\\Primer Semestre\\Practica_Final\\doc.csv"; // Asegúrate de especificar el archivo correcto

        // Crea la instancia de GestionCatalogo
        GestionCatalogo gestionCatalogo = new GestionCatalogo(catalogo, rutaArchivo);
        gestionCatalogo.cargarCatalogo(); // Carga el catálogo desde el archivo

        // Pasar la ruta del archivo al constructor del menú
        Menu menu = new Menu(catalogo, rutaArchivo); // Modificado aquí
        menu.mostrarMenu(); // Muestra el menú
    }
}

