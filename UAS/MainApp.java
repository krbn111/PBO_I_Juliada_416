package com.rumahsakit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        Dashboard dashboard = new Dashboard(primaryStage);
        Scene scene = new Scene(dashboard.getRoot(), 500, 450);
        primaryStage.setTitle("Antrian RS - JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
