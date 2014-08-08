package vistas;

/**
 *
 * @author jorge
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import tennis.Juego;
import tennis.JuegoObserver;
import tennis.Player;

public class Cancha extends JPanel implements Runnable, KeyListener, JuegoObserver {
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
    private Juego game;
    private boolean jugar;
    
    public Cancha(Juego game) {
        super();
        //setJugar(true);
        reseteaPosicionBolita();
        this.coordenadaXJugador1 = 565;
        this.coordenadaYJugador1 = 180;
        this.coordenadaXJudador2 = 10;
        this.coordenadaYJugador2 = 180;
        this.game = game;
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
            case KeyEvent.VK_LEFT:
                this.direccionJugador1 = this.IZQUIERDA;
                break;
            case KeyEvent.VK_RIGHT:
                this.direccionJugador1 = this.DERECHA;
                break;
            case KeyEvent.VK_S:
                this.direccionJugador2 = this.ABAJO;
                break;
            case KeyEvent.VK_X:
                this.direccionJugador2 = this.ARRIBA;
                break;
            case KeyEvent.VK_Z:
                this.direccionJugador2 = this.IZQUIERDA;
                break;
            case KeyEvent.VK_C:
                this.direccionJugador2 = this.DERECHA;
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
    
    public boolean direccionJugador1HaciaIzquierda() {
        return direccionJugador1 == this.IZQUIERDA ;
    }
    public boolean direccionJugador1HaciaDerecha() {
        return direccionJugador1 == this.DERECHA;
    }
    
    public boolean direccionJugador2HaciaAbajo() {
        return direccionJugador2 == this.ABAJO;
    }
    
    public boolean direccionJugador2HaciaArriba() {
        return direccionJugador2 == this.ARRIBA;
    }
    
    public boolean direccionJugador2HaciaIzquierda() {
        return direccionJugador2 == this.IZQUIERDA;
    }
    
    public boolean direccionJugador2HaciaDerecha() {
        return direccionJugador2 == this.DERECHA;
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
    
    public void moverJugador1HaciaDerecha() {
        this.coordenadaXJugador1 += this.velocidadJugadores;
        if (this.coordenadaXJugador1 > 250) {
            this.coordenadaXJugador1 = 250;
        }
    }
    
    public void moverJugador1HaciaIzquierda() {
        this.coordenadaXJugador1 -= this.velocidadJugadores;
        if (this.coordenadaXJugador1 < 5) {
            this.coordenadaXJugador1 = 5;
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
    
    public void moverJugador2HaciaDerecha() {
        this.coordenadaXJudador2 += this.velocidadJugadores;
        if (this.coordenadaXJudador2 > 550) {
            this.coordenadaXJudador2 = 550;
        }
    }
    
    public void moverJugador2HaciaIzquierda() {
        this.coordenadaXJudador2 -= this.velocidadJugadores;
        if (this.coordenadaXJudador2 < 280) {
            this.coordenadaXJudador2 = 280;
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
    
    public void setJugar(boolean estado) {
        this.jugar = estado;
    }
    
    public boolean getJugar() {
        return this.jugar;
    }
    
    public boolean anotaJugador2() {
        return this.coordenadaXBolita < 0;
    }
    
    public boolean anotaJugador1() {
        return this.coordenadaXBolita > 570;
    }
    
    @Override
    public void run() {
        
        while (getJugar()) {
            if (direccionJugador1HaciaAbajo()) { moverJugador1HaciaAbajo(); }
            if (direccionJugador1HaciaArriba()) { moverJugador1HaciaArriba(); }
            if (direccionJugador1HaciaDerecha()) { moverJugador1HaciaDerecha(); }
            if (direccionJugador1HaciaIzquierda()) { moverJugador1HaciaIzquierda(); }
            if (direccionJugador2HaciaAbajo()) { moverJugador2HaciaAbajo(); }
            if (direccionJugador2HaciaArriba()) { moverJugador2HaciaArriba(); }
            if (direccionJugador2HaciaDerecha()) { moverJugador2HaciaDerecha(); }
            if (direccionJugador2HaciaIzquierda()) { moverJugador2HaciaIzquierda(); }
            if (direccionBolitaEnXHaciaIzquierda()) {
                    this.coordenadaXBolita -= this.velocidadBolita;
                    if (anotaJugador2()) {
                            notificaPuntoAnotado(2);
                            this.direccionXBolita = 1;
                            this.coordenadaXBolita = 100; 
                            reseteaPosicionBolita();
                    }
            }
            if (direccionBolitaEnXHaciaDerecha()) {
                    this.coordenadaXBolita += this.velocidadBolita;
                    if (anotaJugador1()) {
                            notificaPuntoAnotado(1);
                            this.direccionXBolita = 0;
                            this.coordenadaXBolita = 360;
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
            
            try {
                Thread.sleep((int)Math.round(30));
            } catch (InterruptedException exception) {
                JOptionPane.showMessageDialog(null, "Error en la Ejecucion del Grafico", "Error de interrupcion", JOptionPane.ERROR_MESSAGE);
            }
            
            double valorLimite1 = this.coordenadaYJugador1-15;
            while (valorLimite1 <= this.coordenadaYJugador1+60) {
                if (this.coordenadaXJugador1 == this.coordenadaXBolita+20 && valorLimite1 == this.coordenadaYBolita) {
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

    @Override
    public void notificaPuntoAnotado(int numeroJugador) {
        switch (numeroJugador) {
            case 1:
                this.game.getPlayer1().setPoint();
                break;
            case 2:
                this.game.getPlayer2().setPoint();
                break;
        }
        JuegoObserver[] observers = game.observers;
        System.out.println(game.marcador());
        for (JuegoObserver observer : observers) {
            observer.muestraScore(this.game);
        }
    }

    @Override
    public void notificaGanador(String ganador) {
        setJugar(false);
        JOptionPane.showMessageDialog(null, "Gano "+ganador, "Ganador", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void muestraScore(Juego game) {}
}