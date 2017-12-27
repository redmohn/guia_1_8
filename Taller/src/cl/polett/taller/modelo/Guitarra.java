package cl.polett.taller.modelo;

/**
 *
 * @author polett
 */
public class Guitarra extends Instrumento{
    
    private String clase;

    public Guitarra() {
    }

    public Guitarra(String clase) {
        this.clase = clase;
    }

    public Guitarra(String clase, String codigo, String nombre, Integer stock, String tipo) {
        super(codigo, nombre, stock, tipo);
        this.clase = clase;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
        
}
