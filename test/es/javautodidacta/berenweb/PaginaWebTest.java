package es.javautodidacta.berenweb;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class is a unit test for the PaginaWeb class.
 *
 * @author Miguel Callejón Berenguer
 * @version 2018.06
 */
public class PaginaWebTest {
    @Test
    public void testUrl() {
        PaginaWeb pw = new PaginaWeb("google");
        String url = pw.getUrl();
        assertEquals("https://es.wikipedia.org/wiki/google", url);
    }
}