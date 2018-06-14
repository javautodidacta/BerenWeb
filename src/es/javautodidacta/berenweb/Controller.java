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
            paginaWeb = new PaginaWeb(barraURL.getText().toLowerCase());
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
     * Abre la URL en la barra de dirección.
     */
    private void abrirURL() {
        barraProgreso.setVisible(true);
        String url = paginaWeb.getUrl();
        barraURL.setText(url);
        webEngine.load(url);
        estado.setText("Cargando " + paginaWeb.getDominio());
    }
    
}
