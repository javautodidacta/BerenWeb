package es.javautodidacta.berenweb;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller {
    @FXML private Button abrirURL;
    @FXML private TextField barraURL;
    @FXML private WebView webView;
    @FXML private Label estado;
    @FXML private ProgressBar barraProgreso;
    @FXML private Button atras;
    
    private PaginaWeb paginaWeb;
    private Historial historial;
    
    private WebEngine webEngine;
    
    public void initialize() {
    
        webEngine = webView.getEngine();
        historial = Historial.get();
        
        abrirURL.setOnMouseClicked((view) -> {
            paginaWeb = new PaginaWeb(barraURL.getText());
            abrirURL();
            historial.agregarHistorial(paginaWeb);
        });
        
        atras.setOnMouseClicked((view) -> {
            paginaWeb = historial.retroceder();
            abrirURL();
        });
    }
    
    private void abrirURL() {
        
        webEngine.load(paginaWeb.getUrl());
        estado.setText("Cargando...");
    }
    
}
