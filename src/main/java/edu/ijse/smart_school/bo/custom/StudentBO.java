package edu.ijse.smart_school.bo.custom;

import edu.ijse.smart_school.bo.SuperBO;
import edu.ijse.smart_school.dto.StudentDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {

    ArrayList<StudentDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(StudentDto studentDto) throws SQLException, ClassNotFoundException;
    ResultSet lordProfile(String id) throws SQLException, ClassNotFoundException;
    Boolean remove(String id) throws SQLException, ClassNotFoundException;
    boolean update(StudentDto studentDto) throws SQLException, ClassNotFoundException;
    String getCount() throws SQLException, ClassNotFoundException;

}
