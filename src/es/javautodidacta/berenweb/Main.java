package es.javautodidacta.berenweb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    /**
     * Carga la interfaz fxml.
     * @param primaryStage  El escenario sobre el que se monta la interfaz (escena).
     * @throws Exception    Cualquier tipo de excepción.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Interfaz.fxml"));
        primaryStage.setTitle("BerenWeb");
        primaryStage.setScene(new Scene(root, 640, 400));
        primaryStage.show();
    }
    
    /**
     * Método para entornos sin JavaFX.
     * @param args Una matriz de cadenas de texto ({@code String}).
     */
    public static void main(String[] args) {
        launch(args);
    }
}
