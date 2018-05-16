package ua.training.model.entity.builder;

import ua.training.model.entity.Answer;
import ua.training.model.entity.UserAnswer;
import ua.training.model.entity.UserTest;

public class UserAnswerBuilder {
    private UserAnswer userAnswer = new UserAnswer();

    public UserAnswerBuilder() {
    }

    public UserAnswerBuilder setId(long id) {
        userAnswer.setId(id);
        return this;
    }

    public UserAnswerBuilder setUserTest(UserTest userTest) {
        userAnswer.setUserTest(userTest);
        return this;
    }

    public UserAnswerBuilder setAnswer(Answer answer) {
        userAnswer.setAnswer(answer);
        return this;
    }

    public UserAnswer buildUserAnswer() { return userAnswer; }
}
