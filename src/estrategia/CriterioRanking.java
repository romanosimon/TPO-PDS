package estrategia;

import modelo.Equipo;

import java.util.List;

/**
 * STRATEGY: define el criterio (intercambiable) con el que se ordena un ranking
 * de equipos. Nuevas formas de ordenar se agregan creando nuevas implementaciones.
 */
public interface CriterioRanking {

    List<Equipo> ordenar(List<Equipo> equipos);

}
