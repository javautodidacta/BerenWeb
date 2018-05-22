package es.javautodidacta.berenweb;

import org.apache.commons.validator.routines.UrlValidator;

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
    
    private void setUrl(String url) {
        
        UrlValidator u = new UrlValidator();
        boolean validUrl = u.isValid("https://www." + url);
        
        if(!validUrl) {
            this.url = "https://www.google.es/?search=" + url;
        } else {
            this.url = "https://www." + url;
        }
    }
    
    private void setDominio() {
    
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
