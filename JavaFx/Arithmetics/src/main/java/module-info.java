module com.javafx.arithmetics {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javafx.arithmetics to javafx.fxml;
    exports com.javafx.arithmetics;
}