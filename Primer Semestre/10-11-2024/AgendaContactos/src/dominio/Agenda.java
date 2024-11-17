package dominio;
import java.util.ArrayList;
import java.io.*;
import excepciones.NoEncontradoException;
import excepciones.ContactoDuplicadoException;
/**
 * Clase Agenda que gestiona una lista de contactos. Permite agregar, buscar,
 * modificar, borrar y listar contactos, además de persistir la agenda en un archivo.
 */
public class Agenda implements Serializable {
    private ArrayList<Contacto> listaDeContactos;
    public Agenda() {
        listaDeContactos = new ArrayList<>();
    }
    public Contacto buscar(Contacto c) {
        int indice = listaDeContactos.indexOf(c);
        return (indice != -1) ? listaDeContactos.get(indice) : null;
    }
    public Agenda add(Contacto c) throws ContactoDuplicadoException {
        if (listaDeContactos.contains(c)) {
            throw new ContactoDuplicadoException(c);
        }
        listaDeContactos.add(c);
        return this;
    }
    public String favorito() {
        StringBuilder cadena = new StringBuilder();
        for (Contacto contacto : listaDeContactos) {
            if (contacto.getFavorito()) {
                cadena.append("- ").append(contacto.getNombre()).append("\n");
            }
        }
        System.out.print(cadena);
        return cadena.toString();
    }
    public boolean cambiarFavoritoV(Contacto contacto) {
        Contacto c = buscar(contacto);
        if (c != null) {
            c.setFavorito(true);
            System.out.println("El contacto " + contacto.getNombre() + " ha sido agregado a favoritos\n");
            return true;
        }
        return false;
    }
    public boolean cambiarFavoritoF(Contacto contacto) {
        Contacto c = buscar(contacto);
        if (c != null) {
            c.setFavorito(false);
            System.out.println("El contacto " + contacto.getNombre() + " ha sido eliminado de favoritos\n");
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Contactos:\n");
        for (Contacto contacto : listaDeContactos) {
            sb.append(contacto.toString()).append("\n");
        }
        return sb.toString();
    }
    public void modificarContacto(Contacto contacto, String atributo, String valor) throws NoEncontradoException {
        Contacto encontrado = buscar(contacto);
        if (encontrado == null) {
            throw new NoEncontradoException("El contacto no se encuentra en la agenda.");
        }
        switch (atributo.toLowerCase()) {
            case "nombre":
                encontrado.setNombre(valor);
                break;
            case "telefono":
                encontrado.setNumeroDeTelefono(valor);
                break;
            default:
                System.out.println("Atributo no reconocido.");
                break;
        }
    }
    public boolean borrarContacto(Contacto contacto) throws NoEncontradoException {
        if (contacto == null) {
            throw new IllegalArgumentException("El contacto no puede ser nulo.");
        }
        Contacto c = buscar(contacto);
        if (c != null) {
            listaDeContactos.remove(c);
            System.out.println("El contacto " + c.getNombre() + " ha sido eliminado.");
            return true;
        }
        throw new NoEncontradoException("El contacto no se encuentra en la agenda.");
    }
    public int size() {
        return listaDeContactos.size();
    }
    public static Agenda leer() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("contactos.dat"))) {
            return (Agenda) ois.readObject();
        } catch (Exception e) {
            System.out.println("No se encontró el archivo o ocurrió un error al leer. Se crea una nueva agenda.");
            return new Agenda();
        }
    }
    public void guardar() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("contactos.dat"))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println("Error al guardar la agenda.");
        }
    }
}
