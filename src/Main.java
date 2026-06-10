import estrategia.CriterioPorGoles;
import estrategia.CriterioPorPuntos;
import factory.AficionadoFactory;
import factory.AnalistaDeportivoFactory;
import factory.CasaApuestaFactory;
import factory.PeriodistaFactory;
import factory.UsuarioFactory;
import fuentes.AdaptadorTxtMundial;
import interfaces.IUsuario;
import interfaces.ProveedorDatosDeportivos;
import modelo.Equipo;
import modelo.EventoPartido;
import modelo.Jugador;
import modelo.Partido;
import modelo.TipoEvento;
import servicio.PlataformaDeportiva;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // ---------- ADAPTER ----------
        ProveedorDatosDeportivos fuente = new AdaptadorTxtMundial();
        PlataformaDeportiva plataforma = new PlataformaDeportiva(fuente);
        List<Equipo> equipos = plataforma.obtenerEquipos();

        System.out.println("=== Equipos cargados desde la fuente (ADAPTER) ===");
        for (Equipo e : equipos) {
            System.out.println(" - " + e.getNombre() + " (" + e.getCantidadJugadores() + " jugadores)");
        }

        // ---------- FACTORY METHOD ----------
        UsuarioFactory[] factories = {
                new AficionadoFactory(),
                new AnalistaDeportivoFactory(),
                new CasaApuestaFactory(),
                new PeriodistaFactory()
        };

        // ---------- OBSERVER ----------
        Equipo local = equipos.get(0);
        Equipo visitante = equipos.get(1);
        Partido partido = new Partido(local, visitante, "0-0");

        for (UsuarioFactory factory : factories) {
            IUsuario usuario = factory.crearUsuario();
            partido.suscribir(usuario);
        }

        System.out.println("\n=== Eventos del partido " + local.getNombre()
                + " vs " + visitante.getNombre() + " (OBSERVER) ===");

        Jugador autorLocal = local.getListaJugadores().get(0);
        Jugador autorVisitante = visitante.getListaJugadores().get(0);

        System.out.println("\n>> Minuto 23 - GOL");
        partido.agregarEvento(new EventoPartido(23, TipoEvento.GOL, autorLocal));

        System.out.println("\n>> Minuto 50 - TARJETA AMARILLA");
        partido.agregarEvento(new EventoPartido(50, TipoEvento.TARJETA_AMARILLA, autorVisitante));

        System.out.println("\n>> Minuto 78 - TARJETA ROJA");
        partido.agregarEvento(new EventoPartido(78, TipoEvento.TARJETA_ROJA, autorVisitante));

        // ---------- STRATEGY ----------
        System.out.println("\n=== Ranking por PUNTOS (STRATEGY) ===");
        plataforma.setCriterioRanking(new CriterioPorPuntos());
        imprimirRanking(plataforma.generarRanking(equipos));

        System.out.println("\n=== Ranking por GOLES (STRATEGY) ===");
        plataforma.setCriterioRanking(new CriterioPorGoles());
        imprimirRanking(plataforma.generarRanking(equipos));
    }

    private static void imprimirRanking(List<Equipo> equipos) {
        int posicion = 1;
        for (Equipo e : equipos) {
            System.out.println(" " + posicion++ + ". " + e.getNombre()
                    + " | puntos=" + e.getPuntos() + " | goles=" + e.getGolesAFavor());
        }
    }
}
