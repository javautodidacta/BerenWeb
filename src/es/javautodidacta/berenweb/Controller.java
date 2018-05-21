package es.javautodidacta.berenweb;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Controller {
    @FXML private Button abrirURL;
    @FXML private TextField barraURL;
    @FXML private WebView webView;
    @FXML private Label estado;
    @FXML private ProgressBar barraProgreso;
    
    private String url;
    private WebEngine webEngine;
    
    public void initialize() {
        
        abrirURL.setText("Abrir URL");
        
        abrirURL.setOnMouseClicked((view) -> {
            url = barraURL.getText();
            addHttp();
            webEngine.load(url);
        });
        
        webEngine = webView.getEngine();
    }
    
    private void addHttp() {
        url = "http://www." + url;
    }
    
}
