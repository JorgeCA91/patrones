/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tennis;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vistas.*;

/**
 *
 * @author jorge
 */
public class Tablero extends javax.swing.JFrame {
    
    public JLabel judadores= new JLabel();
    public LabelMarcador labelMarcador = new LabelMarcador();
    public TablaMarcador tablaMarcador = new TablaMarcador();
    public JComboBox idiomas;
    
    public JPanel panelPrincipal;
    public JPanel panelTitulo;
    Thread hiloEjecucionCancha;
    public JFrame cancha = new JFrame();
    public Cancha panelCancha = new Cancha();
    Player player1;
    Player player2;
    Juego game;
    
    public void inicializaPaneles() {
        this.setSize(300, 550);
        
        panelTitulo = new JPanel();
        panelTitulo.setBounds(0, 0, 300, 70);
        panelTitulo.setBackground(Color.GRAY);
        
        panelTitulo.add(judadores);
        
        panelPrincipal = new JPanel(null, true);
        panelPrincipal.setBounds(0, 0, 300, 500);
        panelPrincipal.setBackground(Color.CYAN);
        
        labelMarcador.setBounds(0, 75, 300, 50);
        
        tablaMarcador.setBounds(0, 134, 300, 350);
        
        panelCancha.setBounds(305, 75, 600, 400);
        panelCancha.setBackground(Color.WHITE);
        hiloEjecucionCancha = new Thread(panelCancha);
        
        cancha.add(panelCancha);
        cancha.addKeyListener(panelCancha);
        cancha.setBounds(300, 0, 600, 400);
        cancha.setAlwaysOnTop(true);
                
        panelPrincipal.add(panelTitulo);
        panelPrincipal.add(labelMarcador);
        panelPrincipal.add(tablaMarcador);
        
        tablaMarcador.setModel(
            new String [][] {
                {"Title 1", "Title 2"},
                {"Title 1", "Title 2"}
            }, new String [] {
                "Jugador 1", "Jugador 2"
            });
        this.add(panelTitulo);
        this.add(labelMarcador);
        this.add(tablaMarcador);
    }
            
    public Tablero() {
        initComponents();
        inicializaPaneles();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        jMenuItem1.setText("Nuevo Juego");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Abrir Cancha");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Iniciar Juego");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        player1 =  new Player();
        player1.setNombre(JOptionPane.showInputDialog("Nombre del Jugador1", "Nombre"));
        player2 =  new Player();
        player2.setNombre(JOptionPane.showInputDialog("Nombre del Jugador2", "Nombre"));
        judadores.setText(player1.getNombre() + " <--contra--> " + player2.getNombre());
        game = new Juego(player1, player2);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        cancha.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        panelCancha.setJugar(true);
        cancha.requestFocus();
        hiloEjecucionCancha.start();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Dark Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration//GEN-END:variables
}
