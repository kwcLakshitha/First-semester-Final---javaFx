package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.smart_school.dto.StudentDto;
import edu.ijse.smart_school.dto.TeacherDto;
import edu.ijse.smart_school.dto.tm.StudentTm;
import edu.ijse.smart_school.dto.tm.TeacherTm;
import edu.ijse.smart_school.model.StudentModel;
import edu.ijse.smart_school.model.TeacherModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportController {

    @FXML
    private JFXButton homeBtn;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private AnchorPane reportPane;

    @FXML
    private TableView<StudentTm> reportTbl;

    @FXML
    private JFXButton staffBtn;

    @FXML
    private JFXButton studentBtn;

    @FXML
    private JFXButton teacherBtn;



    @FXML
    void homeBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/DashBoard.fxml"));
        mainAnchorPane.getChildren().add(load);

    }

    @FXML
    void staffBtnClicked(ActionEvent event) throws IOException {

        reportPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/StaffReportPage.fxml"));
        reportPane.getChildren().add(load);

    }

    @FXML
    void studentBtnClicked(ActionEvent event) throws IOException {

        reportPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/StudentReportPage.fxml"));
        reportPane.getChildren().add(load);

    }

    @FXML
    void teacherBtnClicked(ActionEvent event) throws IOException {

        reportPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/TeacherReportPage.fxml"));
        reportPane.getChildren().add(load);

    }


    @FXML
    void tblClicked(MouseEvent event) {

    }

}
