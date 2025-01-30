package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.smart_school.dto.StudentDto;
import edu.ijse.smart_school.model.StudentModel;
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

public class StudentProfileController implements Initializable{

    StudentModel studentModel = new StudentModel();
 //   StudentController studentController = new StudentController();


    @FXML
    private Label addressTxt;


    @FXML
    private JFXButton closeBtn;

    @FXML
    private Label categaryTxt;

    @FXML
    private Label dobTxt;

    @FXML
    private JFXButton editeBtn;

    @FXML
    private Label emailTxt;

    @FXML
    private Label idTxt;

    @FXML
    private Label nameTxt;

    @FXML
    private Label phoneTxt;

    @FXML
    private JFXButton removeBtn;

    @FXML
    private Label schoolTxt;

    @FXML
    private AnchorPane studProfilePane;


    public static String studentId;

    private String arr[] = new String[8];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        String id = studentId;
        System.out.println("Check : " +id);

        idTxt.setText(id);

        try {

            ResultSet resultSet = studentModel.lordProfile(id);
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
            categaryTxt.setText(arr[2]);
            dobTxt.setText(arr[3]);
            schoolTxt.setText(arr[4]);
            addressTxt.setText(arr[5]);
            phoneTxt.setText(arr[6]);
            emailTxt.setText(arr[7]);




        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void closeBtnClicked(ActionEvent event) {

        studProfilePane.getChildren().clear();

        AnchorPane load = null;
        try {
            load = FXMLLoader.load(getClass().getResource("/view/S_ProfilePage.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        studProfilePane.getChildren().add(load);

    }

    @FXML
    void editeBtnClicked(ActionEvent event) throws IOException {

        new UpdateStudentController().catchValue(getStudentDetails());

        Stage window = (Stage) editeBtn.getScene().getWindow();
        window.close();
        Parent load = FXMLLoader.load(getClass().getResource("/view/UpdateStudent.fxml"));
        Scene scene = new Scene(load);
        window.setScene(scene);
        window.show();

    }




    @FXML
    void removeBtnClicked(ActionEvent event) {

        try {

            Boolean resp = studentModel.removeStudent(idTxt.getText());



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

    public StudentDto getStudentDetails() {

        String id = idTxt.getText();
        String name = nameTxt.getText();
        String categary = categaryTxt.getText();
        String dob = dobTxt.getText();
        String school = schoolTxt.getText();
        String address = addressTxt.getText();
        String phone = phoneTxt.getText();
        String email = emailTxt.getText();

        StudentDto studentDto = new StudentDto(id , name , categary , dob , school , address , phone , email);

        System.out.println(id + " " + name + " " + categary + " " + dob + " " + school + " " + address + " " + phone + " " + email);
        return studentDto;

    }
}
