package es.javautodidacta.berenweb;

import org.apache.commons.validator.routines.UrlValidator;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class
 *
 * @author Miguel Callejón Berenguer
 * @version 2018.05
 */
public class PaginaWeb {
    private String url;
    private String dominio;
    
    PaginaWeb(String url) {
        setUrl(url);
        setDominio();
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
     * @param url
     */
    private void setUrl(String url) {
        url = url.replace(" ", "%20");
        String httpUrl = url.startsWith("http") ? url : "https://www." + url;
        boolean URLvalida = comprobarURL(httpUrl);
    
        if (URLvalida) {
            this.url = httpUrl;
        } else {
            this.url = "https://es.wikipedia.org/wiki/" + url;
        }
    }
    
    /**
     * Comprueba si la cadena de texto introducida en
     * la barra de direcciones es una url o no.
     * @param httpUrl url
     * @return true si httpUrl es una URL válida.
     */
    private boolean comprobarURL(String httpUrl) {
        UrlValidator u = new UrlValidator();
        return u.isValid(httpUrl);
    }
    
    private void setDominio() {
        try {
            URI uri = new URI(url);
            dominio = uri.getHost();
        } catch (URISyntaxException e) {
            e.printStackTrace();
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
