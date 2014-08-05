package idiomas;

/**
 *
 * @author jorge
 */
public class Ingles extends IdiomasAbstract {
   private String[] palabraIdioma;
    private String idioma;

    public Ingles(String idioma) {
        setIdioma(idioma);
        cargarIdioma();
    }
    
    public String[] getPalabraIdioma() {
        return palabraIdioma;
    }
    
    public String getPalabraIdioma(int index) {
        return palabraIdioma[index];
    }

    public void setPalabraIdioma(String[] palabraIdioma) {
        this.palabraIdioma = palabraIdioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    private void cargarIdioma() {
        setPalabraIdioma(estructuraIdioma(getIdioma()));
    }
    
    @Override
    public String Love() {
        return getPalabraIdioma(0);
    }

    @Override
    public String All() {
        return getPalabraIdioma(4);
    }

    @Override
    public String Fifteen() {
        return getPalabraIdioma(1);
    }

    @Override
    public String Thirty() {
        return getPalabraIdioma(2);
    }

    @Override
    public String Forty() {
        return getPalabraIdioma(3);
    }

    @Override
    public String Advantage() {
        return getPalabraIdioma(5);
    }

    @Override
    public String Wins() {
        return getPalabraIdioma(6);
    } 
}
