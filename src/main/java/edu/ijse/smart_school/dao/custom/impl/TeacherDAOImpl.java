package edu.ijse.smart_school.dao.custom.impl;

import edu.ijse.smart_school.dao.custom.TeacherDAO;
import edu.ijse.smart_school.dao.util.CrudUtil;
import edu.ijse.smart_school.db.DBconnection;
import edu.ijse.smart_school.dto.TeacherDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDAOImpl implements TeacherDAO {

    @Override
    public ArrayList<TeacherDto> getAll() throws SQLException, ClassNotFoundException {

        String query = "SELECT * FROM teachers";

//        Connection connection = DBconnection.getInstance().getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = CrudUtil.execute(query);

        ArrayList<TeacherDto> dto = new ArrayList<>();

        while (resultSet.next()) {

            dto.add(new TeacherDto(

                    resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8)));
        }
        return dto;
    }

    @Override
    public boolean save(TeacherDto teacherDto) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO teachers VALUES(?,?,?,?,?,?,?,?)";

//        Connection connection = DBconnection.getInstance().getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1,teacherDto.getTeacher_id());
//        preparedStatement.setString(2,teacherDto.getName());
//        preparedStatement.setString(3,teacherDto.getAddress());
//        preparedStatement.setString(4,teacherDto.getNic());
//        preparedStatement.setString(5,teacherDto.getCategary());
//        preparedStatement.setString(6,teacherDto.getHire_date());
//        preparedStatement.setString(7,teacherDto.getEmail());
//        preparedStatement.setString(8,teacherDto.getPhone());
//
//        int resp = preparedStatement.executeUpdate();

        return CrudUtil.execute(sql, teacherDto.getTeacher_id(), teacherDto.getName(), teacherDto.getAddress(), teacherDto.getNic(), teacherDto.getCategary(), teacherDto.getHire_date(), teacherDto.getEmail(), teacherDto.getPhone());
    }

    @Override
    public ResultSet lordProfile(String id) throws SQLException, ClassNotFoundException {

        System.out.println("lordProfile 1");
        System.out.println("lordProfile id : " + id);

        String query = "SELECT * FROM teachers WHERE teacher_id = ?";

//        Connection connection = DBconnection.getInstance().getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setString(1,id);

        System.out.println("lordProfile 2");

        ResultSet resultSet = CrudUtil.execute(query, id);


        return resultSet;
    }

    @Override
    public Boolean remove(String id) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM teachers WHERE teacher_id = ?";

//        Connection connection = DBconnection.getInstance().getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1,id);
//
//        int i = preparedStatement.executeUpdate();

        return CrudUtil.execute(sql, id);
    }

    @Override
    public boolean update(TeacherDto teacherDto) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE teachers SET name = ?, address = ?, nic = ?, categary = ?, hire_date = ?, email = ?, phone = ? WHERE teacher_id = ?";

//        Connection connection = DBconnection.getInstance().getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(8,teacherDto.getTeacher_id());
//        preparedStatement.setString(1,teacherDto.getName());
//        preparedStatement.setString(2,teacherDto.getAddress());
//        preparedStatement.setString(3,teacherDto.getNic());
//        preparedStatement.setString(4,teacherDto.getCategary());
//        preparedStatement.setString(5,teacherDto.getHire_date());
//        preparedStatement.setString(6,teacherDto.getEmail());
//        preparedStatement.setString(7,teacherDto.getPhone());
//
//        int resp = preparedStatement.executeUpdate();

//        return 0 < resp ;

        return CrudUtil.execute(sql, teacherDto.getName(), teacherDto.getAddress(), teacherDto.getNic(),
                teacherDto.getCategary(), teacherDto.getHire_date(), teacherDto.getEmail(), teacherDto.getPhone(),
                teacherDto.getTeacher_id());
    }

    @Override
    public String getCount() throws SQLException, ClassNotFoundException {

        String sql = "SELECT COUNT(*) AS total_teachers FROM teachers";

//        Connection connection = DBconnection.getInstance().getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
          ResultSet resultSet = CrudUtil.execute(sql);

        String count = null;

        while (resultSet.next()) {
            count = resultSet.getString(1);
        }

        return count;
    }
}
