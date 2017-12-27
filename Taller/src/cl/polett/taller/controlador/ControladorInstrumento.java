package cl.polett.taller.controlador;

import Database.BD;
import cl.polett.taller.modelo.Guitarra;
import cl.polett.taller.modelo.Instrumento;
import cl.polett.taller.modelo.Piano;
import java.util.List;

/**
 *
 * @author polett
 */
public class ControladorInstrumento {

    public boolean agregarGuitarra(String clase, String codigo, String nombre, Integer stock, String tipo) {
        Guitarra guitarra = new Guitarra();

        guitarra.setClase(clase);
        guitarra.setCodigo(codigo);
        guitarra.setNombre(nombre);
        guitarra.setStock(stock);
        guitarra.setTipo(tipo);

        BD bd = new BD();
        boolean ok = bd.agregarGuitarra(guitarra);
        return ok;
    }

    public boolean agregarPiano(boolean deCola, String codigo, String nombre, Integer stock, String tipo) {
        Piano piano = new Piano();

        piano.setDeCola(deCola);
        piano.setCodigo(codigo);
        piano.setNombre(nombre);
        piano.setStock(stock);
        piano.setTipo(tipo);

        BD bd = new BD();
        boolean ok = bd.agregarPiano(piano);
        return ok;
    }

    public Instrumento conocerTipo(String codigo) {
        BD bd = new BD();
        Instrumento instrumento = bd.conocerInstrumento(codigo);
        return instrumento;
    }
    
    public Guitarra buscarGuitarra(String codigo){
        BD bd = new BD();
        Guitarra guitarra = bd.encontrarGuitarra(codigo);
        return guitarra;
    }

    /*
        public Instrumento buscar(Integer codigo){
        BD bd = new BD();
        Instrumento instrumento = bd.encontrar(codigo);
        return instrumento;
    }
    
    
      public List<Instrumento> buscarTodos(){
        BD bd = new BD();        
        List<Instrumento> listaInstrumentos = bd.encontrarTodos();
        return listaInstrumentos;
    } 
    
    public boolean eliminar(Integer codigo){
        BD bd = new BD();
        Instrumento instrumento = bd.encontrar(codigo);
        boolean ok = bd.eliminar(instrumento);
        return ok;
    }*/
}
