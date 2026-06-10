package modelo;

import interfaces.IUsuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Sujeto (Subject) del patrón OBSERVER.
 * Mantiene la lista de suscriptores (IUsuario) y los notifica cada vez que
 * se registra un nuevo EventoPartido durante el encuentro.
 */
public class Partido {

    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String resultado;
    private List<EventoPartido> eventos;
    private List<IUsuario> suscriptores;


    public Partido(Equipo equipoLocal, Equipo equipoVisitante, String resultado) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.resultado = resultado;
        this.eventos = new ArrayList<>();
        this.suscriptores = new ArrayList<>();
    }

    public void suscribir(IUsuario usuario) {
        suscriptores.add(usuario);
    }

    public void desuscribir(IUsuario usuario) {
        suscriptores.remove(usuario);
    }

    /**
     * Registra un evento y notifica (push) a todos los suscriptores.
     */
    public void agregarEvento(EventoPartido evento) {
        eventos.add(evento);
        notificar(evento);
    }

    private void notificar(EventoPartido evento) {
        for (IUsuario suscriptor : suscriptores) {
            suscriptor.actualizar(evento);
        }
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public List<EventoPartido> getEventos() {
        return eventos;
    }


    @Override
    public String toString() {
        return "Partido{" +
                "equipoLocal=" + (equipoLocal != null ? equipoLocal.getNombre() : "?") +
                ", equipoVisitante=" + (equipoVisitante != null ? equipoVisitante.getNombre() : "?") +
                ", resultado='" + resultado + '\'' +
                ", eventos=" + eventos.size() +
                '}';
    }


}
