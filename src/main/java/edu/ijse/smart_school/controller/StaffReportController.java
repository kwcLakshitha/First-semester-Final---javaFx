package edu.ijse.smart_school.controller;

import edu.ijse.smart_school.dto.StaffDto;
import edu.ijse.smart_school.dto.tm.StaffTm;
import edu.ijse.smart_school.model.StaffModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StaffReportController implements Initializable {

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TextField reportIdTxt;

    @FXML
    private Label staffIdLbl;

    @FXML
    private AnchorPane staffReportPane;

    @FXML
    private TableView<StaffTm> staffReportTbl;

    @FXML
    private TextArea text;

    @FXML
    void tblClicked(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        StaffModel staffModel = new StaffModel();

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
      //  posiCol.setCellValueFactory(new PropertyValueFactory<>("position"));

        try {
            ArrayList<StaffDto> all = staffModel.getAll();
            ObservableList<StaffTm> staffTm = FXCollections.observableArrayList();

            for(StaffDto sDto : all) {

                StaffTm sTm = new StaffTm(sDto.getMemberId(), sDto.getName());
                staffTm.add(sTm);

            }

            staffReportTbl.setItems(staffTm);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
