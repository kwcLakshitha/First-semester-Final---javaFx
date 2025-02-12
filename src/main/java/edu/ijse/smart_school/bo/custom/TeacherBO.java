package edu.ijse.smart_school.bo.custom;

import edu.ijse.smart_school.bo.SuperBO;
import edu.ijse.smart_school.dto.TeacherDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface TeacherBO extends SuperBO {
    ArrayList<TeacherDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(TeacherDto teacherDto) throws SQLException, ClassNotFoundException;
    ResultSet lordProfile(String id) throws SQLException, ClassNotFoundException;
    Boolean remove(String id) throws SQLException, ClassNotFoundException;
    boolean update(TeacherDto teacherDto) throws SQLException, ClassNotFoundException;
    String getCount() throws SQLException, ClassNotFoundException;
}
