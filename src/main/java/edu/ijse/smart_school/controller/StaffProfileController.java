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
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class StaffProfileController implements Initializable {

//    StaffDAO staffModel = (StaffDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STAFF);

    StaffBO staffBO = (StaffBO) BOFactory.getInstance().getBO(BOFactory.BOType.STAFF);

    @FXML
    private Label addressTxt;

    @FXML
    private Label categaryTxt;

    @FXML
    private JFXButton closeBtn;

    @FXML
    private JFXButton editeBtn;

    @FXML
    private Label emailTxt;

    @FXML
    private Label hire_dateTxt;

    @FXML
    private Label idTxt;

    @FXML
    private Label nameTxt;

    @FXML
    private Label phoneTxt;

    @FXML
    private Label positionTxt;

    @FXML
    private JFXButton removeBtn;

    @FXML
    private AnchorPane staffProfilePane;

    public static String staffId;
    private String[] arr = new String[7];

    @FXML
    void closeBtnClicked(ActionEvent event) {

        staffProfilePane.getChildren().clear();

        AnchorPane load = null;
        try {
            load = FXMLLoader.load(getClass().getResource("/view/STF_ProfilePage.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        staffProfilePane.getChildren().add(load);

    }

    @FXML
    void editeBtnClicked(ActionEvent event) throws IOException {

        new UpdateStaffController().catchValue(getStaffDetails());

        Stage window = (Stage) editeBtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/UpdateStaff.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();

    }

    @FXML
    void removeBtnClicked(ActionEvent event) {

        try {

            Boolean resp = staffBO.remove(idTxt.getText());
            if (resp){
                new Alert(Alert.AlertType.INFORMATION,"Successfully").show();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String id = staffId;
        System.out.println("Check : " +id);

        idTxt.setText(id);

        try {

            ResultSet resultSet = staffBO.lordProfile(id);
            System.out.println(resultSet.toString());


            while (resultSet.next()) {

                arr[0] = resultSet.getString(1);
                arr[1] = resultSet.getString(2);
                arr[2] = resultSet.getString(3);
                arr[3] = resultSet.getString(4);
                arr[4] = resultSet.getString(5);
                arr[5] = resultSet.getString(6);
                arr[6] = resultSet.getString(7);

            }

            nameTxt.setText(arr[1]);
            addressTxt.setText(arr[2]);
            positionTxt.setText(arr[3]);
            hire_dateTxt.setText(arr[4]);
            phoneTxt.setText(arr[5]);
            emailTxt.setText(arr[6]);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public StaffDto getStaffDetails() {

        String id = idTxt.getText();
        String name = nameTxt.getText();
        String address = addressTxt.getText();
        String position = positionTxt.getText();
        String hireDate = hire_dateTxt.getText();
        String email = emailTxt.getText();
        String phone = phoneTxt.getText();

        StaffDto staffDto = new StaffDto(id, name, address, position, hireDate, email, phone);

        return staffDto;

    }
}
