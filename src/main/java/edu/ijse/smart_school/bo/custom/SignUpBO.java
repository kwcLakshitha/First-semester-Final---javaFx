package edu.ijse.smart_school.bo.custom;

import edu.ijse.smart_school.bo.SuperBO;
import edu.ijse.smart_school.dto.SignUpDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SignUpBO extends SuperBO {

    String log(String userName) throws SQLException, ClassNotFoundException;
    boolean save(SignUpDto Dto) throws SQLException, ClassNotFoundException;

}
