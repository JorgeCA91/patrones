/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package idiomas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author aokiji43
 */
public class Idiomas {
    
    //public String idioma='';
    
    public String[] estructuraIdioma(String nombre) {
        BufferedReader idioma = cargaIdioma(nombre);
        String l = leerIdioma(idioma);
        String[] palabras = l.split(",");
        return palabras;
    }
    
    public BufferedReader cargaIdioma(String nombre) {
        BufferedReader a = null;
        try {
            a = new BufferedReader(new FileReader(nombre));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return a;
    }
    
    public String leerIdioma(BufferedReader i){
        String linea = "";
        String data = "";
        try {
            linea = i.readLine().toString();
        } catch (Exception e) {
            if(linea.isEmpty()) {
                return null;
            }
        }
        if(linea!=null) {
            data = linea;
            return data;
        } else {
            return null;
        }
    }
}
