package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.smart_school.dto.StaffDto;
import edu.ijse.smart_school.dto.TeacherDto;

import edu.ijse.smart_school.model.StaffModel;
import edu.ijse.smart_school.model.TeacherModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UpdateStaffController implements Initializable {

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
    private JFXButton updateBtn;

    @FXML
    private JFXButton uplordBtn;


    private static StaffDto staffDto = null;

    @FXML
    void backBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/StaffPage.fxml"));
        mainAnchorPane.getChildren().add(load);

    }

    @FXML
    void updateBtnClicked(ActionEvent event) {

        String id = memberIdTxt.getText();
        String name = nameTxt.getText();
        String address = addressTxt.getText();
        String position = positionTxt.getText();
        String hireDate = String.valueOf(hireDateTxt.getValue());
        String email = emailTxt.getText();
        String phone = phoneNumberTxt.getText();

        StaffDto staffDto = new StaffDto(id, name, address, position, hireDate, email, phone);

        StaffModel staffModel = new StaffModel();
        try {
            boolean save = staffModel.updateStaff(staffDto);

            if (save){
                new Alert(Alert.AlertType.INFORMATION,"Successfully Update").show();
            }
            else {
                new Alert(Alert.AlertType.ERROR,"somthing went wrong").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void uplordBtnClicked(ActionEvent event) {

    }

    public void catchValue(StaffDto staffDetails) {

        this.staffDto = staffDetails;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        memberIdTxt.setText(this.staffDto.getMemberId());
        nameTxt.setText(this.staffDto.getName());
        addressTxt.setText(this.staffDto.getAddress());
        positionTxt.setText(this.staffDto.getPosition());
        hireDateTxt.setValue(LocalDate.parse(this.staffDto.getHire_date()));
        emailTxt.setText(this.staffDto.getEmail());
        phoneNumberTxt.setText(this.staffDto.getPhone());

    }
}
