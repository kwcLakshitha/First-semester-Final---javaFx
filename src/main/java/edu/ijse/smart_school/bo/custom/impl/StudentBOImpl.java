package edu.ijse.smart_school.bo.custom.impl;

import edu.ijse.smart_school.bo.custom.StudentBO;
import edu.ijse.smart_school.dao.DAOFactory;
import edu.ijse.smart_school.dao.custom.StudentDAO;
import edu.ijse.smart_school.dto.StudentDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENT);

    @Override
    public ArrayList<StudentDto> getAll() throws SQLException, ClassNotFoundException {
        return studentDAO.getAll();
    }

    @Override
    public boolean save(StudentDto studentDto) throws SQLException, ClassNotFoundException {
        return studentDAO.save(studentDto);
    }

    @Override
    public ResultSet lordProfile(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.lordProfile(id);
    }

    @Override
    public Boolean remove(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.remove(id);
    }

    @Override
    public boolean update(StudentDto studentDto) throws SQLException, ClassNotFoundException {
        return studentDAO.update(studentDto);
    }

    @Override
    public String getCount() throws SQLException, ClassNotFoundException {
        return studentDAO.getCount();
    }
}
