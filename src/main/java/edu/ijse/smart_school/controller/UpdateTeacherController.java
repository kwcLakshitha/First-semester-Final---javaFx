package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import edu.ijse.smart_school.dto.StudentDto;
import edu.ijse.smart_school.dto.TeacherDto;
import edu.ijse.smart_school.model.StudentModel;
import edu.ijse.smart_school.model.TeacherModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UpdateTeacherController implements Initializable {

    @FXML
    private TextField addressTxt;

    @FXML
    private JFXToggleButton al_tgl;

    @FXML
    private JFXButton backBtn;

    @FXML
    private TextField emailTxt;

    @FXML
    private DatePicker hireDateTxt;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField nicTxt;

    @FXML
    private JFXToggleButton ol_tgl;

    @FXML
    private JFXToggleButton other_tgl;

    @FXML
    private TextField phoneNumberTxt;

    @FXML
    private TextField teaIdTxt;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private JFXButton uplordBtn;

    private static TeacherDto teacherDto  = null;

    @FXML
    void backBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/TeacherPage.fxml"));
        mainAnchorPane.getChildren().add(load);

    }

    private String cate;

    @FXML
    void tglClicked(ActionEvent event) {
        if (al_tgl.isSelected()){
            ol_tgl.setSelected(false);
            other_tgl.setSelected(false);
            cate=al_tgl.getText();
            System.out.println(cate);
        }
        if(ol_tgl.isSelected()){
            al_tgl.setSelected(false);
            other_tgl.setSelected(false);
            cate=ol_tgl.getText();
            System.out.println(cate);
        }
        if (other_tgl.isSelected()){
            al_tgl.setSelected(false);
            ol_tgl.setSelected(false);
            cate = other_tgl.getText();
            System.out.println(cate);
        }

    }

    @FXML
    void updateBtnClicked(ActionEvent event) {

        String id = teaIdTxt.getText();
        String name = nameTxt.getText();
        String address = addressTxt.getText();
        String nic = nicTxt.getText();
        String categary = cate;
        String hireDate = String.valueOf(hireDateTxt.getValue());
        String email = emailTxt.getText();
        String phone = phoneNumberTxt.getText();


        TeacherDto teacherDto = new TeacherDto(id , name , address , nic , categary , hireDate , email , phone);

        TeacherModel teacherModel = new TeacherModel();
        try {
            boolean save = teacherModel.updateTeacher(teacherDto);

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

    public void catchValue(TeacherDto teacherDetails) {
        this.teacherDto = teacherDetails;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        teaIdTxt.setText(this.teacherDto.getTeacher_id());
        nameTxt.setText(this.teacherDto.getName());
        emailTxt.setText(this.teacherDto.getEmail());
        addressTxt.setText(this.teacherDto.getAddress());
        phoneNumberTxt.setText(this.teacherDto.getPhone());
        nicTxt.setText(this.teacherDto.getNic());
        hireDateTxt.setValue(LocalDate.parse(this.teacherDto.getHire_date()));

        switch (this.teacherDto.getCategary()) {
            case "A/L":
                al_tgl.setSelected(true);
                break;
            case "O/L":
                ol_tgl.setSelected(true);
                break;
            default: other_tgl.setSelected(true);
        }

    }
}
