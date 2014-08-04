package idiomas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Idiomas {
    
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
