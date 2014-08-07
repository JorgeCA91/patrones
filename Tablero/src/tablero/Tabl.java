/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tablero;
import idiomas.Idiomas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Hashtable;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author aokiji43
 */
public class Tabl extends javax.swing.JFrame {
    
    private Hashtable points = new Hashtable();
    private boolean ganador = false;
    private TablaNormal tablaNormal;
    private TablaInvertida tablaInvertida;
    Idiomas idiomas = new Idiomas();
    String[] palabras = null;
    int row = 0;
    int column = 0;
    public Tabl() {
        initComponents();
        setLocation(10, 10);
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
        table.setLocation(300, 30);
        //table.setVisible(true);
        
        //this.add(table);
        tablaNormal = new TablaNormal(this);
        tablaNormal.setVisible(true);
        tablaInvertida = new TablaInvertida(this);
        tablaInvertida.setVisible(true);;
        
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
        palabras = idiomas.estructuraIdioma("Ingles.txt");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jugador 1");

        jLabel2.setText("jugador2");

        jLabel5.setText("score");

        jButton1.setText("Jugador1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Jugador2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("cero-iguales");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Ingles");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Español");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Frances");

        jButton3.setText("Nuevo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton1)
                        .addGap(47, 47, 47)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel6))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int contador = 0;
    int contador2 = 0;
    public String conteo (){
    palabras = idiomas.estructuraIdioma(tablaNormal.getIdioma()+".txt");
    System.out.println();
    
    String s = "";
    String p1N="jugador 1";
    String p2N="jugador 2";
    if (contador < 4 && contador2 < 4 && !(contador + contador2 == 6)) {
        String[] p = new String[]{palabras[0], palabras[1], palabras[2], palabras[3]}; 
        s = p[contador];
        return (contador == contador2) ? s + " - "+palabras[4] : s + " - " + p[contador2];
    } else {
        if (contador == contador2)
            return ""+palabras[4];
            s = contador > contador2 ? p1N : p2N;
        //Lo nuevo
        if ((contador-contador2)*(contador-contador2) == 1) {
            return palabras[5]+ " " + s;
        } else {
            ganador = true;
            return palabras[6] + " " + s;
            }
        }
    }

    public String conteo2 (){
        palabras = idiomas.estructuraIdioma(tablaInvertida.getIdioma()+".txt");
        
    /*if(jRadioButton1.isSelected()) {
        String i = jRadioButton1.getText();
        palabras = idiomas.estructuraIdioma(i+".txt");   
    }
    if(jRadioButton2.isSelected()) {
        String i = jRadioButton2.getText();
        palabras = idiomas.estructuraIdioma(i+".txt");   
    }
    if(jRadioButton3.isSelected()) {
        String i = jRadioButton3.getText();
        palabras = idiomas.estructuraIdioma(i+".txt");   
    }*/
    System.out.println();
    
    String s = "";
    String p1N="jugador 1";
    String p2N="jugador 2";
if (contador < 4 && contador2 < 4 && !(contador + contador2 == 6)) {
            String[] p = new String[]{palabras[0], palabras[1], palabras[2], palabras[3]}; 
            s = p[contador];
            return (contador == contador2) ? s + " - "+palabras[4] : s + " - " + p[contador2];
        } else {
            if (contador == contador2)
                return ""+palabras[4];
            s = contador > contador2 ? p1N : p2N;
            //Lo nuevo
            if ((contador-contador2)*(contador-contador2) == 1) {
                return palabras[5]+ " " + s;
            } else {
                ganador = true;
                return palabras[6] + " " + s;
            }
        }
            //return ((contador-contador2)*(contador-contador2) == 1) ?  : "gana  " + s;
    }

    public int getContador1() {
        return this.contador;
    }
    public int getContador2() {
        return this.contador2;
    }
    
    public void setContador1(int contador1) {
        this.contador = contador1;
    }
    public void setContador2(int contador2) {
        this.contador2 = contador2;
    }

    public void limpiarTableroInvertido() {
        tablaInvertida.limpiar();
    }
    public void limpiarTableroNormal() {
        tablaNormal.limpiar();
    }
    
//////////////////////////////////////////////////////////77
 /*   public int dos (int contador2){
        return contador2;
        
}
*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    contador+=1;
    
    // Append a row 
    model.addRow(new Object[]{contador, contador2, conteo()});
    tablaNormal.agregaFila(contador, contador2, conteo());
    tablaInvertida.agregaFila(contador, contador2, conteo2());
    jLabel6.setText(conteo());
        if(ganador) {
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
        }
    row += 1;
    column += 1;
    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        contador2+=1;
        model.addRow(new Object[]{contador, contador2, conteo()});
        tablaNormal.agregaFila(contador, contador2, conteo());
        tablaInvertida.agregaFila(contador, contador2, conteo2());
        jLabel6.setText(conteo());  
        // TODO add your handling code here:
        if(ganador) {
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
        }
       row += 1;
       column += 1;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        contador = 0;
        contador2 = 0;
        ganador=false;
        jLabel6.setText(palabras[0] + " - " + palabras[4]);
    }
    
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tabl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    // End of variables declaration//GEN-END:variables
    JTable table; 
    DefaultTableModel model;
    private String Tab() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
