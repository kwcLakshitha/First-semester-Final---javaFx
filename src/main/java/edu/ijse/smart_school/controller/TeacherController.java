package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.smart_school.bo.BOFactory;
import edu.ijse.smart_school.bo.custom.TeacherBO;
import edu.ijse.smart_school.bo.custom.impl.TeacherBOImpl;
import edu.ijse.smart_school.dao.DAOFactory;
import edu.ijse.smart_school.dao.custom.TeacherDAO;
import edu.ijse.smart_school.dto.TeacherDto;
import edu.ijse.smart_school.dto.tm.TeacherTm;
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

public class TeacherController implements Initializable {

    //TeacherDAO teacherModel = (TeacherDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.TEACHER);

    TeacherBO teacherBO = (TeacherBO) BOFactory.getInstance().getBO(BOFactory.BOType.TEACHER);

    @FXML
    private TableColumn<TeacherTm, String> cateCol;

    @FXML
    private JFXButton homeBtn;

    @FXML
    private TableColumn<TeacherTm, String> idCol;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private TableColumn<TeacherTm, String> nameCol;

    @FXML
    private JFXButton teaAddBtn;

    @FXML
    private AnchorPane teaPane;

    @FXML
    private TableView<TeacherTm> teaTbl;


    @FXML
    void tblClicked(MouseEvent event) {

        try {

            TeacherTm selectedItem = teaTbl.getSelectionModel().getSelectedItem();
            System.out.println("Teacher id : " + selectedItem.getId());

            TeacherProfileController.teacherId = selectedItem.getId();

            teaPane.getChildren().clear();
            AnchorPane pane= FXMLLoader.load(getClass().getResource("/view/TeacherProfilePage.fxml"));
            teaPane.getChildren().add(pane);

            System.out.println("Table clicked");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void homeBtnClicked(ActionEvent event) throws IOException {
        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/DashBoard.fxml"));
        mainAnchorPane.getChildren().add(load);
    }

    @FXML
    void teaAddBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/TeacherAddPage.fxml"));
        mainAnchorPane.getChildren().add(load);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        teaPane.getChildren().clear();

        AnchorPane load = null;
        try {
            load = FXMLLoader.load(getClass().getResource("/view/T_ProfilePage.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        teaPane.getChildren().add(load);

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        cateCol.setCellValueFactory(new PropertyValueFactory<>("categary"));

        ArrayList<TeacherDto> all = null;
        try {
            all = teacherBO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObservableList<TeacherTm> teacherTm = FXCollections.observableArrayList();

        for(TeacherDto tDto : all) {

            TeacherTm tTm = new TeacherTm(tDto.getTeacher_id(), tDto.getName(), tDto.getCategary());
            teacherTm.add(tTm);

        }

        teaTbl.setItems(teacherTm);

    }
}
