package principal;

import control.SistemaElecciones;
import presentacion.Interfaz;

public class Main {
    public static void main(String[] args) {
        Interfaz.iniciarInterfaz(new SistemaElecciones());
    }
}
