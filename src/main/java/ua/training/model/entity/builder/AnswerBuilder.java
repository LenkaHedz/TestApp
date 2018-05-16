package ua.training.model.entity.builder;

import ua.training.model.entity.Answer;
import ua.training.model.entity.Question;

public class AnswerBuilder {
    private Answer answer = new Answer();

    public AnswerBuilder() {
    }

    public AnswerBuilder setId(long id) {
        answer.setId(id);
        return this;
    }

    public AnswerBuilder setQuestion(Question question) {
        answer.setQuestion(question);
        return this;
    }

    public AnswerBuilder setName(String name) {
        answer.setName(name);
        return this;
    }

    public AnswerBuilder setBall(int ball) {
        answer.setBall(ball);
        return this;
    }

    public Answer buildAnswer() { return answer; }
}
