package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import edu.ijse.smart_school.bo.BOFactory;
import edu.ijse.smart_school.bo.custom.TeacherBO;
import edu.ijse.smart_school.bo.custom.impl.TeacherBOImpl;
import edu.ijse.smart_school.dao.DAOFactory;
import edu.ijse.smart_school.dao.custom.TeacherDAO;
import edu.ijse.smart_school.dto.TeacherDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class TeacherAddController {

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
    private JFXButton saveBtn;

    @FXML
    private TextField teaIdTxt;

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
    void uplordBtnClicked(ActionEvent event) {

    }

    @FXML
    void backBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/TeacherPage.fxml"));
        mainAnchorPane.getChildren().add(load);

    }

    @FXML
    void saveBtnClicked(ActionEvent event) {

        String id = teaIdTxt.getText();
        String name = nameTxt.getText();
        String address = addressTxt.getText();
        String nic = nicTxt.getText();
        String categary = cate;
        String hireDate = String.valueOf(hireDateTxt.getValue());
        String email = emailTxt.getText();
        String phone = phoneNumberTxt.getText();


        TeacherDto teacherDto = new TeacherDto(id , name , address , nic , categary , hireDate , email , phone);

        //TeacherDAO teacherModel = (TeacherDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.TEACHER);
        TeacherBO teacherBO = (TeacherBO) BOFactory.getInstance().getBO(BOFactory.BOType.TEACHER);
        try {
            boolean save = teacherBO.save(teacherDto);

            if (save){
                new Alert(Alert.AlertType.INFORMATION,"Successfully save").show();

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


}
