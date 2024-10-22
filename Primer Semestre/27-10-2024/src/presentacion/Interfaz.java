package presentacion;

import dominio.*;
import java.util.*;

public class Interfaz {
    private Pais p = new Pais();
    private Scanner sc = new Scanner(System.in);

    public Interfaz() {
        p = Pais.leer();
    }

    public void grabar() {
        p.grabar();
    }

    public static void ayuda() {
        System.out.println("introduzca una de las siguientes peticiones: \n" +
                "addPais: añadir país\n" +
                "addProvincia: añadir provincia\n" +
                "addMunicipio: añadir Municipio\n" +
                "addLocalidad: añadir Localidad\n" +
                "list: listar el contenido\n" +
                "read: lectura inicial\n" +
                "exit: salir\n");
    }

    public boolean procesarPeticion(String[] peticion) {
        if (peticion.length == 1) {
            if (peticion[0].equals("addPais")) {
                aniadirPais();
            } else if (peticion[0].equals("addProvincia")) {
                aniadirProvincia();
            } else if (peticion[0].equals("addMunicipio")) {
                aniadirMunicipio();
            } else if (peticion[0].equals("addLocalidad")) {
                aniadirLocalidad();
            } else if (peticion[0].equals("read")) {
                leer();
            } else if (peticion[0].equals("list")) {
                System.out.println(p);
            } else if (peticion[0].equals("help")) {
                ayuda();
            } else if (peticion[0].equals("exit")) {
                grabar();
                return false;
            } else {
                System.out.println("petición errónea");
                ayuda();
            }
        } else {
            System.out.println("petición errónea");
            ayuda();
        }
        return true;
    }

    public void aniadirPais() {
        System.out.println("Introduzca el nombre del país: ");
        String nombre = sc.nextLine();
        p.setNombre(nombre);
    }

    public void aniadirProvincia() {
        System.out.println("Introduzca una provincia: ");
        String nombre = sc.nextLine();
        p.add(new Provincia(nombre));
    }

    public void aniadirMunicipio() {
        System.out.println("Listado de provincias: ");
        for (int i = 0; i < p.size(); i++) {
            System.out.println(i + ".- " + p.getProvincia(i));
        }
        System.out.println("Número de provincia: ");
        int indiceProvincia = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        System.out.println("Nombre del municipio: ");
        String nombreMunicipio = sc.nextLine();
        p.getProvincia(indiceProvincia).add(new Municipio(nombreMunicipio));
    }

    public void aniadirLocalidad() {
        System.out.println("Listado de provincias: ");
        for (int i = 0; i < p.size(); i++) {
            System.out.println(i + ".- " + p.getProvincia(i));
        }
        System.out.println("Número de provincia: ");
        int indiceProvincia = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        Provincia pr = p.getProvincia(indiceProvincia);
        System.out.println("Listado de municipios de la provincia de " + pr.getNombre());
        for (int j = 0; j < pr.size(); j++) {
            System.out.println(j + ".- " + pr.getMunicipio(j));
        }
        System.out.println("Número de municipio: ");
        int indiceMunicipio = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        Municipio mn = pr.getMunicipio(indiceMunicipio);
        System.out.println("Nombre de la localidad: ");
        String nombreLocalidad = sc.nextLine();
        System.out.println("Población: ");
        int poblacion = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        mn.add(new Localidad(nombreLocalidad, poblacion));
    }

    public String[] leerPeticion() {
        System.out.print("?> ");
        String cadena = sc.nextLine();
        return cadena.split(" ");
    }

    public void leer() {
        String nombreP, nombreM, nombreL;
        do {
            System.out.print("Introduce el nombre de la provincia (<enter> para finalizar): ");
            nombreP = sc.nextLine();
            if (!nombreP.equals("")) {
                Provincia provincia = new Provincia(nombreP);
                do {
                    System.out.print("Introduce el nombre del municipio (<enter> para finalizar): ");
                    nombreM = sc.nextLine();
                    if (!nombreM.equals("")) {
                        Municipio municipio = new Municipio(nombreM);
                        do {
                            System.out.print("Introduce el nombre de la localidad (<enter> para finalizar): ");
                            nombreL = sc.nextLine();
                            if (!nombreL.equals("")) {
                                System.out.print("Introduce la población de la localidad: ");
                                int poblacion = sc.nextInt();
                                sc.nextLine();
                                Localidad localidad = new Localidad(nombreL, poblacion);
                                municipio.add(localidad);
                            }
                        } while (!nombreL.equals(""));
                        provincia.add(municipio);
                    }
                } while (!nombreM.equals(""));
                p.add(provincia);
            }
        } while (!nombreP.equals(""));
    }
}
