package ua.training.model.entity.builder;

import ua.training.model.entity.Question;
import ua.training.model.entity.Test;

public class QuestionBuilder {
    private Question question = new Question();

    public QuestionBuilder() {
    }

    public QuestionBuilder setId(long id) {
        question.setId(id);
        return this;
    }

    public QuestionBuilder setTest(Test test) {
        question.setTest(test);
        return this;
    }

    public QuestionBuilder setName(String name) {
        question.setName(name);
        return this;
    }

    public Question buildQuestion() { return question; }
}
