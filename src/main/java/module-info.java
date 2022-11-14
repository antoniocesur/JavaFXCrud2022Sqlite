module com.example.javafxcrud2022sqlite {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafxcrud2022sqlite to javafx.fxml;
    exports com.example.javafxcrud2022sqlite;
}