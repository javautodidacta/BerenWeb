package es.javautodidacta.berenweb;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

public class Controller {
    @FXML private JFXButton abrirURL;
    @FXML private TextField barraURL;
    @FXML private WebView webView;
    @FXML private Label estado;
    @FXML private JFXProgressBar barraProgreso;
    @FXML private JFXButton atras;
    @FXML private JFXButton alante;
    
    private PaginaWeb paginaWeb;
    
    private WebHistory historial;
    private WebEngine webEngine;
    
    public void initialize() {
    
        webEngine = webView.getEngine();
        historial = webEngine.getHistory();
        
        abrirURL.setOnMouseClicked((view) -> {
            paginaWeb = new PaginaWeb(barraURL.getText());
            abrirURL();
        });
        
        atras.setOnMouseClicked((view) -> moveHistorial(true));
        
        alante.setOnMouseClicked((v) -> moveHistorial(false));
        
        barraProgreso.progressProperty().bind(webEngine.getLoadWorker().progressProperty());
        
        webEngine.getLoadWorker().stateProperty()
                 .addListener((observable, oldValue, newValue) -> {
            if(newValue == Worker.State.SUCCEEDED) {
                barraProgreso.setVisible(false);
                Main.getStage().setTitle(webEngine.getTitle());
                barraURL.setText(webEngine.getLocation());
                estado.setText("Listo.");
            }
        });
    }
    
    /**
     * Se desplaza por el historial y lo muestra en el navegador.
     * @param isBack    true si nos desplazamos hacia atrás en el historial.
     */
    private void moveHistorial(boolean isBack) {
        int offset = isBack ? -1 : 1;
        int historialSize = historial.getEntries().size();
        int effectiveIndex = historial.getCurrentIndex() + offset;
        
        if(effectiveIndex >= 0
                && effectiveIndex < historialSize) {
            historial.go(offset);
        }
    }
    
    /**
     * Abrel la URL en la barra de dirección.
     */
    private void abrirURL() {
        barraProgreso.setVisible(true);
        String url = paginaWeb.getUrl();
        barraURL.setText(url);
        webEngine.load(url);
        estado.setText("Cargando " + paginaWeb.getDominio());
    }
    
}
