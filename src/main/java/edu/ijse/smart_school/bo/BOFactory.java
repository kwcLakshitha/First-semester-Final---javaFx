package edu.ijse.smart_school.bo;

import edu.ijse.smart_school.bo.custom.impl.SignUpBOImpl;
import edu.ijse.smart_school.bo.custom.impl.StaffBOImpl;
import edu.ijse.smart_school.bo.custom.impl.StudentBOImpl;
import edu.ijse.smart_school.bo.custom.impl.TeacherBOImpl;
import edu.ijse.smart_school.dao.CrudDAO;
import edu.ijse.smart_school.dao.custom.impl.SignUpDAOImpl;
import edu.ijse.smart_school.dao.custom.impl.StaffDAOImpl;
import edu.ijse.smart_school.dao.custom.impl.StudentDAOImpl;
import edu.ijse.smart_school.dao.custom.impl.TeacherDAOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {}

    public static BOFactory getInstance() {
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOType{
        SIGNUP,STAFF,STUDENT,TEACHER
    }

    public SuperBO getBO(BOType boType) {

        return switch (boType) {
            case SIGNUP -> new SignUpBOImpl();
            case STAFF -> new StaffBOImpl();
            case STUDENT -> new StudentBOImpl();
            case TEACHER -> new TeacherBOImpl();
            default -> null;
        };
    }
}
