package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.smart_school.bo.BOFactory;
import edu.ijse.smart_school.bo.custom.StaffBO;
import edu.ijse.smart_school.bo.custom.StudentBO;
import edu.ijse.smart_school.bo.custom.TeacherBO;
import edu.ijse.smart_school.bo.custom.impl.StaffBOImpl;
import edu.ijse.smart_school.bo.custom.impl.StudentBOImpl;
import edu.ijse.smart_school.bo.custom.impl.TeacherBOImpl;
import edu.ijse.smart_school.dao.custom.impl.StaffDAOImpl;
import edu.ijse.smart_school.dao.custom.impl.StudentDAOImpl;
import edu.ijse.smart_school.dao.custom.impl.TeacherDAOImpl;
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

        //StudentDAOImpl studentModel = new StudentDAOImpl();
        StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);
        try {
            studCountLbl.setText(studentBO.getCount());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

//        TeacherDAOImpl teacherModel = new TeacherDAOImpl();
        TeacherBO teacherBO = (TeacherBO) BOFactory.getInstance().getBO(BOFactory.BOType.TEACHER);
        try {
            teaCountLbl.setText(teacherBO.getCount());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //StaffDAOImpl staffModel = new StaffDAOImpl();
        StaffBO staffBO = (StaffBO) BOFactory.getInstance().getBO(BOFactory.BOType.STAFF);

        try {
            staffCountLbl.setText(staffBO.getCount());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
