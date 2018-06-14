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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    private static Stage stage;
    public static Stage getStage() {
        return stage;
    }
    
    /**
     * Carga la interfaz fxml.
     * @param primaryStage  El escenario sobre el que se monta la interfaz (escena).
     * @throws Exception    Cualquier tipo de excepción.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Interfaz.fxml"));
        stage = primaryStage;
        stage.setTitle("BerenWeb");
        stage.setMaximized(true);
        Scene scene = new Scene(root, 700, 400);
        scene.getStylesheets().add("es/javautodidacta/berenweb/styles/styles.css");
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Método para entornos sin JavaFX.
     * @param args Una matriz de cadenas de texto ({@code String}).
     */
    public static void main(String[] args) {
        launch(args);
    }
}
