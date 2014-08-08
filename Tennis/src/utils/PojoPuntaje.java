package utils;

import tennis.Player;

/**
 *
 * @author jorge
 */
public class PojoPuntaje {
    int puntoJugador1;
    int puntoJugador2;
    String score;
    
    public PojoPuntaje(Player player1, Player player2, String score) {
        setPuntoJugador1(player1.getPoint());
        setPuntoJugador2(player2.getPoint());
        setScore(score);
    }
    
    public int getPuntoJugador1() {
        return puntoJugador1;
    }

    public void setPuntoJugador1(int puntoJugador1) {
        this.puntoJugador1 = puntoJugador1;
    }

    public int getPuntoJugador2() {
        return puntoJugador2;
    }

    public void setPuntoJugador2(int puntoJugador2) {
        this.puntoJugador2 = puntoJugador2;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    
}
