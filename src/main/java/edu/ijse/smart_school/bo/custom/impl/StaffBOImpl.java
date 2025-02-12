package edu.ijse.smart_school.bo.custom.impl;

import edu.ijse.smart_school.bo.custom.StaffBO;
import edu.ijse.smart_school.dao.DAOFactory;
import edu.ijse.smart_school.dao.custom.StaffDAO;
import edu.ijse.smart_school.dao.custom.impl.StaffDAOImpl;
import edu.ijse.smart_school.dto.StaffDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StaffBOImpl implements StaffBO {

    StaffDAO staffDAO = (StaffDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STAFF);

    @Override
    public ArrayList<StaffDto> getAll() throws SQLException, ClassNotFoundException {
        return staffDAO.getAll();
    }

    @Override
    public boolean save(StaffDto staffDto) throws SQLException, ClassNotFoundException {
        return staffDAO.save(staffDto);
    }

    @Override
    public ResultSet lordProfile(String id) throws SQLException, ClassNotFoundException {
        return staffDAO.lordProfile(id);
    }

    @Override
    public Boolean remove(String id) throws SQLException, ClassNotFoundException {
        return staffDAO.remove(id);
    }

    @Override
    public boolean update(StaffDto staffDto) throws SQLException, ClassNotFoundException {
        return staffDAO.update(staffDto);
    }

    @Override
    public String getCount() throws SQLException, ClassNotFoundException {
        return staffDAO.getCount();
    }
}
