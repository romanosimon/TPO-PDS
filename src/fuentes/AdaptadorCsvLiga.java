package fuentes;

import interfaces.ProveedorDatosDeportivos;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Partido;

import java.util.ArrayList;
import java.util.List;

/**
 * ADAPTER: adapta una fuente de datos en formato CSV (Liga local) a la interfaz
 * común ProveedorDatosDeportivos.
 *
 * TODO: reemplazar los datos hardcodeados por la lectura real de un archivo .csv
 *       (separando cada línea por comas y mapeando columnas a atributos).
 */
public class AdaptadorCsvLiga implements ProveedorDatosDeportivos {

    @Override
    public List<Equipo> obtenerEquipos() {
        List<Equipo> equipos = new ArrayList<>();

        Equipo boca = new Equipo("Boca Juniors", 1905, 30, 25);
        boca.agregarJugador(new Jugador("Edinson Cavani", "Delantero", boca));
        boca.agregarJugador(new Jugador("Sergio Romero", "Arquero", boca));

        Equipo river = new Equipo("River Plate", 1901, 34, 28);
        river.agregarJugador(new Jugador("Miguel Borja", "Delantero", river));
        river.agregarJugador(new Jugador("Franco Armani", "Arquero", river));

        Equipo racing = new Equipo("Racing Club", 1903, 28, 20);
        racing.agregarJugador(new Jugador("Maximiliano Salas", "Delantero", racing));

        equipos.add(boca);
        equipos.add(river);
        equipos.add(racing);
        return equipos;
    }

    @Override
    public List<Partido> obtenerPartidosEnVivo() {
        // TODO: leer los partidos en vivo desde el archivo .csv real.
        List<Equipo> equipos = obtenerEquipos();
        List<Partido> partidos = new ArrayList<>();
        partidos.add(new Partido(equipos.get(0), equipos.get(1), "0-0"));
        return partidos;
    }
}
