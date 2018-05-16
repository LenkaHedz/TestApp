package ua.training.model.entity;

import java.time.LocalDate;

public class UserTest {
    private long id;
    private User user;
    private Test test;
    private LocalDate datePass;
    private int ball;

    public UserTest() {
    }

    public UserTest(long id, User user, Test test, int ball) {
        this.id = id;
        this.user = user;
        this.test = test;
        this.datePass = LocalDate.now();
        this.ball = ball;
    }

    public UserTest(long id, User user, Test test, LocalDate datePass, int ball) {
        this.id = id;
        this.user = user;
        this.test = test;
        this.datePass = datePass;
        this.ball = ball;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public LocalDate getDatePass() {
        return datePass;
    }

    public void setDatePass(LocalDate datePass) {
        this.datePass = datePass;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    @Override
    public String toString() {
        return "UserTest{" +
                //"id=" + id +
                "user=" + user.getName() +
                ", test=" + test.getName() +
                ", datePass=" + datePass +
                ", ball=" + ball +
                '}';
    }
}
