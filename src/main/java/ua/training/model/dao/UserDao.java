package ua.training.model.dao;

import ua.training.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends GenericDao<User>{
    void create(String login, String password, User.Role role, String name);
    Optional<User> login(String username, String password);
    boolean userExists(String username);
    int getUserBall(long id);
    List<User> findByNum(int num);
}
