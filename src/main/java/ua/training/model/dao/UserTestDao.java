package ua.training.model.dao;

import ua.training.model.entity.UserTest;

import java.util.List;

public interface UserTestDao extends GenericDao<UserTest> {
    List<UserTest> findByUser(long iduser);
}
