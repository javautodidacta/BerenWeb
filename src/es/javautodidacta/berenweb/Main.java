package es.javautodidacta.berenweb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

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
