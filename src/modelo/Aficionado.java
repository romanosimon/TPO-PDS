package modelo;

import interfaces.IUsuario;

/**
 * Observer concreto: hincha. Recibe una alerta especial cuando el evento
 * involucra a su equipo o a su jugador preferido.
 */
public class Aficionado implements IUsuario {

    private String nombre;
    private Equipo equipo;
    private Jugador jugadorPreferido;

    public Aficionado(String nombre) {
        this.nombre = nombre;
    }

    public Aficionado(String nombre, Equipo equipo, Jugador jugadorPreferido) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.jugadorPreferido = jugadorPreferido;
    }

    @Override
    public void actualizar(EventoPartido evento) {
        boolean esMiEquipo = equipo != null
                && evento.getAutor() != null
                && evento.getAutor().getEquipo() == equipo;

        if (esMiEquipo) {
            System.out.println("[ALERTA HINCHA] " + nombre + " 🔔 ¡Vamos " + equipo.getNombre()
                    + "! " + evento.getTipo() + " de " + evento.getAutor().getNombreCompleto()
                    + " al minuto " + evento.getMinuto());
        } else {
            System.out.println("[Hincha] " + nombre + " sigue el partido: " + evento.getTipo()
                    + " al minuto " + evento.getMinuto());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Jugador getJugadorPreferido() {
        return jugadorPreferido;
    }

    public void setJugadorPreferido(Jugador jugadorPreferido) {
        this.jugadorPreferido = jugadorPreferido;
    }
}
