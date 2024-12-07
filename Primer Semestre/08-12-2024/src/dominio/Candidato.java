package dominio;

public class Candidato {
    // Atributos de la clase Candidato
    private String nombre;
    private int votos;
    // Setters de la clase Candidato
    public Candidato(String nombre) {
        this.nombre = nombre;
        this.votos = 0; // Inicializamos los votos a 0
    }

    // Getters  de la clase Candidato
    public String getNombre () {return (this.nombre);}
    public int getVotos () {return (this.votos);}
    // Metodo para incrementar los votos
    public void incrementarVotos () {this.votos++;}
    // Metodo para resetear los votos
    public void resetearVotos () {this.votos = 0;}
    // Metodo para poner en formato String los votos
    public String toString () {
        return ("El candidato: " + this.nombre + " tiene: " + this.votos + " votos");
    }
    // Metodo para comparar dos objetos de la clase Candidato
    public boolean equals (Object o) {
        if (o == null) {return (false);}
        if (!o.getClass().equals(this.getClass())) {return (false);}
        Candidato candidato = (Candidato) o;
        return (this.nombre.equals(candidato.getNombre()));
    }
    // Metodo para obtener el hashCode de un objeto de la clase Candidato
    @Override
    public int hashCode() {return (this.nombre == null) ? 0 : this.nombre.hashCode();}

}