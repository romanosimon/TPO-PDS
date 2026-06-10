package modelo;

public class Ranking {

    private Equipo equipo;
    private int golesAFavor;
    private int golesEnContra;
    private String fase;


    public Ranking(Equipo equipo, int golesAFavor, int golesEnContra, String fase) {
        this.equipo = equipo;
        this.golesAFavor = golesAFavor;
        this.golesEnContra = golesEnContra;
        this.fase = fase;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public int getGolesAFavor() {
        return golesAFavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }

    public int getDiferenciaGoles() {
        return golesAFavor - golesEnContra;
    }

    public String getFase() {
        return fase;
    }


    @Override
    public String toString() {
        return "Ranking{" +
                "equipo=" + equipo +
                ", golesAFavor=" + golesAFavor +
                ", golesEnContra=" + golesEnContra +
                ", fase='" + fase + '\'' +
                '}';
    }



}
