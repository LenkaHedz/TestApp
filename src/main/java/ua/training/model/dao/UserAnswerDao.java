package ua.training.model.dao;

import ua.training.model.entity.UserAnswer;

import java.util.List;

public interface UserAnswerDao extends GenericDao<UserAnswer>   {
    void createById(long userTestId, long answerId);
    List<UserAnswer> findByUserTestId(long userTestId);
}
