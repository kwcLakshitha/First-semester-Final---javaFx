package edu.ijse.smart_school.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T> {
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    boolean save(T Dto) throws SQLException, ClassNotFoundException;
    ResultSet lordProfile(String id) throws SQLException, ClassNotFoundException;
    Boolean remove(String id) throws SQLException, ClassNotFoundException;
    boolean update(T Dto) throws SQLException, ClassNotFoundException;
    String getCount() throws SQLException, ClassNotFoundException;
}
