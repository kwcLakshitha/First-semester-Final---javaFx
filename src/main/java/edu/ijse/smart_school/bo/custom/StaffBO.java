package edu.ijse.smart_school.bo.custom;

import edu.ijse.smart_school.bo.SuperBO;
import edu.ijse.smart_school.dto.StaffDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface StaffBO extends SuperBO {
    ArrayList<StaffDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(StaffDto staffDto) throws SQLException, ClassNotFoundException;
    ResultSet lordProfile(String id) throws SQLException, ClassNotFoundException;
    Boolean remove(String id) throws SQLException, ClassNotFoundException;
    boolean update(StaffDto staffDto) throws SQLException, ClassNotFoundException;
    String getCount() throws SQLException, ClassNotFoundException;
}
