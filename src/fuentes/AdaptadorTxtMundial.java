package fuentes;

import interfaces.ProveedorDatosDeportivos;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Partido;

import java.util.ArrayList;
import java.util.List;

/**
 * ADAPTER: adapta una fuente de datos en formato TXT (Mundial) a la interfaz
 * común ProveedorDatosDeportivos.
 *
 * TODO: reemplazar los datos hardcodeados por la lectura real de un archivo .txt
 *       (por ejemplo parseando líneas con BufferedReader).
 */
public class AdaptadorTxtMundial implements ProveedorDatosDeportivos {

    @Override
    public List<Equipo> obtenerEquipos() {
        List<Equipo> equipos = new ArrayList<>();

        Equipo argentina = new Equipo("Argentina", 1893, 9, 8);
        argentina.agregarJugador(new Jugador("Lionel Messi", "Delantero", argentina));
        argentina.agregarJugador(new Jugador("Emiliano Martínez", "Arquero", argentina));

        Equipo francia = new Equipo("Francia", 1919, 6, 20);
        francia.agregarJugador(new Jugador("Kylian Mbappé", "Delantero", francia));
        francia.agregarJugador(new Jugador("Antoine Griezmann", "Mediocampista", francia));

        Equipo croacia = new Equipo("Croacia", 1912, 4, 14);
        croacia.agregarJugador(new Jugador("Luka Modrić", "Mediocampista", croacia));

        equipos.add(argentina);
        equipos.add(francia);
        equipos.add(croacia);
        return equipos;
    }

    @Override
    public List<Partido> obtenerPartidosEnVivo() {
        // TODO: leer los partidos en vivo desde el archivo .txt real.
        List<Equipo> equipos = obtenerEquipos();
        List<Partido> partidos = new ArrayList<>();
        partidos.add(new Partido(equipos.get(0), equipos.get(1), "0-0"));
        return partidos;
    }
}
