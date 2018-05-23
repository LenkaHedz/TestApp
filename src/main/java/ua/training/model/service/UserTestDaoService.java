package ua.training.model.service;

import ua.training.model.dao.UserTestDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.entity.UserTest;

import java.util.List;
import java.util.Optional;

public class UserTestDaoService {

    private static final UserTestDao dao = DaoFactory.getInstance().createUserTestDao();

    public static void create(UserTest userTest) { dao.create(userTest); }

    public static Optional<UserTest> createById(long userId, long testId) { return dao.createById(userId, testId); }

    public static Optional<UserTest> findById(long id) { return dao.findById(id); }

    public static List<UserTest> findAll() { return dao.findAll(); }

    public static List<UserTest> findByUser(long iduser) { return dao.findByUser(iduser); }

    public static void update(UserTest userTest){ dao.update(userTest); }

    public static void delete(long id) { dao.delete(id); }

    public static void close() {
        try {
            dao.close();
        } catch (Exception e)  {
            throw new RuntimeException(e);
        }
    }
}
