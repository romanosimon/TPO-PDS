package modelo;

import interfaces.ProveedorDatosDeportivos;

import java.util.ArrayList;
import java.util.List;

public class DiarioOle implements ProveedorDatosDeportivos {

    private int fundacion;

    public DiarioOle(int fundacion) {
        this.fundacion = fundacion;
    }

    @Override
    public List<Partido> obtenerPartidosEnVivo() {
        List<Equipo> equipos = obtenerEquipos();
        List<Partido> partidos = new ArrayList<>();
        partidos.add(new Partido(equipos.get(0), equipos.get(1), "0-0"));
        return partidos;
    }

    @Override
    public List<Equipo> obtenerEquipos() {
        List<Equipo> equipos = new ArrayList<>();

        Equipo boca = new Equipo("Boca Juniors", 1905, 28, 22);
        boca.agregarJugador(new Jugador("Edinson Cavani", "Delantero", boca));

        Equipo river = new Equipo("River Plate", 1901, 32, 26);
        river.agregarJugador(new Jugador("Miguel Borja", "Delantero", river));

        Equipo sanLorenzo = new Equipo("San Lorenzo", 1908, 20, 18);
        sanLorenzo.agregarJugador(new Jugador("Adam Bareiro", "Delantero", sanLorenzo));

        equipos.add(boca);
        equipos.add(river);
        equipos.add(sanLorenzo);
        return equipos;
    }

    public int getFundacion() {
        return fundacion;
    }
}
