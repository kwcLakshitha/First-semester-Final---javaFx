module edu.ijse.smart_school {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.jfoenix;


    opens edu.ijse.smart_school.controller to javafx.fxml;
    exports edu.ijse.smart_school;
    exports edu.ijse.smart_school.dto.tm;
}