package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.User;

import java.util.List;
import java.util.Optional;

public class UserDaoService {

    private final static UserDao dao = DaoFactory.getInstance().createUserDao();

    public static void create(User user) { dao.create(user); }

    public static void create(String login, String password, User.Role role, String name) { dao.create(login, password, role, name); }

    public static Optional<User> findById(long id) { return dao.findById(id); }

    public static List<User> findAll() { return dao.findAll(); }

    public static List<User> findByNum(int num) { return dao.findByNum(num); }

    public static void update(User user) { dao.update(user); }

    public static void delete(long id) { dao.delete(id); }

    public static Optional<User> login(String login, String password) { return dao.login(login, password); }

    public static boolean userExists(String login) { return dao.userExists(login); }

    public static int getUserBall(long id) { return dao.getUserBall(id); }

    public static void close() {
        try {
            dao.close();
        } catch (Exception e)  {
            throw new RuntimeException(e);
        }
    }
}
