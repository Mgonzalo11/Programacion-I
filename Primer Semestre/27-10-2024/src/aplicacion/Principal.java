package aplicacion;
import presentacion.Interfaz;
public class Principal {
    public static void main(String[] args) {
        Interfaz interfaz=new Interfaz();
        String [] peticion;
        interfaz.ayuda();// para que muestre la ayuda al principio
        do {
            peticion=interfaz.leerPeticion();
        } while (interfaz.procesarPeticion(peticion));
    }
}
