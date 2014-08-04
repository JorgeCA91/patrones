package tennis;

/**
 *
 * @author jorge
 */
public class Juego {
    
    private Player player1;
    private Player player2;
    private String score;

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
    
    public void point(Player jugador) {
        
    }
    
    public String score(Player uno, Player dos) {
        return score;
    } 
}