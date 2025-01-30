package edu.ijse.smart_school.dto.tm;

import edu.ijse.smart_school.db.DBconnection;
import edu.ijse.smart_school.util.CrudUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class TeacherTm {

    private String id;
    private String name;
    private String categary;

    public TeacherTm(String id, String name, String categary) {
        this.id = id;
        this.name = name;
        this.categary = categary;
    }

    public TeacherTm(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static boolean addReport(String teacherId, String repoId, String repo) throws SQLException {

        System.out.println(teacherId+"  "+repoId+"  "+repo);
        Connection connection = null;
        boolean resulst = false;

        try {
            connection = DBconnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean rst = CrudUtil.execute("INSERT INTO teacher_report (report_id, teacher_id) VALUES (?, ?)",
                    repoId,
                    teacherId
            );
            if (!rst) {
                throw new SQLException();
            }
            boolean adedReport = CrudUtil.execute("INSERT INTO teacher_report_details (report_id, text) VALUES (?, ?)",
                    repoId,
                    repo
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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategary() {
        return categary;
    }

    public void setCategary(String categary) {
        this.categary = categary;
    }
}
