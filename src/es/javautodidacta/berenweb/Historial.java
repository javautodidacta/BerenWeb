package es.javautodidacta.berenweb;

import javax.naming.Context;
import java.util.ArrayList;
import java.util.List;

/**
 * This class
 *
 * @author Miguel Callejón Berenguer
 * @version 2018.05
 */
class Historial {
    private List<PaginaWeb> historial;
    
    private static final Historial instance = new Historial();
    
    private Historial() {
        historial = new ArrayList<>();
    }
    
    public static Historial get() {
        return instance;
    }
    
    public void agregarHistorial(PaginaWeb web) {
        historial.add(0,web);
    }
    
    public PaginaWeb retroceder() {
        historial.remove(0);
        return historial.get(0);
    }
}
