package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.smart_school.bo.BOFactory;
import edu.ijse.smart_school.bo.custom.SignUpBO;
import edu.ijse.smart_school.bo.custom.impl.SignUpBOImpl;
import edu.ijse.smart_school.dao.DAOFactory;
import edu.ijse.smart_school.dao.custom.SignUpDAO;
import edu.ijse.smart_school.dto.SignUpDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpController {

    @FXML
    private JFXButton backBtn;

    @FXML
    private TextField confirmPasswordTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private TextField passwordTxt;

    @FXML
    private JFXButton signinBtn;

    @FXML
    private TextField userNameTxt;

    @FXML
    void backBtnClicked(ActionEvent event) throws IOException {
        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/LoginPage.fxml"));
        mainAnchorPane.getChildren().add(load);
    }

    @FXML
    void signinBtnClicked(ActionEvent event) throws IOException {

        String userName = userNameTxt.getText();
        String email = emailTxt.getText();
        String password = passwordTxt.getText();
        String confirmPassword = confirmPasswordTxt.getText();
        SignUpDto signUpDto = null;

        if (password.equals(confirmPassword)) {

            signUpDto = new SignUpDto(userName,email,password);

            //SignUpDAO signUp = (SignUpDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.SIGNUP);
            SignUpBO signUpBO = (SignUpBO) BOFactory.getInstance().getBO(BOFactory.BOType.SIGNUP);

            try {
                boolean resp = signUpBO.save(signUpDto);

                if (resp) {

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

        else {

            new Alert(Alert.AlertType.ERROR,"somthing went wrong").show();

        }


    }

}
