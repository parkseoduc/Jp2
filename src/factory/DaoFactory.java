package factory;

import dao.RepositoryDAO;
import dao.ResultDAOImpl;
import dao.StudentDAOImpl;
import dao.SubjectDAOImpl;

public class DaoFactory {
    public static RepositoryDAO getDAO(String type){
        if(type.equalsIgnoreCase( "student")){
            return new StudentDAOImpl();
        }else if(type.equalsIgnoreCase( "subject")){
            return new SubjectDAOImpl();
        }else if(type.equalsIgnoreCase( "result")){
             return new ResultDAOImpl();
        }
        throw new IllegalArgumentException("No DAO found");
    }
}

