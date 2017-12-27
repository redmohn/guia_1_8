package cl.polett.taller.modelo;

/**
 *
 * @author polett
 */
public class Instrumento {
    
    private String codigo;
    private String nombre;
    private Integer stock;
    private String tipo;

    public Instrumento() {
    }

    public Instrumento(String codigo, String nombre, Integer stock, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
