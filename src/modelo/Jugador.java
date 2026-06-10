package modelo;

public class Jugador {

    private String nombreCompleto;
    private String posicion;
    private Equipo equipo;


    public Jugador(String nombreCompleto, String posicion, Equipo equipo) {
        this.nombreCompleto = nombreCompleto;
        this.posicion = posicion;
        this.equipo = equipo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getPosicion() {
        return posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", posicion='" + posicion + '\'' +
                ", equipo=" + (equipo != null ? equipo.getNombre() : "sin equipo") +
                '}';
    }


}
