package ua.training.model.dao;

import ua.training.model.entity.UserTest;

import java.util.List;
import java.util.Optional;

public interface UserTestDao extends GenericDao<UserTest> {
    Optional<UserTest> createById(long userId, long testId);
    List<UserTest> findByUser(long iduser);
    List<UserTest> findByUserNum(long iduser, int num);
}
