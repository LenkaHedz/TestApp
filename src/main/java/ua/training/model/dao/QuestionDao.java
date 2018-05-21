package ua.training.model.dao;

import ua.training.model.entity.Question;

import java.util.List;

public interface QuestionDao extends GenericDao<Question> {
    List<Question> findByIdTest(long idtest);
}
