package tennis;

import vistas.LabelMarcador;

/**
 *
 * @author jorge
 */
public interface JuegoObserver {
    abstract void notificaPuntoAnotado(int numeroJugador);
    abstract void muestraScore(Juego game);
    abstract void notificaGanador(String nombreGanador);
}
