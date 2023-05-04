module com.example.taller_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens Vista_Controller to javafx.fxml;
    exports Vista_Controller;
}