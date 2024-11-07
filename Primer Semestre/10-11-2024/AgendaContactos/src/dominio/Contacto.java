package dominio;

import java.io.Serializable;

/**
 * Clase Contacto que representa un contacto con nombre y número de teléfono.
 * Implementa Serializable para permitir su persistencia en archivos.
 */
public class Contacto implements Serializable {

    private String nombre;
    private String numeroDeTelefono;

    /**
     * Constructor completo que inicializa todos los atributos del contacto.
     *
     * @param nombre           Nombre del contacto.
     * @param numeroDeTelefono Número de teléfono del contacto.
     */
    public Contacto(String nombre, String numeroDeTelefono) {
        this.nombre = nombre;
        this.numeroDeTelefono = numeroDeTelefono;
    }

    /**
     * Constructor por defecto que inicializa los atributos con valores vacíos.
     */
    public Contacto() {
        this.nombre = "";
        this.numeroDeTelefono = "";
    }

    // Métodos getters para acceder a los atributos del contacto
    public String getNombre() {
        return nombre;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    // Métodos setters con retorno del objeto actual para encadenamiento de métodos (fluidez)
    public Contacto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Contacto setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
        return this;
    }

    /**
     * Representación en forma de cadena del contacto, mostrando nombre y número de teléfono.
     *
     * @return Cadena con la información del contacto.
     */
    @Override
    public String toString() {
        return String.format("Nombre: %s, Teléfono: %s", nombre, numeroDeTelefono);
    }

    /**
     * Metodo para comparar dos contactos. Se consideran iguales si tienen el mismo nombre
     * y número de teléfono.
     *
     * @param o Objeto a comparar.
     * @return true si los contactos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacto contacto = (Contacto) o;
        return nombre.equals(contacto.nombre) && numeroDeTelefono.equals(contacto.numeroDeTelefono);
    }

    /**
     * Genera un código hash para el contacto, utilizando el nombre y número de teléfono.
     *
     * @return Código hash del contacto.
     */
    @Override
    public int hashCode() {
        return nombre.hashCode() * 31 + numeroDeTelefono.hashCode();
    }
}