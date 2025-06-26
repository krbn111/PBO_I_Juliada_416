package com.rumahsakit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Dashboard {
    private VBox root = new VBox(10);
    private ListView<String> listView = new ListView<>();
    private ObservableList<String> listItems = FXCollections.observableArrayList();
    private AntrianRS antrian = new AntrianRS();

    public Dashboard(Stage stage) {
        Label title = new Label("🏥 Sistem Antrian Rumah Sakit");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #006064;");

        TextField nama = new TextField(); nama.setPromptText("Nama Pasien");
        TextField keluhan = new TextField(); keluhan.setPromptText("Keluhan");

        Button tambah = new Button("Tambah Pasien");
        Button panggil = new Button("Panggil Berikutnya");
        Button reset = new Button("Reset Antrian");

        listView.setItems(listItems);
        listView.setPrefHeight(200);
        listView.setStyle("-fx-border-color: #b2ebf2; -fx-border-radius: 5; -fx-padding: 5;");


        tambah.setOnAction(e -> {
            if (!nama.getText().isEmpty() && !keluhan.getText().isEmpty()) {
                antrian.tambahPasien(nama.getText(), keluhan.getText());
                refreshList();
                nama.clear();
                keluhan.clear();
            }
        });

        panggil.setOnAction(e -> {
            Pasien p = antrian.panggilPasien();
            if (p != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("📢 Panggilan Pasien");
                alert.setHeaderText("Pasien Berikutnya");
                alert.setContentText("🔔 " + p.toString());

            // Tambahkan gaya
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.setStyle("""
                 -fx-background-color: linear-gradient(to bottom right, #e3f2fd, #ffffff);
                 -fx-font-size: 14px;
                 -fx-font-weight: bold;
                 -fx-font-family: 'Segoe UI';""");

                alert.showAndWait();

            }
        });

        reset.setOnAction(e -> {
            antrian.reset();
            refreshList();
        });

        root.setStyle("""
        -fx-background-color: linear-gradient(to bottom right, #e0f7fa, #ffffff);
        -fx-padding: 20;
        -fx-spacing: 10;
        -fx-alignment: center;""");

        tambah.setStyle("-fx-background-color: #00acc1; -fx-text-fill: white; -fx-font-weight: bold;");
        panggil.setStyle("-fx-background-color: #26a69a; -fx-text-fill: white; -fx-font-weight: bold;");
        reset.setStyle("-fx-background-color: #ef5350; -fx-text-fill: white; -fx-font-weight: bold;");

        root.getChildren().addAll(title, nama, keluhan, tambah, panggil, reset, listView);
    }

    private void refreshList() {
        listItems.clear();
        for (Pasien p : antrian.getAntrian()) {
            listItems.add(p.toString());
        }
    }

    public VBox getRoot() {
        return root;
    }
}
