package es.javautodidacta.berenweb;

import javafx.concurrent.Worker;
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
        
        barraProgreso.progressProperty().bind(webEngine.getLoadWorker().progressProperty());
        webEngine.getLoadWorker().stateProperty()
                 .addListener((observable, oldValue, newValue) -> {
            if( newValue == Worker.State.SUCCEEDED) {
                barraProgreso.setVisible(false);
                Main.getStage().setTitle(webEngine.getTitle());
                barraURL.setText(webEngine.getLocation());
                historial.agregarHistorial(new PaginaWeb(webEngine.getLocation()));
                estado.setText("Listo.");
            }
        });
    }
    
    private void abrirURL() {
        String url = paginaWeb.getUrl();
        barraURL.setText(url);
        barraProgreso.setVisible(true);
        webEngine.load(url);
        estado.setText("Cargando " + paginaWeb.getDominio());
    }
    
}
