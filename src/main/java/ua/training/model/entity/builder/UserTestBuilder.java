package ua.training.model.entity.builder;

import ua.training.model.entity.Test;
import ua.training.model.entity.User;
import ua.training.model.entity.UserTest;

import java.time.LocalDate;

public class UserTestBuilder {

    private UserTest userTest = new UserTest();

    public UserTestBuilder() {
    }

    public UserTestBuilder setId(long id) {
        userTest.setId(id);
        return this;
    }

    public UserTestBuilder setUser(User user) {
        userTest.setUser(user);
        return this;
    }

    public UserTestBuilder setTest(Test test) {
        userTest.setTest(test);
        return this;
    }

    public UserTestBuilder setDatePass(LocalDate datePass) {
        userTest.setDatePass(datePass);
        return this;
    }

    public UserTestBuilder setBall(int ball) {
        userTest.setBall(ball);
        return this;
    }

    public UserTest buildUserTest() {
        return userTest;
    }
}