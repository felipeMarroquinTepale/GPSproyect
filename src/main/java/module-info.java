module com.example.gpsproyect {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gpsproyect to javafx.fxml;
    exports com.example.gpsproyect;
}