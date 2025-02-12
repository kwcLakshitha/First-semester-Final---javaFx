package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.smart_school.bo.BOFactory;
import edu.ijse.smart_school.bo.custom.StudentBO;
import edu.ijse.smart_school.bo.custom.impl.StudentBOImpl;
import edu.ijse.smart_school.dao.DAOFactory;
import edu.ijse.smart_school.dao.custom.StudentDAO;
import edu.ijse.smart_school.dto.StudentDto;
import edu.ijse.smart_school.dto.tm.StudentTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class StudentController implements Initializable {

//    StudentDAO studentModel = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENT);

    StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);
    @FXML
    private TableColumn<StudentTm, String> cateCol;

    @FXML
    private JFXButton homeBtn;

    @FXML
    private TableColumn<StudentTm, String> idCol;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private TableColumn<StudentTm, String> nameCol;

    @FXML
    private JFXButton studAddBtn;

    @FXML
    private AnchorPane studPane;

    @FXML
    private TableView<StudentTm> studTbl;


    @FXML
    void homeBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/DashBoard.fxml"));
        mainAnchorPane.getChildren().add(load);

    }

    @FXML
    void studAddBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/StudentAddPage.fxml"));
        mainAnchorPane.getChildren().add(load);

    }

    @FXML
    void tblClicked(MouseEvent event) {

        try {

            StudentTm selectedItem = studTbl.getSelectionModel().getSelectedItem();
            System.out.println("Student id : " + selectedItem.getId());

            StudentProfileController.studentId = selectedItem.getId();

            studPane.getChildren().clear();
            AnchorPane pane= FXMLLoader.load(getClass().getResource("/view/StudentProfilePage.fxml"));
            studPane.getChildren().add(pane);

        System.out.println("Table clicked");

    }catch (Exception e){
            e.printStackTrace();
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        studPane.getChildren().clear();

        AnchorPane load = null;
        try {
            load = FXMLLoader.load(getClass().getResource("/view/S_ProfilePage.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        studPane.getChildren().add(load);

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        cateCol.setCellValueFactory(new PropertyValueFactory<>("categary"));

        try {
            ArrayList<StudentDto> all = studentBO.getAll();
            ObservableList<StudentTm> studentTm = FXCollections.observableArrayList();

            for(StudentDto sDto : all) {

                StudentTm sTm = new StudentTm(sDto.getStudentId(), sDto.getName(), sDto.getCategory());
                studentTm.add(sTm);

            }

            studTbl.setItems(studentTm);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
}
