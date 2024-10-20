package aplicacion;

public class Principal {
    public static void main(String[] args) {
        // Crear una instancia de GestorDatos y comenzar la gestión de provincias, municipios y localidades
        GestorDatos gestor = new GestorDatos();
        gestor.iniciar();
    }
}
