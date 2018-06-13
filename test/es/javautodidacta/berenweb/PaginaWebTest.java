package es.javautodidacta.berenweb;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * This class is a unit test for the PaginaWeb class.
 *
 * @author Miguel Callejón Berenguer
 * @version 2018.06
 */
public class PaginaWebTest {
    
    @Test
    public void testFrase() {
        PaginaWeb pw = new PaginaWeb("Palma de Mallorca");
        String pwUrl = pw.getUrl();
        String pwDominio = pw.getDominio();
        assertEquals("El dominio ha de ser Wikipedia", "Wikipedia", pwDominio);
        assertEquals("La URL ha de ser de la Wikipedia",
                     "https://es.wikipedia.org/wiki/Palma%20de%20Mallorca", pwUrl);
    }
    
    @Test
    public void testPalabra() {
        PaginaWeb pw = new PaginaWeb("Facebook");
        String pwUrl = pw.getUrl();
        String pwDominio = pw.getDominio();
        assertEquals("El dominio ha de ser Wikipedia",
                     "Wikipedia", pwDominio);
        assertEquals("La URL ha de ser de la Wikipedia",
                     "https://es.wikipedia.org/wiki/Facebook", pwUrl);
    }
    
    @Test
    public void testNumber() {
        PaginaWeb pw = new PaginaWeb("1234");
        String pwUrl = pw.getUrl();
        String pwDominio = pw.getDominio();
        assertEquals("El dominio ha de ser Wikipedia",
                     "Wikipedia", pwDominio);
        assertEquals("La URL ha de ser de la Wikipedia",
                     "https://es.wikipedia.org/wiki/1234", pwUrl);
    }
    
    @Test
    public void testUrl() {
        PaginaWeb pw = new PaginaWeb("javautodidacta.es");
        String pwUrl = pw.getUrl();
        String pwDominio = pw.getDominio();
        assertEquals("El dominio ha de ser Javautodidacta",
                     "Javautodidacta", pwDominio);
        assertEquals("La URL ha de ser https://www.javautodidacta.es",
                     "https://www.javautodidacta.es", pwUrl);
    }
}