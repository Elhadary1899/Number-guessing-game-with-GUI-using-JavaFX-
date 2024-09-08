package org.example.numberguessinggame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("numberGuessingGame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 600);
        //changing the icon of the stage
        Image icon = new Image(getClass().getResourceAsStream("/numbers.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Number Guessing Game!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}