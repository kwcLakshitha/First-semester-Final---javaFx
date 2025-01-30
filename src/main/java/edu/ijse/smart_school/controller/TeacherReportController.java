package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.smart_school.dto.TeacherDto;
import edu.ijse.smart_school.dto.tm.TeacherTm;
import edu.ijse.smart_school.model.StudentModel;
import edu.ijse.smart_school.model.TeacherModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TeacherReportController implements Initializable {

    private AnchorPane TeaReportPane;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TextField reportIdTxt;

    @FXML
    private Label teaIdLbl;

    @FXML
    private TableView<TeacherTm> teaReportTbl;

    @FXML
    private TextArea text;


    @FXML
    private JFXButton saveBtn;

    @FXML
    void saveBtnClicked(ActionEvent event) {

        String teacherId = teaIdLbl.getText();
        String repo_id = reportIdTxt.getText();
        String repo= text.getText();

        try {
            boolean isSaved = TeacherTm.addReport(teacherId,repo_id,repo);
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION, "Customer saved...!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to save customer...!").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void tblClicked(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TeacherModel teacherModel = new TeacherModel();

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
      //  cateCol.setCellValueFactory(new PropertyValueFactory<>("categary"));

        ArrayList<TeacherDto> all = null;
        try {
            all = teacherModel.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObservableList<TeacherTm> teacherTm = FXCollections.observableArrayList();

        for(TeacherDto tDto : all) {

            TeacherTm tTm = new TeacherTm(tDto.getTeacher_id(), tDto.getName());
            teacherTm.add(tTm);

        }

        teaReportTbl.setItems(teacherTm);
    }
}
