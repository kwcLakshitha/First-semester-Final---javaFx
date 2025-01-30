package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.smart_school.dto.StudentDto;
import edu.ijse.smart_school.dto.tm.StudentTm;
import edu.ijse.smart_school.model.StudentModel;
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

public class StudentReportController implements Initializable {


    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TextField reportIdTxt;

    @FXML
    private Label studIdLbl;

    @FXML
    private AnchorPane studReportPane;

    @FXML
    private TableView<StudentTm> studReportTbl;

    @FXML
    private TextArea text;

    @FXML
    private JFXButton saveBtn;

    @FXML
    void saveBtn(ActionEvent event) {
        String studenId = studIdLbl.getText();
        String repo_id = reportIdTxt.getText();
        String repo= text.getText();

        try {
            boolean isSaved = StudentModel.addReport(studenId,repo_id,repo);
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION, "Customer saved...!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to save customer...!").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void tblClicked(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        StudentModel studentModel = new StudentModel();

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
     //   cateCol.setCellValueFactory(new PropertyValueFactory<>("categary"));

        try {
            ArrayList<StudentDto> all = studentModel.getAll();
            ObservableList<StudentTm> studentTm = FXCollections.observableArrayList();

            for(StudentDto sDto : all) {

                StudentTm sTm = new StudentTm(sDto.getStudentId(), sDto.getName());
                studentTm.add(sTm);

            }

            studReportTbl.setItems(studentTm);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
