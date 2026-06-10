package modelo;

public class Estadistica {

    private Equipo equipo;
    private int posesion;
    private int goles;
    private int tarjetasAmarillas;
    private int tarjetasRojas;


    public Estadistica(Equipo equipo, int posesion, int goles, int tarjetasAmarillas, int tarjetasRojas) {
        this.equipo = equipo;
        this.posesion = posesion;
        this.goles = goles;
        this.tarjetasAmarillas = tarjetasAmarillas;
        this.tarjetasRojas = tarjetasRojas;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public int getPosesion() {
        return posesion;
    }

    public int getGoles() {
        return goles;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    @Override
    public String toString() {
        return "Estadistica{" +
                "equipo=" + equipo +
                ", posesion=" + posesion +
                ", goles=" + goles +
                ", tarjetasAmarillas=" + tarjetasAmarillas +
                ", tarjetasRojas=" + tarjetasRojas +
                '}';
    }


}
