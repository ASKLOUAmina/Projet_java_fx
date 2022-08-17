module com.poo.zelda {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.poo.project_zelda to javafx.fxml;
    exports com.poo.project_zelda;
}