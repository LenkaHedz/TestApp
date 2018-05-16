package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private long id;
    private Test test;
    private String name;
    private List<Answer> answers = new ArrayList<>();

    public Question() {
    }

    public Question(long id, Test test, String name) {
        this.id = id;
        this.test = test;
        this.name = name;
    }

    public Question(long id, Test test, String name, List<Answer> answers) {
        this.id = id;
        this.test = test;
        this.name = name;
        this.answers = answers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public boolean addAnswer(Answer answer){
        return(this.answers.add(answer));
    }

    @Override
    public String toString() {
        return "Question{" +
                //"id=" + id +
                "test=" + test.getName() +
                ", name='" + name + '\'' +
                '}';
    }
}
