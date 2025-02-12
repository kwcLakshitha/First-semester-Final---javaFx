package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.smart_school.bo.BOFactory;
import edu.ijse.smart_school.bo.custom.TeacherBO;
import edu.ijse.smart_school.bo.custom.impl.TeacherBOImpl;
import edu.ijse.smart_school.dao.DAOFactory;
import edu.ijse.smart_school.dao.custom.TeacherDAO;
import edu.ijse.smart_school.dto.TeacherDto;
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

public class TeacherProfileController implements Initializable {

    //TeacherDAO teacherModel = (TeacherDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.TEACHER);

    TeacherBO teacherBO = (TeacherBO) BOFactory.getInstance().getBO(BOFactory.BOType.TEACHER);

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
    private Label nicTxt;

    @FXML
    private Label phoneTxt;

    @FXML
    private JFXButton removeBtn;

    @FXML
    private AnchorPane teaProfilePane;

    public static String teacherId;

    private String arr[] = new String[8];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String id = teacherId;
        System.out.println("Check : " +id);

        idTxt.setText(id);

        try {

            ResultSet resultSet = teacherBO.lordProfile(id);
            System.out.println(resultSet.toString());


            while (resultSet.next()) {

                arr[0] = resultSet.getString(1);
                arr[1] = resultSet.getString(2);
                arr[2] = resultSet.getString(3);
                arr[3] = resultSet.getString(4);
                arr[4] = resultSet.getString(5);
                arr[5] = resultSet.getString(6);
                arr[6] = resultSet.getString(7);
                arr[7] = resultSet.getString(8);

            }

            nameTxt.setText(arr[1]);
            addressTxt.setText(arr[2]);
            nicTxt.setText(arr[3]);
            categaryTxt.setText(arr[4]);
            hire_dateTxt.setText(arr[5]);
            emailTxt.setText(arr[6]);
            phoneTxt.setText(arr[7]);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void closeBtnClicked(ActionEvent event) {

        teaProfilePane.getChildren().clear();

        AnchorPane load = null;
        try {
            load = FXMLLoader.load(getClass().getResource("/view/T_ProfilePage.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        teaProfilePane.getChildren().add(load);

    }

    @FXML
    void editeBtnClicked(ActionEvent event) throws IOException {

        new UpdateTeacherController().catchValue(getTeacherDetails());

        Stage window = (Stage) editeBtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/UpdateTeacher.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();

    }

    @FXML
    void removeBtnClicked(ActionEvent event) {

        try {

            Boolean resp = teacherBO.remove(idTxt.getText());
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

    public TeacherDto getTeacherDetails() {

        String id = idTxt.getText();
        String name = nameTxt.getText();
        String address = addressTxt.getText();
        String nic = nicTxt.getText();
        String categary = categaryTxt.getText();
        String hireDate = hire_dateTxt.getText();
        String email = emailTxt.getText();
        String phone = phoneTxt.getText();


        TeacherDto teacherDto = new TeacherDto(id , name , address , nic , categary , hireDate , email , phone);
        return teacherDto;

    }

}
