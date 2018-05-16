package ua.training.model.dao;

import ua.training.model.entity.Test;

import java.util.List;

public interface TestDao extends GenericDao<Test> {
    List<Test> findByName(String name);
}
