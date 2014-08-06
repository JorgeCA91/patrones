/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tennis;

/**
 *
 * @author jorge
 */
public class Player {
    
    public String nombre;
    public int point = 0;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = incrementaPuntaje();
    }
    
    private int incrementaPuntaje() {
        return (getPoint() < 30) ? getPoint() + 15 : getPoint() + 10;
    }
}