package aplicacion;
import dominio.Localidad;
import dominio.Municipio;
import dominio.Provincia;
public class Principal {
    public static void main(String[] args) {
        // Crear un objeto Localidad con nombre "Madrid" y 3.200.000 habitantes
        Localidad localidad1 = new Localidad("Madrid", 3200000);
        // Mostrar la localidad por pantalla utilizando el metodo toString()
        System.out.println(localidad1);
        // Crear un municipio llamado "Madrid"
        Municipio municipio1 = new Municipio("Madrid");
        // Añadir la localidad1 al municipio1
        municipio1.addLocalidad(localidad1);
        // Mostrar el número total de habitantes del municipio sumando los habitantes de sus localidades
        System.out.println("Número total de habitantes del municipio: " + municipio1.contarHabitantes());
        // Crear una provincia llamada "Madrid"
        Provincia provincia1 = new Provincia("Madrid");
        // Añadir el municipio1 a la provincia1
        provincia1.addMunicipio(municipio1);
        // Mostrar el número total de habitantes de la provincia sumando los habitantes de sus municipios
        System.out.println("Número total de habitantes de la provincia: " + provincia1.contarHabitantes());
    }
}