/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public abstract class Archivos {
    
    public static BufferedReader cargaArchivo(String nombreDelArchivo) {
        BufferedReader buffer = null;
        try {
            buffer = new BufferedReader(new FileReader(nombreDelArchivo));
        } catch (FileNotFoundException exception) {
            JOptionPane.showMessageDialog(null, "No se encontro el Archivo deseado", "Error de Carga", JOptionPane.ERROR_MESSAGE);
            System.out.println(exception.getMessage());
        }
        return buffer;
    }
    
    public static String leerArchivo(BufferedReader buffer) {
        String linea = "";
        String data;
        try {
            linea = buffer.readLine();
        } catch (IOException exception) {
            if(linea.isEmpty()) {
                return null;
            }
        }
        if( linea!=null ) {
            data = linea;
            return data;
        } else {
            return null;
        }
    }
}
