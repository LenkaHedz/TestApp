package ua.training.model.dao;

import ua.training.model.entity.User;

public interface UserDao extends GenericDao<User>{
    void create(String login, String password, User.Role role, String name);
    User login(String username, String password);
    boolean userExists(String username);
}
