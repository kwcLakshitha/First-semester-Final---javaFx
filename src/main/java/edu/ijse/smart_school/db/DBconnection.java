package edu.ijse.smart_school.db;

import java.sql.*;

public class DBconnection {

    private Connection connection;
    private static DBconnection dBConnection;

    private DBconnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartSchool", "root", "Ijse@1234");
    }

    public static DBconnection getInstance() throws ClassNotFoundException, SQLException {
        if (dBConnection == null) {
            dBConnection = new DBconnection();
        }
        return dBConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}