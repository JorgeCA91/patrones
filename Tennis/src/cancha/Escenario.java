package cancha;

/**
 *
 * @author jorge
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

class Controlador extends JPanel implements Runnable, KeyListener {
    private double coordenadaXBolita;
    private double coordenadaYBolita;
    private double coordenadaXJugador1;
    private double coordenadaYJugador1;
    private double coordenadaXJudador2;
    private double coordenadaYJugador2;
    private final double velocidadJugadores = 6.0;
    private final double velocidadBolita = 5.0;
    private final int IZQUIERDA = 0;
    private final int DERECHA = 1;
    private final int ABAJO = 0;
    private final int ARRIBA = 1;
    private int direccionJugador1 = this.ARRIBA;
    private int direccionJugador2 = this.ABAJO;
    private int direccionXBolita = this.ARRIBA;
    private int direccionYBolita = this.ARRIBA;
    private int puntajeJugador1 = this.ABAJO;
    private int puntajeJugador2 = this.ABAJO;
    private int vidasJugador1 = 3;
    private int vidasJugador2 = 3;
    
    protected Controlador() {
        super();
        reseteaPosicionBolita();
        this.coordenadaXJugador1 = 565;
        this.coordenadaYJugador1 = 180;
        this.coordenadaXJudador2 = 10;
        this.coordenadaYJugador2 = 180;
    }

    @Override
    public void paint(Graphics cancha) {
        super.paint(cancha);
        Graphics2D graficoDeLaCancha = (Graphics2D)cancha;
        Ellipse2D bolita = new Ellipse2D.Double(this.coordenadaXBolita, this.coordenadaYBolita, 20, 20);
        Rectangle2D raquetaJugador1 = new Rectangle2D.Double(this.coordenadaXJugador1, this.coordenadaYJugador1, 15, 60);
        Rectangle2D raquetaJugador2 = new Rectangle2D.Double(this.coordenadaXJudador2, this.coordenadaYJugador2, 15, 60);
        Color colorBolita = Color.BLACK;
        Color colorRaquetaJugador1 = Color.BLUE;
        Color colorRaquetaJugador2 = Color.ORANGE;
        
        graficoDeLaCancha.setColor(colorBolita);
        graficoDeLaCancha.fill(bolita);
        graficoDeLaCancha.setColor(colorRaquetaJugador1);
        graficoDeLaCancha.fill(raquetaJugador1);
        graficoDeLaCancha.setColor(Color.ORANGE);
        graficoDeLaCancha.fill(raquetaJugador2);
    }

    @Override
    public void keyPressed(KeyEvent evento) {
        int teclaPresionada = evento.getKeyCode();

        switch (teclaPresionada) {
                case KeyEvent.VK_DOWN:
                        this.direccionJugador1 = this.ABAJO;
                        break;
                case KeyEvent.VK_UP:
                        this.direccionJugador1 = this.ARRIBA;
                        break;
                case KeyEvent.VK_Z:
                        this.direccionJugador2 = this.ABAJO;
                        break;
                case KeyEvent.VK_A:
                        this.direccionJugador2 = this.ARRIBA;
                        break;
        }
        super.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
    
    public void reseteaPosicionBolita() {
        this.coordenadaXBolita = 300;
        this.coordenadaYBolita = 200;
    }
    
    public boolean direccionJugador1HaciaAbajo() {
        return direccionJugador1 == this.ABAJO ;
    }
    public boolean direccionJugador1HaciaArriba() {
        return direccionJugador1 == this.ARRIBA ;
    }
    
    public boolean direccionJugador2HaciaAbajo() {
        return direccionJugador2 == this.ABAJO;
    }
    
    public boolean direccionJugador2HaciaArriba() {
        return direccionJugador2 == this.ARRIBA;
    }
    
    public void moverJugador1HaciaAbajo() {
        this.coordenadaYJugador1 += this.velocidadJugadores;
        if (this.coordenadaYJugador1 > 315) {
            this.coordenadaYJugador1 = 315;
        }
    }
    
    public void moverJugador1HaciaArriba() {
        this.coordenadaYJugador1 -= this.velocidadJugadores;
        if (this.coordenadaYJugador1 < 0) {
            this.coordenadaYJugador1 = 0;
        }
    }
    
    public void moverJugador2HaciaAbajo() {
        this.coordenadaYJugador2 += this.velocidadJugadores;
        if (this.coordenadaYJugador2 > 315) {
            this.coordenadaYJugador2 = 315;
        }
    }
    
    public void moverJugador2HaciaArriba() {
        this.coordenadaYJugador2 -= this.velocidadJugadores;
        if (this.coordenadaYJugador2 < 0) {
            this.coordenadaYJugador2 = 0;
        }
    }
    
    public boolean direccionBolitaEnXHaciaIzquierda() {
        return direccionXBolita == this.IZQUIERDA;
    }
    
    public boolean direccionBolitaEnXHaciaDerecha() {
        return direccionXBolita == this.DERECHA;
    }
    
    public boolean direccionBolitaEnYHaciaAbajo() {
        return direccionYBolita == this.ABAJO;
    }
    
    public boolean direccionBolitaEnYHaciaArriba() {
        return direccionYBolita == this.ARRIBA;
    }
    
    @Override
    public void run() {
        while (true) {
            if (direccionJugador1HaciaAbajo()) { moverJugador1HaciaAbajo(); }
            if (direccionJugador1HaciaArriba()) { moverJugador1HaciaArriba(); }
            if (direccionJugador2HaciaAbajo()) { moverJugador2HaciaAbajo(); }
            if (direccionJugador2HaciaArriba()) { moverJugador2HaciaArriba(); }
            if (direccionBolitaEnXHaciaIzquierda()) {
                    this.coordenadaXBolita -= this.velocidadBolita;
                    if (this.coordenadaXBolita < 0) {
                        //Jugador 2 aumenta un punto
                            this.direccionXBolita = 1;
                            this.coordenadaXBolita = 100; 
                           System.out.print("Naranja > Vidas restantes: ");
                            this.vidasJugador2 -= 1;
                            System.out.println(this.vidasJugador2);
                            reseteaPosicionBolita();
                    }
            }
            if (direccionBolitaEnXHaciaDerecha()) {
                    this.coordenadaXBolita += this.velocidadBolita;
                    if (this.coordenadaXBolita > 570) {
                        //Jugador 1 aumenta un punto
                            this.direccionXBolita = 0;
                            this.coordenadaXBolita = 360;
                            System.out.print("Azul > Vidas restantes: ");
                            this.vidasJugador1 -= 1;
                            System.out.println(this.vidasJugador1);
                            reseteaPosicionBolita();
                    }
            }
            if (direccionBolitaEnYHaciaAbajo()) {
                    this.coordenadaYBolita -= this.velocidadBolita;
                    if (this.coordenadaYBolita < 0) {
                            this.direccionYBolita = 1;
                    }
            }
            if (direccionBolitaEnYHaciaArriba()) {
                    this.coordenadaYBolita += this.velocidadBolita;
                    if (this.coordenadaYBolita > 350) {
                            this.direccionYBolita = 0;
                    }
            }
            //Mostraremos el score
            if(this.vidasJugador1 < 0) {
                    System.out.println("Ganador del juego >> Naranja");
                    System.exit(1);
            }
            if(this.vidasJugador2 < 0) {
                    System.out.println("Ganador del juego >> Azul");
                    System.exit(1);
            }
            try {
                    Thread.sleep((int)Math.round(30));
            } catch (InterruptedException exception) {
                JOptionPane.showMessageDialog(null, "Error en la Ejecucion del Grafico", "Error de interrupcion", JOptionPane.ERROR_MESSAGE);
            }

            double valorLimite1 = this.coordenadaYJugador1-15;
            while (valorLimite1 <= this.coordenadaYJugador1+60) {
                if (this.coordenadaXJugador1 == this.coordenadaXBolita+20 && valorLimite1 == this.coordenadaYBolita) {
                    System.out.print("Azul > Puntos: ");
                    this.puntajeJugador1 += 1;
                    System.out.println(this.puntajeJugador1);
                    if (direccionJugador1 == 0) {
                        this.direccionXBolita = 0;
                        this.direccionYBolita = 1;
                    }
                    if (direccionJugador1 == 1) {
                        this.direccionXBolita = 0;
                        this.direccionYBolita = 0;
                    }
                    reseteaPosicionBolita();
                }
                valorLimite1 += 1.0;
            }
            double valorLimite2 = this.coordenadaYJugador2-15;
            while (valorLimite2 <= this.coordenadaYJugador2+60) {
                if (this.coordenadaXJudador2+15 == this.coordenadaXBolita && valorLimite2 == this.coordenadaYBolita) {
                    System.out.print("Naranja > Puntos: ");
                    this.puntajeJugador2 += 1;
                    System.out.println(this.puntajeJugador2);
                    if (direccionJugador2 == 0) {
                        this.direccionXBolita = 1;
                        this.direccionYBolita = 1;
                    }
                    if (direccionJugador2 == 1) {
                        this.direccionXBolita = 1;
                        this.direccionYBolita = 0;
                    }
                    reseteaPosicionBolita();
                }
                valorLimite2 += 1.0;
            }
            super.repaint();
        }
    }
}

public class Escenario extends JFrame {
    public static void main(String[] args) {
        JFrame aux = new JFrame();
        aux.setSize(600, 400);
        aux.setLocation(200, 100);
        aux.setTitle("Ping-Pong");
        aux.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Controlador c = new Controlador();
        aux.add(c);
        aux.addKeyListener(c);
        c.setBackground(Color.WHITE);
        Thread t = new Thread(c);
        t.start();
        aux.setVisible(true);
        aux.setResizable(false);
    }
}