package servicio;

import estrategia.CriterioRanking;
import interfaces.ProveedorDatosDeportivos;
import modelo.Equipo;

import java.util.List;

/**
 * Fachada del sistema y CONTEXTO del patrón STRATEGY.
 *
 * - Obtiene los datos a través de un ProveedorDatosDeportivos (ADAPTER), sin
 *   conocer el formato real de la fuente.
 * - Genera rankings delegando en un CriterioRanking (STRATEGY) intercambiable
 *   en tiempo de ejecución.
 */
public class PlataformaDeportiva {

    private ProveedorDatosDeportivos proveedor;
    private CriterioRanking criterioRanking;

    public PlataformaDeportiva(ProveedorDatosDeportivos proveedor) {
        this.proveedor = proveedor;
    }

    public void setProveedor(ProveedorDatosDeportivos proveedor) {
        this.proveedor = proveedor;
    }

    public void setCriterioRanking(CriterioRanking criterioRanking) {
        this.criterioRanking = criterioRanking;
    }

    public List<Equipo> obtenerEquipos() {
        return proveedor.obtenerEquipos();
    }

    /**
     * Aplica el criterio de ranking actual. Lanza una excepción clara si no se
     * configuró ninguna estrategia.
     */
    public List<Equipo> generarRanking(List<Equipo> equipos) {
        if (criterioRanking == null) {
            throw new IllegalStateException("No se configuró un CriterioRanking (Strategy).");
        }
        return criterioRanking.ordenar(equipos);
    }
}
