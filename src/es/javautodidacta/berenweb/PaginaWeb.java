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

import org.apache.commons.validator.routines.UrlValidator;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Esta clase crea una "página web" que contiene dos variables: una url y el dominio.
 *
 * @author Miguel Callejón Berenguer
 * @version 2018.05
 */
public class PaginaWeb {
    private String url;
    private String dominio;
    
    PaginaWeb(String url) {
        setUrl(url);
    }
    
    public String getUrl() {
        return url;
    }
    
    public String getDominio() {
        return dominio;
    }
    
    /**
     * Define el valor the this.url dependiendo de si la cadena de texto introducida en
     * la barra de direcciones es una url o no.
     * @param url   El texto introducido en la barra de direcciones.
     */
    private void setUrl(String url) {
        url = url.replace(" ", "%20");
        String httpUrl = url.startsWith("http") ? url : "https://www." + url;
        boolean URLvalida = comprobarURL(httpUrl);
    
        if (URLvalida) {
            this.url = httpUrl;
            this.dominio = setDominio();
        } else {
            this.url = "https://es.wikipedia.org/wiki/" + url;
            this.dominio = "Wikipedia";
        }
    }
    
    /**
     * Comprueba si la cadena de texto introducida en
     * la barra de direcciones es una url o no.
     * @param httpUrl url
     * @return true si httpUrl es una URL válida.
     */
    private boolean comprobarURL(String httpUrl) {
        UrlValidator u = UrlValidator.getInstance();
        return u.isValid(httpUrl);
    }
    
    private String setDominio() {
        try {
            URI uri = new URI(url);
            String dominio = uri.getHost();
            if(dominio.startsWith("www.")) {
                dominio = dominio.substring(4);
            }
            if(dominio.contains(".")) {
                dominio = dominio.substring(0, dominio.indexOf("."));
            }
            dominio = dominio.substring(0, 1)
                             .toUpperCase() +
                      dominio.substring(1);
            return dominio;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return "";
        }
    }
    
    @Override public String toString() {
        return dominio + ": " + url;
    }
    
    @Override public int hashCode() {
        return url.hashCode();
    }
    
    @Override public boolean equals(Object obj) {
        if(!(obj instanceof PaginaWeb)) return false;
        PaginaWeb web = (PaginaWeb) obj;
        return web.hashCode() == this.hashCode();
    }
}
