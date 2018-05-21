package ua.training.model.dao;

import ua.training.model.entity.UserTest;

import java.time.LocalDate;
import java.util.List;

public interface UserTestDao extends GenericDao<UserTest> {
    UserTest createById(long userId, long testId);
    List<UserTest> findByUser(long iduser);
}
