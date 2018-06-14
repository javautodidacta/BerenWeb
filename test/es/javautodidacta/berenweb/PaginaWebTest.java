/*
 * MIT License
 *
 * Copyright (c)2018. Miguel Callejón Berenguer.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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