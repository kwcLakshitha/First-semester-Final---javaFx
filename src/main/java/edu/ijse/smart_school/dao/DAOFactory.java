package edu.ijse.smart_school.dao;

import edu.ijse.smart_school.dao.custom.impl.SignUpDAOImpl;
import edu.ijse.smart_school.dao.custom.impl.StaffDAOImpl;
import edu.ijse.smart_school.dao.custom.impl.StudentDAOImpl;
import edu.ijse.smart_school.dao.custom.impl.TeacherDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOType{
        SIGNUP,STAFF,STUDENT,TEACHER
    }

    public CrudDAO getDAO(DAOType daoType) {

        return switch (daoType) {
            case SIGNUP -> new SignUpDAOImpl();
            case STAFF -> new StaffDAOImpl();
            case STUDENT -> new StudentDAOImpl();
            case TEACHER -> new TeacherDAOImpl();
            default -> null;
        };
    }
}
