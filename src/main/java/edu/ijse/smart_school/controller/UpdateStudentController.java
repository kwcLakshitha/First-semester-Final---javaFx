package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import edu.ijse.smart_school.bo.BOFactory;
import edu.ijse.smart_school.bo.custom.StudentBO;
import edu.ijse.smart_school.bo.custom.impl.StudentBOImpl;
import edu.ijse.smart_school.dao.DAOFactory;
import edu.ijse.smart_school.dao.custom.StudentDAO;
import edu.ijse.smart_school.dto.StudentDto;
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

public class UpdateStudentController implements Initializable {


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
    private JFXButton updateBtn;

    @FXML
    private TextField schoolTxt;

    @FXML
    private ImageView studImg;

    @FXML
    private JFXButton uplordBtn;

    private static StudentDto studentDto = null;

    @FXML
    void backBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/StudentPage.fxml"));
        mainAnchorPane.getChildren().add(load);
    }


    @FXML
    void updateBtnClicked(ActionEvent event) {

        String id = StudIdTxt.getText();
        String name = nameTxt.getText();
        String categary = cate;
        String dob = String.valueOf(dobTxt.getValue());
        String school = schoolTxt.getText();
        String address = addressTxt.getText();
        String phone = phoneNumberTxt.getText();
        String email = emailTxt.getText();

        StudentDto studentDto = new StudentDto(id , name , categary , dob , school , address , phone , email);

        //StudentDAO studentModel = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENT);

        StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);
        try {
            boolean save = studentBO.update(studentDto);

            if (save){
                new Alert(Alert.AlertType.INFORMATION,"Successfully Update").show();
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
    void uplordBtnClicked(ActionEvent event) {


    }

    public void catchValue(StudentDto studentDto) {
        this.studentDto = studentDto;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println(this.studentDto.getStudentId());

        StudIdTxt.setText(this.studentDto.getStudentId());
        nameTxt.setText(this.studentDto.getName());
        emailTxt.setText(this.studentDto.getEmail());
        addressTxt.setText(this.studentDto.getAddress());
        phoneNumberTxt.setText(this.studentDto.getPhone());
        schoolTxt.setText(this.studentDto.getSchool());
        dobTxt.setValue(LocalDate.parse(this.studentDto.getDateOfBirth()));

        switch (this.studentDto.getCategory()) {
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
