package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserAnswerDao;
import ua.training.model.entity.UserAnswer;

import java.util.List;
import java.util.Optional;

public class UserAnswerDaoService {

    private static final UserAnswerDao dao = DaoFactory.getInstance().createUserAnswerDao();

    public static void create(UserAnswer userAnswer) { dao.create(userAnswer); }

    public static void createById(long userTestId, long answerId) { dao.createById(userTestId, answerId); }

    public static Optional<UserAnswer> findById(long id) { return dao.findById(id); }

    public static List<UserAnswer> findAll() { return dao.findAll(); }

    public static List<UserAnswer> findByUserTestId(long userTestId) { return dao.findByUserTestId(userTestId); }

    public static void update(UserAnswer userAnswer){ dao.update(userAnswer); }

    public static void delete(long id) { dao.delete(id); }

    public static void close() {
        try {
            dao.close();
        } catch (Exception e)  {
            throw new RuntimeException(e);
        }
    }
}
