package edu.ijse.smart_school.bo.custom.impl;

import edu.ijse.smart_school.bo.custom.TeacherBO;
import edu.ijse.smart_school.dao.DAOFactory;
import edu.ijse.smart_school.dao.custom.TeacherDAO;
import edu.ijse.smart_school.dto.TeacherDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherBOImpl implements TeacherBO {

    TeacherDAO teacherDAO = (TeacherDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.TEACHER);

    @Override
    public ArrayList<TeacherDto> getAll() throws SQLException, ClassNotFoundException {
        return teacherDAO.getAll();
    }

    @Override
    public boolean save(TeacherDto teacherDto) throws SQLException, ClassNotFoundException {
        return teacherDAO.save(teacherDto);
    }

    @Override
    public ResultSet lordProfile(String id) throws SQLException, ClassNotFoundException {
        return teacherDAO.lordProfile(id);
    }

    @Override
    public Boolean remove(String id) throws SQLException, ClassNotFoundException {
        return teacherDAO.remove(id);
    }

    @Override
    public boolean update(TeacherDto teacherDto) throws SQLException, ClassNotFoundException {
        return teacherDAO.update(teacherDto);
    }

    @Override
    public String getCount() throws SQLException, ClassNotFoundException {
        return teacherDAO.getCount();
    }
}
