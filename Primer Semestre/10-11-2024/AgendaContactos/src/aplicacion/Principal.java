package aplicacion;

import interfaz.Interfaz;
import dominio.Agenda;

public class Principal {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Interfaz interfaz = new Interfaz(agenda); // Crear instancia de Interfaz con una agenda
        interfaz.InterfazUsuario(); // Llamar al méeodo para iniciar la interfaz de usuario
    }
}


