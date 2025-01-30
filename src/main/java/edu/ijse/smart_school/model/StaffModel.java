package edu.ijse.smart_school.model;

import edu.ijse.smart_school.db.DBconnection;
import edu.ijse.smart_school.dto.StaffDto;
import edu.ijse.smart_school.dto.StudentDto;
import edu.ijse.smart_school.dto.TeacherDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StaffModel {
    public ArrayList<StaffDto> getAll() throws SQLException, ClassNotFoundException {

        String query = "SELECT * FROM staff";

        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<StaffDto> dto = new ArrayList<>();

        while (resultSet.next()) {

            dto.add(new StaffDto(

                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)

            ));
        }
        return dto;
    }

    public boolean save(StaffDto staffDto) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO staff VALUES(?,?,?,?,?,?,?)";

        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,staffDto.getMemberId());
        preparedStatement.setString(2,staffDto.getName());
        preparedStatement.setString(3,staffDto.getAddress());
        preparedStatement.setString(4,staffDto.getPosition());
        preparedStatement.setString(5,staffDto.getHire_date());
        preparedStatement.setString(6,staffDto.getEmail());
        preparedStatement.setString(7,staffDto.getPhone());

        int resp = preparedStatement.executeUpdate();

        return 0 < resp ;
    }

    public ResultSet lordProfile(String id) throws SQLException, ClassNotFoundException {

        System.out.println("lordProfile 1");
        System.out.println("lordProfile id : " + id);

        String query = "SELECT * FROM staff WHERE staff_id = ?";

        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,id);

        System.out.println("lordProfile 2");

        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;
    }

    public Boolean remove(String id) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM staff WHERE staff_id = ?";

        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,id);

        int i = preparedStatement.executeUpdate();

        return i > 0;
    }

    public boolean updateStaff(StaffDto staffDto) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE students SET name = ?, address = ?, position = ?, hire_date = ?, email = ?, phone = ? WHERE staff_id = ?";

        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(7,staffDto.getMemberId());
        preparedStatement.setString(1,staffDto.getName());
        preparedStatement.setString(2,staffDto.getAddress());
        preparedStatement.setString(3,staffDto.getPosition());
        preparedStatement.setString(4,staffDto.getHire_date());
        preparedStatement.setString(5,staffDto.getEmail());
        preparedStatement.setString(6,staffDto.getPhone());

        int resp = preparedStatement.executeUpdate();

        return 0 < resp ;
    }

    public String getCount() throws SQLException, ClassNotFoundException {

        String sql = "SELECT COUNT(*) AS total_staff FROM staff";

        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        String count = null;

        while (resultSet.next()) {
            count = resultSet.getString(1);
        }

        return count;
    }
}
