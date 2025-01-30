package edu.ijse.smart_school.model;

import edu.ijse.smart_school.db.DBconnection;
import edu.ijse.smart_school.dto.SignUpDto;
import edu.ijse.smart_school.dto.StaffDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpModel {
    public boolean save(SignUpDto signUpDto) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO signUp VALUES(?,?,?)";

        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,signUpDto.getUserName());
        preparedStatement.setString(2,signUpDto.getEmail());
        preparedStatement.setString(3,signUpDto.getPassword());

        int resp = preparedStatement.executeUpdate();

        return 0 < resp ;

    }

    public String log(String userName) throws SQLException, ClassNotFoundException {

        String sql = "SELECT password FROM signUp WHERE user_name = ?";

        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,userName);
        ResultSet resultSet = preparedStatement.executeQuery();

        String password = null;

        while (resultSet.next()) {

            password = resultSet.getString(1);

        }

        System.out.println("Password : "+ password);

        return password;

    }
}
