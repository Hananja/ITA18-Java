package de.szut.ita18.char_stat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Gui extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(
                getClass().getClassLoader().getResource("char_stat.fxml"),
                "FXML resource not found"));
        primaryStage.setTitle("TextStat");
        primaryStage.setScene(new Scene(root, 800, 600 ));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
