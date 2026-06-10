package interfaces;

import modelo.EventoPartido;

/**
 * Interfaz del patrón OBSERVER.
 * Cada usuario/canal que se suscribe a un Partido reacciona a su manera
 * cuando ocurre un EventoPartido.
 */
public interface IUsuario {

    void actualizar(EventoPartido evento);

}
