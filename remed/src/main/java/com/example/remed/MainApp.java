package com.example.remed;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        Dashboard dashboard = new Dashboard(primaryStage);
        dashboard.tampilkan();
    }

    public static void main(String[] args) {
        launch(args);
    }
}