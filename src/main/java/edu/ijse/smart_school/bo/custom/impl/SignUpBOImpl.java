package edu.ijse.smart_school.bo.custom.impl;

import edu.ijse.smart_school.bo.custom.SignUpBO;
import edu.ijse.smart_school.dao.DAOFactory;
import edu.ijse.smart_school.dao.custom.SignUpDAO;
import edu.ijse.smart_school.dto.SignUpDto;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SignUpBOImpl implements SignUpBO {

    SignUpDAO signUpDAO = (SignUpDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.SIGNUP);

    @Override
    public String log(String userName) throws SQLException, ClassNotFoundException {
        return signUpDAO.log(userName);
    }

    @Override
    public boolean save(SignUpDto Dto) throws SQLException, ClassNotFoundException {
        return signUpDAO.save(Dto);
    }
}
