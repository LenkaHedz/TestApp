package ua.training.model.entity;

import ua.training.model.service.UserDaoService;

import java.util.Objects;

public class User {
    private long id;
    private String login;
    private String password;
    private Role role;
    private String name;
    private int ball;

    public User() {
    }

    public User(long id, String login, String password, Role role, String name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.name = name;
        this.ball = this.calcBall(id);
    }

    public User(long id, String login, String password, Role role, String name, int ball) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.name = name;
        this.ball = ball;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.ball = this.calcBall(id);
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public boolean isAdmin() {return role == Role.ADMIN; }

    public int calcBall(long id) {
        return UserDaoService.getUserBall(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
               Objects.equals(password, user.password) &&
               role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                //"id=" + id +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public enum Role {
        USER, ADMIN, GUEST;
    }
}
