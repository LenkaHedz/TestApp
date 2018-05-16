package ua.training.model.dao;

import ua.training.model.dao.imp.JDBCDaoFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao();
    public abstract TestDao createTestDao();
    public abstract QuestionDao createQuestionDao();
    public abstract AnswerDao createAnswerDao();
    public abstract UserTestDao createUserTestDao();
    public abstract UserAnswerDao createUserAnswerDao();

    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    DaoFactory temp = new JDBCDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
