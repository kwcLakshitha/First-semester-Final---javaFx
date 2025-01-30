package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.smart_school.model.SignUpModel;
import edu.ijse.smart_school.model.StaffModel;
import edu.ijse.smart_school.model.StudentModel;
import edu.ijse.smart_school.model.TeacherModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {



    @FXML
    private Label currentDateLbl;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private JFXButton memberBtn;

    @FXML
    private JFXButton reportBtn;

    @FXML
    private JFXButton staffBtn;

    @FXML
    private Label staffCountLbl;

    @FXML
    private JFXButton studBtn;

    @FXML
    private Label studCountLbl;

    @FXML
    private Label teaCountLbl;

    @FXML
    private JFXButton teacherBtn;

    @FXML
    private Label userNamelbl;

    @FXML
    void reportBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/ReportPage.fxml"));
        mainAnchorPane.getChildren().add(load);

    }


    @FXML
    void memberBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/LoginPage.fxml"));
        mainAnchorPane.getChildren().add(load);

    }

    @FXML
    void staffBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/StaffPage.fxml"));
        mainAnchorPane.getChildren().add(load);

    }

    @FXML
    void studBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/StudentPage.fxml"));
        mainAnchorPane.getChildren().add(load);

    }

    @FXML
    void teacherBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/TeacherPage.fxml"));
        mainAnchorPane.getChildren().add(load);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        StudentModel studentModel = new StudentModel();
        try {
            studCountLbl.setText(studentModel.getCount());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        TeacherModel teacherModel = new TeacherModel();
        try {
            teaCountLbl.setText(teacherModel.getCount());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        StaffModel staffModel = new StaffModel();

        try {
            staffCountLbl.setText(staffModel.getCount());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
