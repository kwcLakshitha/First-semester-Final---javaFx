package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.smart_school.bo.BOFactory;
import edu.ijse.smart_school.bo.custom.StaffBO;
import edu.ijse.smart_school.bo.custom.impl.StaffBOImpl;
import edu.ijse.smart_school.dao.DAOFactory;
import edu.ijse.smart_school.dao.custom.StaffDAO;
import edu.ijse.smart_school.dto.StaffDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.sql.SQLException;

public class StaffAddController {

    @FXML
    private TextField addressTxt;

    @FXML
    private JFXButton backBtn;

    @FXML
    private TextField emailTxt;

    @FXML
    private DatePicker hireDateTxt;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private TextField memberIdTxt;

    @FXML
    private ImageView memberImg;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField phoneNumberTxt;

    @FXML
    private TextField positionTxt;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXButton uplordBtn;

    @FXML
    void uplordBtnClicked(ActionEvent event) {

    }

    @FXML
    void backBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/StaffPage.fxml"));
        mainAnchorPane.getChildren().add(load);

    }

    @FXML
    void saveBtnClicked(ActionEvent event) {

        String id = memberIdTxt.getText();
        String name = nameTxt.getText();
        String address = addressTxt.getText();
        String position = positionTxt.getText();
        String hireDate = String.valueOf(hireDateTxt.getValue());
        String email = emailTxt.getText();
        String phone = phoneNumberTxt.getText();

        StaffDto staffDto = new StaffDto(id, name, address, position, hireDate, email, phone);

        //StaffDAO staffModel = (StaffDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STAFF);
        StaffBO staffBO = (StaffBO) BOFactory.getInstance().getBO(BOFactory.BOType.STAFF);
        try {
            boolean save = staffBO.save(staffDto);

            if (save) {
                new Alert(Alert.AlertType.INFORMATION, "Successfully save").show();

            } else {
                new Alert(Alert.AlertType.ERROR, "somthing went wrong").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
