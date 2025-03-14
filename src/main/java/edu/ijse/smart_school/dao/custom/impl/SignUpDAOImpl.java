package edu.ijse.smart_school.dao.custom.impl;

import edu.ijse.smart_school.dao.custom.SignUpDAO;
import edu.ijse.smart_school.dao.util.CrudUtil;
import edu.ijse.smart_school.db.DBconnection;
import edu.ijse.smart_school.dto.SignUpDto;
import edu.ijse.smart_school.dto.TeacherDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SignUpDAOImpl implements SignUpDAO {

    @Override
    public boolean save(SignUpDto signUpDto) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO signUp VALUES(?,?,?)";

//        Connection connection = DBconnection.getInstance().getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//        preparedStatement.setString(1,signUpDto.getUserName());
//        preparedStatement.setString(2,signUpDto.getEmail());
//        preparedStatement.setString(3,signUpDto.getPassword());
//
//        int resp = preparedStatement.executeUpdate();

        return CrudUtil.execute(sql,signUpDto.getUserName(),signUpDto.getEmail(),signUpDto.getPassword());

    }

    @Override
    public String log(String userName) throws SQLException, ClassNotFoundException {

        String sql = "SELECT password FROM signUp WHERE user_name = ?";

//        Connection connection = DBconnection.getInstance().getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//        preparedStatement.setString(1,userName);
//        ResultSet resultSet = preparedStatement.executeQuery();

        ResultSet resultSet = CrudUtil.execute(sql,userName);

        String password = null;

        while (resultSet.next()) {

            password = resultSet.getString(1);

        }

        System.out.println("Password : "+ password);

        return password;

    }

    @Override
    public ArrayList<SignUpDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ResultSet lordProfile(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Boolean remove(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(SignUpDto Dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String getCount() throws SQLException, ClassNotFoundException {
        return "";
    }
}
