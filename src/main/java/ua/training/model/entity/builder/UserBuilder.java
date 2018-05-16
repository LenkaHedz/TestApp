package ua.training.model.entity.builder;

import ua.training.model.entity.User;

public class UserBuilder {
    private User user = new User();

    public UserBuilder() {
    }

    public UserBuilder setId(long id) {
        user.setId(id);
        return this;
    }

    public UserBuilder setLogin(String login) {
        user.setLogin(login);
        return this;
    }

    public UserBuilder setPassword(String password) {
        user.setPassword(password);
        return this;
    }

    public UserBuilder setRole(User.Role role) {
        user.setRole(role);
        return this;
    }

    public UserBuilder setName(String name) {
        user.setName(name);
        return this;
    }

    public UserBuilder setBall(int ball) {
        user.setBall(ball);
        return this;
    }

    public User buildUser() { return user; }
}
