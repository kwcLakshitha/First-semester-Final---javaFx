package edu.ijse.smart_school.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.smart_school.bo.BOFactory;
import edu.ijse.smart_school.bo.custom.StaffBO;
import edu.ijse.smart_school.bo.custom.impl.StaffBOImpl;
import edu.ijse.smart_school.dao.DAOFactory;
import edu.ijse.smart_school.dao.custom.StaffDAO;
import edu.ijse.smart_school.dto.StaffDto;
import edu.ijse.smart_school.dto.tm.StaffTm;
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

public class StaffController implements Initializable {

    //StaffDAO staffModel = (StaffDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STAFF);

    StaffBO staffBO = (StaffBO) BOFactory.getInstance().getBO(BOFactory.BOType.STAFF);

    @FXML
    private JFXButton homeBtn;

    @FXML
    private TableColumn<StaffTm, String> idCol;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private TableColumn<StaffTm, String> nameCol;

    @FXML
    private TableColumn<StaffTm, String> posiCol;

    @FXML
    private JFXButton staffAddBtn;

    @FXML
    private AnchorPane staffPane;

    @FXML
    private TableView<StaffTm> staffTbl;

    @FXML
    void homeBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/DashBoard.fxml"));
        mainAnchorPane.getChildren().add(load);

    }

    @FXML
    void staffAddBtnClicked(ActionEvent event) throws IOException {

        mainAnchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/StaffAddPage.fxml"));
        mainAnchorPane.getChildren().add(load);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        staffPane.getChildren().clear();

        AnchorPane load = null;
        try {
            load = FXMLLoader.load(getClass().getResource("/view/STF_ProfilePage.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        staffPane.getChildren().add(load);

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        posiCol.setCellValueFactory(new PropertyValueFactory<>("position"));

        try {
            ArrayList<StaffDto> all = staffBO.getAll();
            ObservableList<StaffTm> staffTm = FXCollections.observableArrayList();

            for(StaffDto sDto : all) {

                StaffTm sTm = new StaffTm(sDto.getMemberId(), sDto.getName() , sDto.getPosition());
                staffTm.add(sTm);

            }

            staffTbl.setItems(staffTm);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void tblClicked(MouseEvent event) {

        try {

            StaffTm selectedItem = staffTbl.getSelectionModel().getSelectedItem();
            System.out.println("Staff id : " + selectedItem.getId());

            StaffProfileController.staffId = selectedItem.getId();

            staffPane.getChildren().clear();
            AnchorPane pane= FXMLLoader.load(getClass().getResource("/view/StaffProfilePage.fxml"));
            staffPane.getChildren().add(pane);

            System.out.println("Table clicked");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
