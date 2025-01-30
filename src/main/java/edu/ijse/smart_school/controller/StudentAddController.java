package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import edu.ijse.smart_school.dto.StudentDto;
import edu.ijse.smart_school.model.StudentModel;
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
import java.util.Locale;
import java.util.ResourceBundle;

public class StudentAddController{

    @FXML
    private TextField StudIdTxt;

    @FXML
    private TextField addressTxt;

    @FXML
    private JFXToggleButton al_tgl;

    @FXML
    private JFXButton backBtn;

    @FXML
    private DatePicker dobTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private TextField nameTxt;

    @FXML
    private JFXToggleButton ol_tgl;

    @FXML
    private JFXToggleButton other_tgl;

    @FXML
    private TextField phoneNumberTxt;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private TextField schoolTxt;

    @FXML
    private ImageView studImg;

    @FXML
    private JFXButton uplordBtn;

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
    void backBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/StudentPage.fxml"));
        mainAnchorPane.getChildren().add(load);

    }

    @FXML
    void saveBtnClicked(ActionEvent event) {

        String id = StudIdTxt.getText();
        String name = nameTxt.getText();
        String categary = cate;
        String dob = String.valueOf(dobTxt.getValue());
        String school = schoolTxt.getText();
        String address = addressTxt.getText();
        String phone = phoneNumberTxt.getText();
        String email = emailTxt.getText();

        StudentDto studentDto = new StudentDto(id , name , categary , dob , school , address , phone , email);

        StudentModel studentModel = new StudentModel();
        try {
            boolean save = studentModel.save(studentDto);
            if (save){
                new Alert(Alert.AlertType.INFORMATION,"Successfully save").show();
                System.out.println(studentDto.getStudentId()+studentDto.getName()+studentDto.getDateOfBirth()+studentDto.getCategory()+studentDto.getPhone()+studentDto.getSchool()+studentDto.getAddress()+studentDto.getEmail());
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

}
