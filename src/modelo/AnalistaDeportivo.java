package modelo;

import interfaces.IUsuario;

/**
 * Observer concreto: analista. Interpreta tácticamente cada evento.
 */
public class AnalistaDeportivo implements IUsuario {

    private String nombre;

    public AnalistaDeportivo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(EventoPartido evento) {
        String autor = evento.getAutor() != null ? evento.getAutor().getNombreCompleto() : "desconocido";
        System.out.println("[ANÁLISIS] " + nombre + " 📊 evalúa el impacto del evento "
                + evento.getTipo() + " (" + autor + ", min " + evento.getMinuto()
                + ") en el desarrollo táctico del partido.");
    }

    public String getNombre() {
        return nombre;
    }
}
