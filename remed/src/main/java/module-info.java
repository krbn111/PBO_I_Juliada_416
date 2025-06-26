module com.example.remed {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.remed to javafx.fxml;
    exports com.example.remed;
}