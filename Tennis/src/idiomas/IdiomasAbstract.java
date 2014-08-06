package idiomas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public abstract class IdiomasAbstract  implements IdiomaInterface {
    
    public String[] estructuraIdioma(String nombreDelIdioma) {
        BufferedReader bufferIdioma = cargaArchivoDeIdioma(nombreDelIdioma);
        String lineaLeida = leerIdioma(bufferIdioma);
        String[] palabras = lineaLeida.split(",");
        return palabras;
    }
    
    @Override
    public String getNumero(int puntaje) {
        switch (puntaje) {
            case 15:
                return Fifteen();
            case 30:
                return Thirty();
            case 40:
                return Forty();
            default:
                return Love();
        }
    }
    
    public BufferedReader cargaArchivoDeIdioma(String nombreDelArchivo) {
        BufferedReader buffer = null;
        try {
            buffer = new BufferedReader(new FileReader(nombreDelArchivo));
        } catch (FileNotFoundException exception) {
            JOptionPane.showMessageDialog(null, "No se encontro el Archivo deseado", "Error de Carga", JOptionPane.ERROR_MESSAGE);
            System.out.println(exception.getMessage());
        }
        return buffer;
    }
    
    public String leerIdioma(BufferedReader buffer) {
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
