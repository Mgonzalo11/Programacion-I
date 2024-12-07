package control;

import dominio.Candidato;
import dominio.Eleccion;
import dominio.Papeleta;
import java.util.ArrayList;
import java.util.Arrays;


public class SistemaElecciones {
    public Eleccion iniciarEleccion () {
        // Nueva elección con los candidatos y papeletas
        Eleccion eleccion = new Eleccion();
        eleccion.setCandidatos(introducirCandidatos());
        eleccion.setPapeletas(introducirPapeletas(
                introducirPapeleta(new Candidato("Candidato1"), new Candidato("Candidato2"), new Candidato("Candidato3")),
                introducirPapeleta(new Candidato("Candidato3"), new Candidato("Candidato2"), new Candidato("Candidato1")),
                introducirPapeleta(new Candidato("Candidato2"), new Candidato("Candidato3"), new Candidato("Candidato1"))
        ));
        // Validar papeletas
        if (!eleccion.validarPapeletas()) {
            System.out.println("Error: Las papeletas no son válidas.");
            return null;
        }
        // Realizar recuento y elimina candidatos con menos votos hasta que haya mayoria absoluta.
        boolean hayMayoriaAbsoluta;
        do {
            eleccion.realizarRecuento();
            hayMayoriaAbsoluta = eleccion.comprobarMayoriaAbsoluta();
            if (!hayMayoriaAbsoluta) {
                eleccion.eliminarCandidatoConMenosVotos();
            }
        } while (!hayMayoriaAbsoluta);

        return eleccion;
    }
    // Mostrar resultados de la elección
    public void mostrarResultados(Eleccion eleccion) {
        if (eleccion == null || eleccion.getCandidatos().isEmpty()) {
            System.out.println("No hay resultados disponibles.");
            return;
        }
        Candidato ganador = null;
        for (Candidato candidato : eleccion.getCandidatos()) {
            if (ganador == null || candidato.getVotos() > ganador.getVotos()) {
                ganador = candidato;
            }
        }
        assert ganador != null;
        System.out.println("El ganador de la elección es: " + ganador.getNombre() +
                " con " + ganador.getVotos() + " votos.");
    }

    // Introducir candidatos
    public ArrayList<Candidato> introducirCandidatos() {
        return new ArrayList<>(Arrays.asList(
                new Candidato("Candidato1"),
                new Candidato("Candidato2"),
                new Candidato("Candidato3")
        ));
    }
    // Introducir papeletas
    public ArrayList<Papeleta> introducirPapeletas(Papeleta... papeletas) {
        return new ArrayList<>(Arrays.asList(papeletas));
    }
    // Introducir papeleta
    public Papeleta introducirPapeleta(Candidato... candidatos) {
        Papeleta papeleta = new Papeleta();
        papeleta.setListaPreferencias(new ArrayList<>(Arrays.asList(candidatos)));
        return papeleta;
    }
}