/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import java.util.Random;

class Controlador extends JPanel implements Runnable, KeyListener {
    private double coordenadaXBolita;
    private double coordenadaYBolita;
    private double coordenadaXJugador1;
    private double coordenadaYJugador1;
    private double coordenadaXJudador2;
    private double coordenadaYJugador2;
    private double velocidadJugadores = 6.0;
    private double velocidadBolita = 5.0;
    private int direccionJugador1 = 1;
    private int direccionJugador2 = 1;
    private int direccionXBolita = 1;
    private int direccionYBolita = 1;
    private int puntajeJugador1 = 0;
    private int puntajeJugador2 = 0;
    private int vidasJugador1 = 3;
    private int vidasJugador2 = 3;

    protected Controlador() {
        super();
        this.coordenadaXBolita = 30;
        this.coordenadaYBolita = 0;
        this.coordenadaXJugador1 = 565;
        this.coordenadaYJugador1 = 180;
        this.coordenadaXJudador2 = 10;
        this.coordenadaYJugador2 = 180;
    }

@Override
public void paint(Graphics cancha) {
        super.paint(cancha);
        Graphics2D graficoDeLaCancha = (Graphics2D)cancha;
        graficoDeLaCancha.setColor(Color.BLACK);
        graficoDeLaCancha.fill(new Ellipse2D.Double(this.coordenadaXBolita, this.coordenadaYBolita, 20, 20));
        graficoDeLaCancha.setColor(Color.BLUE);
        graficoDeLaCancha.fill(new Rectangle2D.Double(this.coordenadaXJugador1, this.coordenadaYJugador1, 15, 60));
        graficoDeLaCancha.setColor(Color.ORANGE);
        graficoDeLaCancha.fill(new Rectangle2D.Double(this.coordenadaXJudador2, this.coordenadaYJugador2, 15, 60));
        return;
    }

    @Override
    public void keyPressed(KeyEvent evento) {
        int teclaPresionada = evento.getKeyCode();

        switch (teclaPresionada) {
                case KeyEvent.VK_DOWN:
                        this.direccionJugador1 = 0;
                        break;
                case KeyEvent.VK_UP:
                        this.direccionJugador1 = 1;
                        break;
                case KeyEvent.VK_Z:
                        this.direccionJugador2 = 0;
                        break;
                case KeyEvent.VK_A:
                        this.direccionJugador2 = 1;
                        break;
        }
        super.repaint();
        return;
    }

    @Override
    public void keyReleased(KeyEvent e) {return;}

    @Override
    public void keyTyped(KeyEvent e) {return;}

    @Override
    public void run() {
        while (true) {
            if (direccionJugador1 == 0) {
                    this.coordenadaYJugador1 += this.velocidadJugadores;
                    if (this.coordenadaYJugador1 > 315) {
                            this.coordenadaYJugador1 = 315;
                    }
            }
            if (direccionJugador1 == 1) {
                    this.coordenadaYJugador1 -= this.velocidadJugadores;
                    if (this.coordenadaYJugador1 < 0) {
                            this.coordenadaYJugador1 = 0;
                    }
            }
            if (direccionJugador2 == 0) {
                    this.coordenadaYJugador2 += this.velocidadJugadores;
                    if (this.coordenadaYJugador2 > 315) {
                            this.coordenadaYJugador2 = 315;
                    }
            }
            if (direccionJugador2 == 1) {
                    this.coordenadaYJugador2 -= this.velocidadJugadores;
                    if (this.coordenadaYJugador2 < 0) {
                            this.coordenadaYJugador2 = 0;
                    }
            }
            if (direccionXBolita == 0) {
                    this.coordenadaXBolita -= this.velocidadBolita;
                    if (this.coordenadaXBolita < 0) {
                        //Jugador 2 aumenta un punto
                            this.direccionXBolita = 1;
                            this.coordenadaXBolita = 100; 
                           System.out.print("Naranja > Vidas restantes: ");
                            this.vidasJugador2 -= 1;
                            System.out.println(this.vidasJugador2);
                    }
            }
            if (direccionXBolita == 1) {
                    this.coordenadaXBolita += this.velocidadBolita;
                    if (this.coordenadaXBolita > 570) {
                        //Jugador 1 aumenta un punto
                            this.direccionXBolita = 0;
                            this.coordenadaXBolita = 360;
                            System.out.print("Azul > Vidas restantes: ");
                            this.vidasJugador1 -= 1;
                            System.out.println(this.vidasJugador1);
                    }
            }
            if (direccionYBolita == 0) {
                    this.coordenadaYBolita -= this.velocidadBolita;
                    if (this.coordenadaYBolita < 0) {
                            this.direccionYBolita = 1;
                    }
            }
            if (direccionYBolita == 1) {
                    this.coordenadaYBolita += this.velocidadBolita;
                    if (this.coordenadaYBolita > 350) {
                            this.direccionYBolita = 0;
                    }
            }
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
            } catch (Exception e) {}

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