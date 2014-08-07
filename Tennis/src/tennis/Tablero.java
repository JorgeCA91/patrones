/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tennis;

import idiomas.Idioma;
import idiomas.IdiomaInterface;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    public JLabel judadores;
    public LabelMarcador labelMarcador = new LabelMarcador();
    public TablaMarcador tablaMarcador = new TablaMarcador();
    public JComboBox idiomas;
    private boolean pausa = false;
    public JPanel panelPrincipal;
    public JPanel panelTitulo;
    Thread hiloEjecucionCancha;
    Idioma idiomaFinal;
    public JFrame cancha;
    public Cancha panelCancha;
    Player player1;
    Player player2;
    Juego game;
    
    public Tablero() {
        initComponents();
        inicializaPaneles();
        
    }
    
    public void inicializaPaneles() {
        game = new Juego();
        this.setSize(300, 415);
        panelTitulo = new JPanel(null, true);
        panelTitulo.setBounds(0, 0, 300, 70);
        panelTitulo.setBackground(Color.GRAY);
        judadores= new JLabel("Contrincantes");
        judadores.setBounds(10, 0, 250, 25);
        idiomas = new JComboBox(new String[] {"Español","Ingles","Frances"});
        idiomas.setBounds(0, 30, 100, 25);
        idiomas.setEnabled(false);
        idiomas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
                System.out.println("Idioma: " + idiomas.getSelectedItem().toString());
                idiomaFinal = new Idioma((String)idiomas.getSelectedItem());
                System.out.println(idiomaFinal.Advantage());
                setIdioma(idiomaFinal); 
           }
        });
        panelTitulo.add(judadores);
        panelTitulo.add(idiomas);
        panelPrincipal = new JPanel(null, true);
        panelPrincipal.setBounds(0, 0, 300, 500);
        panelPrincipal.setBackground(Color.CYAN);
        labelMarcador.setBounds(0, 75, 300, 50);
        tablaMarcador.setBounds(0, 134, 300, 350);
        
        
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
    
    public void setIdioma(IdiomaInterface idioma) {
        game.setIdioma(idioma);
        System.out.println(game.marcador());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Inicio");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Nuevo Juego");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Abrir Cancha");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Opciones de Juego");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Iniciar Juego");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Pausar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Terminar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

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
        creaJugadores();
        judadores.setText(player1.getNombre() + " <--contra--> " + player2.getNombre());
        game.setJugadores(player1, player2);
        idiomas.setEnabled(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        inicializaFrameCancha();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        iniciar();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        terminar();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        pausar();
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    
    public void creaJugadores() {
        player1 =  new Player();
        player1.setNombre(JOptionPane.showInputDialog("Nombre del Jugador1", "Nombre"));
        player2 =  new Player();
        player2.setNombre(JOptionPane.showInputDialog("Nombre del Jugador2", "Nombre"));
    }
    
    public void inicializaFrameCancha() {
        cancha = new JFrame();
        panelCancha = new Cancha();
        panelCancha.setBounds(305, 75, 600, 400);
        panelCancha.setBackground(Color.WHITE);
        hiloEjecucionCancha = new Thread(panelCancha);
        cancha.add(panelCancha);
        cancha.addKeyListener(panelCancha);
        cancha.setBounds(300, 0, 600, 415);
        cancha.setVisible(true);
        this.requestFocus();
    }
    
    public void iniciar() {
        panelCancha.setJugar(true);
        cancha.requestFocus();
        hiloEjecucionCancha.start();
    }
    
    public void terminar() {
        hiloEjecucionCancha.stop();
    }
    
    public void pausar() {
        if (pausa) {
            hiloEjecucionCancha.resume();
            pausa = false;
        } else {
            hiloEjecucionCancha.suspend();
            pausa = true;
        }
    }
    
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
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    // End of variables declaration//GEN-END:variables
}
