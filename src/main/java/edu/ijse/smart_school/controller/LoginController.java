package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.smart_school.model.SignUpModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField userNameTxt;

    @FXML
    private JFXButton fPasswordBtn;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private JFXButton signUpBtn;

    @FXML
    void fPasswordBtnClicked(ActionEvent event) {

    }

    String userName = null;
    String password = null;

    @FXML
    void loginBtnClicked(ActionEvent event) throws IOException {

        userName = userNameTxt.getText();
        password = passwordTxt.getText();

        System.out.println("User name : " + userName);

        if (userName.equals("")) {

            new Alert(Alert.AlertType.ERROR,"somthing went wrong").show();
            return;

        }

        SignUpModel signUpModel = new SignUpModel();
        try {
            String log = signUpModel.log(userName);

            if (password.equals(log)) {

                mainAnchorPane.getChildren().clear();
                AnchorPane load = FXMLLoader.load(getClass().getResource("/view/DashBoard.fxml"));
                mainAnchorPane.getChildren().add(load);

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
    void signUpBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/SignupPage.fxml"));
        mainAnchorPane.getChildren().add(load);

    }

}
