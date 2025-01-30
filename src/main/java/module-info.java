module edu.ijse.smart_school {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.ijse.smart_school to javafx.fxml;
    exports edu.ijse.smart_school;
}