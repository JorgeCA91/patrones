package utils;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tennis.Juego;
import tennis.JuegoObserver;
import tennis.Player;

/**
 *
 * @author jorge
 */
public class ModelTablaPuntaje extends AbstractTableModel implements JuegoObserver {
    List valores = new ArrayList();
    String[] titles = null;
    @Override
    public void notificaPuntoAnotado(int numeroJugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void muestraScore(Juego game) {
        agregar(game.getPlayer1(), game.getPlayer2(), game.marcador());
    }

    @Override
    public void notificaGanador(String nombreGanador) {
        
    }

    public ModelTablaPuntaje() {
    }
    
    public void setTitles(Player player1, Player player2) {
        String[] titles = new String[] {player1.getNombre(), player2.getNombre(), "Marcador"};
        this.titles = titles;
    }
    
    public String[] getTitles() {
        return this.titles;
    }
    
    public void borrar() {
        valores.clear();
        fireTableDataChanged();
    }
    
    public void agregar(Player player1, Player player2, String score) {
        valores.add(new PojoPuntaje(player1, player2, score));
        fireTableDataChanged();
    }
    
    public void limpiarAPartirDe(int fila){
        if (fila < valores.size()) {
            for (int i = fila - 1; i < valores.size(); i++) {
                valores.remove(fila);
            }
            fireTableDataChanged();
        }
    }
    
    @Override
    public int getRowCount() {
        return valores.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override    
    public String getColumnName(int i) {
        switch(i) {
            case 0:
                return getTitles()[0];
            case 1:
                return getTitles()[1];
            case 2:
                return getTitles()[2];
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int i, int j) {
        PojoPuntaje fila = (PojoPuntaje) valores.get(i);
        switch(j) {
            case 0:
                return fila.getPuntoJugador1();
            case 1:
                return fila.getPuntoJugador2();
            case 2:
                return fila.getScore();
            default:
                return null;
        }
    }
}
