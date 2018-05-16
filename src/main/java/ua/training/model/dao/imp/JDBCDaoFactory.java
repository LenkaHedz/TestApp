package ua.training.model.dao.imp;

import ua.training.model.dao.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    @Override
    public TestDao createTestDao() {
        return new JDBCTestDao(getConnection());
    }

    @Override
    public QuestionDao createQuestionDao()  {
        return new JDBCQuestionDao(getConnection());
    }

    @Override
    public AnswerDao createAnswerDao()   {
        return new JDBCAnswerDao(getConnection());
    }

    @Override
    public UserTestDao createUserTestDao()  {
        return new JDBCUserTestDao(getConnection());
    }

    @Override
    public UserAnswerDao createUserAnswerDao()  {
        return new JDBCUserAnswerDao(getConnection());
    }

    private Connection getConnection(){
        try {
            DBProperties prop = new DBProperties();
            return DriverManager.getConnection(
                    prop.getUrl(),
                    prop.getUser(),
                    prop.getPassword() );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
