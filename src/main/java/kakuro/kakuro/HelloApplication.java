package kakuro.kakuro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
/*
       Tablero tablero = new Tablero();
        tablero.mostrarMatriz();
*/

        // Cargar el archivo FXML y crear la escena
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Tablero8.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 820);

        // Agregar el archivo CSS a la escena
        String css = this.getClass().getResource("LetraMenu.css").toExternalForm();
        scene.getStylesheets().add(css);

        // Configurar la escena y mostrar la ventana
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}