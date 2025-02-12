package edu.ijse.smart_school.util;

import edu.ijse.smart_school.db.DBconnection;

import java.sql.*;

public class CrudUtil {

    public static <T> T execute(String sql, Object... obj) throws SQLException, ClassNotFoundException {
        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);

        for (int i = 0; i < obj.length; i++) {
            pst.setObject((i + 1), obj[i]);
        }

        if (sql.startsWith("select") || sql.startsWith("SELECT")) {
            ResultSet resultSet = pst.executeQuery();
            return (T) resultSet;
        } else {
            int i = pst.executeUpdate();

            boolean isSaved = i > 0;

            return (T) ((Boolean) isSaved);
        }
    }
    public static ResultSet executeAndReturnGeneratedKeys(String sql, Object... params) throws SQLException, ClassNotFoundException {
        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        for (int i = 0; i < params.length; i++) {
            pst.setObject(i + 1, params[i]);
        }
        pst.executeUpdate();
        return pst.getGeneratedKeys();
    }
}