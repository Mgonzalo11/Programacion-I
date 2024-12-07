package dominio;


import java.util.ArrayList;

public class Papeleta {
    // Lista de candidatos ordenados por preferencia
    private ArrayList<Candidato> listaPreferencias;
    // Constructor por defecto para inicializar la lista de preferencias
    public Papeleta() {this.listaPreferencias = new ArrayList<>();}
    // Metodo get para obtener la lista de preferencias
    public ArrayList<Candidato> getListaPreferencias () {
        return (this.listaPreferencias);
    }
    // Metodo set para establecer la lista de preferencias
    public void setListaPreferencias(ArrayList<Candidato> listaPreferencias) {
        this.listaPreferencias = listaPreferencias;
    }
    // Constructor para obtener el primer candidato de la lista de preferencias
    public Candidato obtenerPrimeraPreferencia () {
        return (listaPreferencias.getFirst());
    }
    // Constructor para eliminar un candidato de la lista de preferencias
    public void eliminarCandidato (Candidato candidato) {
        listaPreferencias.remove(candidato);
    }
}