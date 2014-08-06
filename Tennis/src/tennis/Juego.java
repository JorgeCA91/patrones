package tennis;

import idiomas.IdiomaInterface;

/**
 *
 * @author jorge
 */
public class Juego {
    
    private Player player1;
    private Player player2;
    private String score;
    private IdiomaInterface idioma;

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    
    public Juego(Player player1, Player player2) {
        setPlayer1(player1);
        setPlayer1(player2);
    }
    
    public void point(int numeroJugador) {
        switch(numeroJugador) {
            case 1:
                getPlayer1().setPoint(1);
                break;
            case 2:
                getPlayer2().setPoint(1);
                break;            
        }
    }
    
    public void setIdioma(IdiomaInterface idioma) {
        this.idioma = idioma;
    }
    
    private IdiomaInterface getIdioma() {
        return idioma;
    }
    
    public String marcador() {
        if (empatado()) {
            return marcadorEmpatado();
        } else if (terminado()) {
            return marcadorGanador();
        } else if (ventaja()) {
            return marcadorVentaja();
        } else {
            return marcadorNormal();
        }
    }
    
    private String num2Str(int puntaje) {
        return getIdioma().getNumero(puntaje);
    }
    
    private boolean empatado() {
        return player1.getPoint() == player2.getPoint();
    }
    
    private boolean terminado() {
        return (arribaDe40Puntos()) && conVentajaDe(20);
    }
    
    private boolean ventaja() {
        return (arribaDe40Puntos() && conVentajaDe(10));
    }
    
    private boolean arribaDe40Puntos() {
        return (player1.getPoint() > 40 || player2.getPoint() > 40);
    }
    
    private boolean conVentajaDe(int numeroPuntos) {
        return (Math.abs(player1.getPoint() - player2.getPoint()) >= numeroPuntos);
    }
    
    private String marcadorNormal() {
        return num2Str(player1.getPoint()) + "-" + num2Str(player2.getPoint());
    }
    
    private String marcadorEmpatado() {
        return (player1.getPoint() < 40) ? empateAll() : deuce();
    }
    
    private String empateAll() {
        return num2Str(player1.getPoint()) + "-" + getIdioma().All();
    }
    
    private String deuce() {
        return getIdioma().Deuce();
    }
    
    private String marcadorGanador() {
        return jugadorConVentaja() + " " + getIdioma().Wins();
    }
    
    private String marcadorVentaja() {
        return jugadorConVentaja() + " " + getIdioma().Advantage();
    }
    
    private String jugadorConVentaja() {
        return (player1.getPoint() > player2.getPoint()) ? player1.getNombre() : player2.getNombre();
    }
    
}