package ua.training.model.dao;

import ua.training.model.entity.Answer;

import java.util.List;

public interface AnswerDao extends GenericDao<Answer> {
    List<Answer> findByIdQuestion(long idquestion);
}
