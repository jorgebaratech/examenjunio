module com.mycompany.examenjunio {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.examenjunio to javafx.fxml;
    exports com.mycompany.examenjunio;
}
