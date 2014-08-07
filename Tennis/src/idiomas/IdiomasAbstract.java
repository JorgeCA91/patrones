package idiomas;

import java.io.BufferedReader;
import utils.*;

public abstract class IdiomasAbstract  implements IdiomaInterface {
    private final String TXT = ".txt"; 
    public String[] estructuraIdioma(String nombreDelIdioma) {
        BufferedReader bufferIdioma;
        bufferIdioma = Archivos.cargaArchivo(nombreCompleto(nombreDelIdioma));
        String lineaLeida = Archivos.leerArchivo(bufferIdioma);
        String[] palabras = lineaLeida.split(",");
        return palabras;
    }
    
    public String nombreCompleto(String nombreDelIdioma) {
        return nombreDelIdioma + this.TXT;
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
    
}
