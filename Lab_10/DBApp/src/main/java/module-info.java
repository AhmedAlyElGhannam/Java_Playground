module com.mycompany.dbapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires derbyclient;
    requires java.base;

    opens com.mycompany.dbapp to javafx.fxml;
    exports com.mycompany.dbapp;
}
