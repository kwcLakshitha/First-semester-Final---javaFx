package edu.ijse.smart_school.model;

import edu.ijse.smart_school.db.DBconnection;
import edu.ijse.smart_school.dto.StudentDto;
import edu.ijse.smart_school.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentModel {

    public static boolean addReport(String Sid, String rep, String s) throws SQLException, ClassNotFoundException {
        System.out.println(Sid+"  "+rep+"  "+s);
        Connection connection = null;
        boolean resulst = false;

        try {
            connection = DBconnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean rst = CrudUtil.execute("INSERT INTO student_report (report_id, student_id) VALUES (?, ?)",
                    rep,
                    Sid
            );
            if (!rst) {
                throw new SQLException();
            }
            boolean adedReport = CrudUtil.execute("INSERT INTO report_details (report_id, text) VALUES (?, ?)",
                    rep,
                    s
            );
            if (!adedReport) {
                throw new SQLException();
            }
            connection.commit();
            resulst = true;


        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback transaction on error
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            throw e;
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // Reset auto-commit
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return resulst;
    }

    public ArrayList<StudentDto> getAll() throws SQLException, ClassNotFoundException {

        String query = "SELECT * FROM students";

        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<StudentDto> dto = new ArrayList<>();

        while (resultSet.next()) {

            dto.add(new StudentDto(

                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)

            ));
        }
        return dto;
    }

    public boolean save(StudentDto studentDto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO students VALUES(?,?,?,?,?,?,?,?)";

        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, studentDto.getStudentId());
        preparedStatement.setString(2, studentDto.getName());
        preparedStatement.setString(3, studentDto.getCategory());
        preparedStatement.setString(4, studentDto.getDateOfBirth());
        preparedStatement.setString(5, studentDto.getSchool());
        preparedStatement.setString(6, studentDto.getAddress());
        preparedStatement.setString(7, studentDto.getPhone());
        preparedStatement.setString(8, studentDto.getEmail());

        int resp = preparedStatement.executeUpdate();

        return 0 < resp;
    }

    public ResultSet lordProfile(String id) throws SQLException, ClassNotFoundException {

        System.out.println("lordProfile 1");
        System.out.println("lordProfile id : " + id);

        String query = "SELECT * FROM students WHERE student_id = ?";

        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id);

        System.out.println("lordProfile 2");

        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;

    }

    public Boolean removeStudent(String id) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM students WHERE student_id = ?";

        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);

        int i = preparedStatement.executeUpdate();

        return i > 0;

    }

    public Boolean updateStudent(StudentDto studentDto) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE students SET name = ?, categary = ?, date_of_birth = ?, school = ?, address = ?, phone = ?, email = ? WHERE student_id = ?";

        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(8, studentDto.getStudentId());
        preparedStatement.setString(1, studentDto.getName());
        preparedStatement.setString(2, studentDto.getCategory());
        preparedStatement.setString(3, studentDto.getDateOfBirth());
        preparedStatement.setString(4, studentDto.getSchool());
        preparedStatement.setString(5, studentDto.getAddress());
        preparedStatement.setString(6, studentDto.getPhone());
        preparedStatement.setString(7, studentDto.getEmail());

        int resp = preparedStatement.executeUpdate();

        return 0 < resp;
    }

    public String getCount() throws SQLException, ClassNotFoundException {

        String sql = "SELECT COUNT(*) AS total_students FROM students";

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
