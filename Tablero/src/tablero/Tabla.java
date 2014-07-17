/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tablero;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorge
 */
public class Tabla {
    JTable table; 
    DefaultTableModel model;
    
    public Tabla() {
        model = new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Ptns Jugador 1", "Ptns Jugador 2", "Score"
            }
        ); 
        table = new JTable();
        table.setModel(model);
        table.setSize(300, 200);
        table.setLocation(10, 10);
        table.setVisible(true);
    }
    
    public JTable getTabla() {
        return this.table;
    }
    
    public JTable agregaFilaNormal(int ptn1, int ptn2, String score) {
        this.model.addRow(new Object[]{ptn1, ptn2, score});
        return this.table;
    }
    
    public JTable agregaFilaInversa(int ptn1, int ptn2, String score) {
        this.model.insertRow(0, new Object[]{ptn1, ptn2, score});
        return this.table;
    }
    
    public JTable generaTabla(int ptn1, int ptn2, String score, boolean sentido) {
        return sentido? agregaFilaNormal(ptn1, ptn2, score): agregaFilaInversa(ptn1, ptn2, score);
    }
}
