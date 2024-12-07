package dominio;

import java.util.ArrayList;

public class Eleccion {
    // Lista de candidatos
    private ArrayList<Candidato> candidatos;
    // Lista de papeletas
    private ArrayList<Papeleta> papeletas;
    // Metodo get para obtener la lista de papeletas
    public ArrayList<Papeleta> getPapeletas () {
        return (this.papeletas);
    }
    // Metodo get para obtener la lista de candidatos
    public ArrayList<Candidato> getCandidatos () {
        return (this.candidatos);
    }
    // Metodo set para establecer la lista de candidatos
    public void setCandidatos (ArrayList<Candidato> candidatos) {
        this.candidatos = candidatos;
    }
    // Metodo set para establecer la lista de papeletas
    public void setPapeletas (ArrayList<Papeleta> papeletas) {
        this.papeletas = papeletas;
    }
    // Metodo para realizar el recuento de votos
    public void realizarRecuento() {
        for (Papeleta papeleta : papeletas) {
            if (!papeleta.getListaPreferencias().isEmpty()) {
                Candidato primeraPreferencia = papeleta.obtenerPrimeraPreferencia();
                for (Candidato candidato : candidatos) {
                    if (primeraPreferencia.getNombre().equals(candidato.getNombre())) {
                        candidato.incrementarVotos();
                        break;
                    }
                }
            }
        }
    }
    // Metodo para eliminar el candidato con menos votos
    public void eliminarCandidatoConMenosVotos() {
        if (candidatos.isEmpty()) return;
        Candidato candidatoConMenosVotos = candidatos.getFirst();
        for (Candidato candidato : candidatos) {
            if (candidato.getVotos() < candidatoConMenosVotos.getVotos()) {
                candidatoConMenosVotos = candidato;
            }
        }
        candidatos.remove(candidatoConMenosVotos);
        for (Papeleta papeleta : papeletas) {
            papeleta.eliminarCandidato(candidatoConMenosVotos);
        }
    }
    // Metodo para comprobar si hay mayoria absoluta
    public boolean comprobarMayoriaAbsoluta() {
        for (Candidato candidato : candidatos) {
            if ((float) candidato.getVotos() / papeletas.size() > 0.50) {
                return true;
            }
        }
        return false;
    }
    // Metodo para validar las papeletas
    public boolean validarPapeletas () {
        for (Papeleta papeleta : papeletas) {
            if (papeleta.getListaPreferencias().size() != candidatos.size())
                return (false);
            for (int i = 0; i < papeleta.getListaPreferencias().size(); i++) {
                for (int j = i + 1; j < papeleta.getListaPreferencias().size(); j++) {
                    if (papeleta.getListaPreferencias().get(i).equals(papeleta.getListaPreferencias().get(j)))
                        return (false);
                }
            }
        }
        return (true);
    }
}