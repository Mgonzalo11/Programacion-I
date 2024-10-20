package aplicacion;

import dominio.Localidad;
import dominio.Municipio;
import dominio.Provincia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorDatos {
    private List<Provincia> provincias;

    public GestorDatos() {
        provincias = new ArrayList<>();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        String comando;

        System.out.println("Bienvenido al sistema de gestión de provincias, municipios y localidades.");

        do {
            System.out.print("Ingrese un comando (input, add, list, help, exit): ");
            comando = scanner.nextLine().trim().toLowerCase();
            ejecutarComando(comando, scanner);
        } while (!comando.equals("exit"));

        scanner.close();
        System.out.println("Programa finalizado.");
    }

    private void ejecutarComando(String comando, Scanner scanner) {
        switch (comando) {
            case "input":
                input(scanner);
                break;
            case "add":
                // Aquí puedes implementar la lógica para agregar provincias, municipios o localidades
                System.out.println("Uso: add [provincia|municipio|localidad]");
                break;
            case "list":
                listarDatos();
                break;
            case "help":
                mostrarAyuda();
                break;
            case "exit":
                // Se gestiona en el bucle principal
                break;
            default:
                System.out.println("Comando no reconocido. Intente de nuevo.");
        }
    }

    private void input(Scanner scanner) {
        System.out.println("Ingrese los datos en el siguiente formato:");
        System.out.println("provincia:NombreProvincia");
        System.out.println("municipio:NombreMunicipio;NombreProvincia");
        System.out.println("localidad:NombreLocalidad;NumeroHabitantes;NombreMunicipio;NombreProvincia");
        System.out.println("Ingrese 'fin' para terminar la entrada de datos.");

        String entrada;
        while (!(entrada = scanner.nextLine().trim()).equals("fin")) {
            String[] partes = entrada.split(":");
            if (partes.length != 2) {
                System.out.println("Formato incorrecto. Intente de nuevo.");
                continue;
            }

            String tipo = partes[0].trim();
            String contenido = partes[1].trim();

            switch (tipo) {
                case "provincia":
                    agregarProvincia(contenido);
                    break;
                case "municipio":
                    String[] municipioPartes = contenido.split(";");
                    if (municipioPartes.length == 2) {
                        agregarMunicipio(municipioPartes[0].trim(), municipioPartes[1].trim());
                    } else {
                        System.out.println("Formato incorrecto para municipio. Debe ser: municipio:NombreMunicipio;NombreProvincia");
                    }
                    break;
                case "localidad":
                    String[] localidadPartes = contenido.split(";");
                    if (localidadPartes.length == 4) {
                        agregarLocalidad(localidadPartes[0].trim(), Integer.parseInt(localidadPartes[1].trim()), localidadPartes[2].trim(), localidadPartes[3].trim());
                    } else {
                        System.out.println("Formato incorrecto para localidad. Debe ser: localidad:NombreLocalidad;NumeroHabitantes;NombreMunicipio;NombreProvincia");
                    }
                    break;
                default:
                    System.out.println("Tipo no reconocido: " + tipo);
                    break;
            }
        }
        System.out.println("Entrada de datos finalizada.");
    }

    private void agregarProvincia(String nombre) {
        provincias.add(new Provincia(nombre));
        System.out.println("Provincia " + nombre + " añadida.");
    }

    private void agregarMunicipio(String nombreMunicipio, String nombreProvincia) {
        for (Provincia provincia : provincias) {
            if (provincia.getNombre().equals(nombreProvincia)) {
                provincia.addMunicipio(new Municipio(nombreMunicipio));
                System.out.println("Municipio " + nombreMunicipio + " añadido a la provincia " + nombreProvincia);
                return;
            }
        }
        System.out.println("Provincia " + nombreProvincia + " no encontrada.");
    }

    private void agregarLocalidad(String nombreLocalidad, int habitantes, String nombreMunicipio, String nombreProvincia) {
        for (Provincia provincia : provincias) {
            if (provincia.getNombre().equals(nombreProvincia)) {
                for (Municipio municipio : provincia.getMunicipios()) {
                    if (municipio.getNombre().equals(nombreMunicipio)) {
                        municipio.addLocalidad(new Localidad(nombreLocalidad, habitantes));
                        System.out.println("Localidad " + nombreLocalidad + " añadida al municipio " + nombreMunicipio);
                        return;
                    }
                }
                System.out.println("Municipio " + nombreMunicipio + " no encontrado en la provincia " + nombreProvincia);
                return;
            }
        }
        System.out.println("Provincia " + nombreProvincia + " no encontrada.");
    }

    private void listarDatos() {
        for (Provincia provincia : provincias) {
            System.out.println(provincia);
            for (Municipio municipio : provincia.getMunicipios()) {
                System.out.println("\t" + municipio);
                for (Localidad localidad : municipio.getLocalidades()) {
                    System.out.println("\t\t" + localidad);
                }
            }
        }
    }

    private void mostrarAyuda() {
        System.out.println("Comandos disponibles:");
        System.out.println("- input: Iniciar la entrada de datos inicial.");
        System.out.println("- add: Agregar provincias, municipios o localidades.");
        System.out.println("- list: Listar todas las provincias, municipios y localidades.");
        System.out.println("- help: Mostrar esta ayuda.");
        System.out.println("- exit: Terminar el programa.");
    }
}
