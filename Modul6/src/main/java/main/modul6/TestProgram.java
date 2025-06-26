package main.modul6;

import javafx.application.Application;
import javafx.stage.Stage;

public class TestProgram extends Application {

    public static void main(String[] args) {
    launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        SceneControl control = new SceneControl(primaryStage);
        //scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        //control.getAdminsccene();
        control.getMahasiswaScene("Dev");

    }
}
