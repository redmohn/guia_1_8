package cl.polett.taller.modelo;

/**
 *
 * @author polett
 */
public class Piano extends Instrumento {
    
    private boolean deCola;

    public Piano() {
    }

    public Piano(boolean deCola) {
        this.deCola = deCola;
    }

    public Piano(boolean deCola, String codigo, String nombre, Integer stock, String tipo) {
        super(codigo, nombre, stock, tipo);
        this.deCola = deCola;
    }

    public boolean isDeCola() {
        return deCola;
    }

    public void setDeCola(boolean deCola) {
        this.deCola = deCola;
    }
    
    
    
}
