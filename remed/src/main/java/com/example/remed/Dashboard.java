package com.example.remed;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Dashboard {
    private Stage stage;
    private DaftarTugas daftarTugas = new DaftarTugas();
    private ObservableList<Tugas> observableTugas = FXCollections.observableArrayList();
    private ListView<Tugas> listView = new ListView<>(observableTugas);

    public Dashboard(Stage stage) {
        this.stage = stage;
    }

    public void tampilkan() {
        Label titleLabel = new Label("TUGAS PRAKTIKUM");
        titleLabel.setFont(Font.font("Arial", 20));
        titleLabel.setTextFill(Color.WHITE);

        // Field
        TextField judulField = new TextField();
        judulField.setPromptText("Judul Tugas");
        TextField modulField = new TextField();
        modulField.setPromptText("Modul");

        // Tombol
        Button tambahBtn = new Button("Tambah");
        Button selesaiBtn = new Button("Tandai Selesai");
        Button hapusBtn = new Button("Hapus");

        tambahBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        selesaiBtn.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        hapusBtn.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");

        tambahBtn.setOnAction(e -> {
            try {
                String judul = judulField.getText().trim();
                String modul = modulField.getText().trim();
                if (judul.isEmpty() || modul.isEmpty()) throw new Exception("Input tidak boleh kosong.");
                daftarTugas.tambahTugas(new Tugas(judul, modul));
                judulField.clear(); modulField.clear();
                refreshList();
            } catch (Exception ex) {
                alertError(ex.getMessage());
            }
        });

        selesaiBtn.setOnAction(e -> {
            try {
                int index = listView.getSelectionModel().getSelectedIndex();
                daftarTugas.tandaiSelesai(index);
                refreshList();
            } catch (Exception ex) {
                alertError(ex.getMessage());
            }
        });

        hapusBtn.setOnAction(e -> {
            try {
                int index = listView.getSelectionModel().getSelectedIndex();
                daftarTugas.hapusTugas(index);
                refreshList();
            } catch (Exception ex) {
                alertError(ex.getMessage());
            }
        });

        // Kotak input
        VBox inputBox = new VBox(10, judulField, modulField, tambahBtn);
        VBox buttonBox = new VBox(10, selesaiBtn, hapusBtn);
        inputBox.setPadding(new Insets(10));
        buttonBox.setPadding(new Insets(10));
        inputBox.setStyle("-fx-background-color: #ffffff; -fx-border-radius: 8; -fx-background-radius: 8;");
        buttonBox.setStyle("-fx-background-color: #ffffff; -fx-border-radius: 8; -fx-background-radius: 8;");

        // Area utama
        HBox mainLayout = new HBox(20, inputBox, listView, buttonBox);
        mainLayout.setAlignment(Pos.CENTER);

        VBox root = new VBox(15, titleLabel, mainLayout);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: linear-gradient(to right, #2c3e50, #3498db);");

        listView.setStyle("-fx-control-inner-background: #ecf0f1;");

        Scene scene = new Scene(root, 700, 400);
        stage.setScene(scene);
        stage.setTitle("Dashboard Praktikum");
        stage.show();
    }

    private void refreshList() {
        observableTugas.setAll(daftarTugas.getDaftarTugas());
    }

    private void alertError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Kesalahan");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
