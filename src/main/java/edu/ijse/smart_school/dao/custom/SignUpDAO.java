package edu.ijse.smart_school.dao.custom;

import edu.ijse.smart_school.dao.CrudDAO;
import edu.ijse.smart_school.dto.SignUpDto;

import java.sql.SQLException;

public interface SignUpDAO extends CrudDAO<SignUpDto> {
    String log(String userName) throws SQLException, ClassNotFoundException;
}
