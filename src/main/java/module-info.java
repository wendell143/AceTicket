module com.example.demo3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo3 to javafx.fxml;
    exports com.example.demo3;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires java.net.http;
}