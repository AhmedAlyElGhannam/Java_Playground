module com.mycompany.guichat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.guichat to javafx.fxml;
    exports com.mycompany.guichat;
}
