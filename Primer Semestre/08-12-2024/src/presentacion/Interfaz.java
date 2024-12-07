package presentacion;

import control.SistemaElecciones;

public class Interfaz {
    public static void iniciarInterfaz(SistemaElecciones sistemaElecciones) {
        // Iniciar la elección
        var eleccion = sistemaElecciones.iniciarEleccion();
        // Manejar posibles errores en la inicialización de la elección
        if (eleccion == null) {
            System.out.println("La elección no pudo completarse debido a errores en los datos iniciales.");
            return;
        }
        // Mostrar resultados de la elección
        sistemaElecciones.mostrarResultados(eleccion);
    }
}
