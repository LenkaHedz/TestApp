package ua.training.model.entity;

public class Answer {
    private long id;
    private Question question;
    private String name;
    private int ball;

    public Answer() {
    }

    public Answer(long id, Question question, String name, int ball) {
        this.id = id;
        this.question = question;
        this.name = name;
        this.ball = ball;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    @Override
    public String toString() {
        return "Answer{" +
                //"id=" + id +
                "question=" + question.getName() +
                ", name='" + name + '\'' +
                ", ball=" + ball +
                '}';
    }
}
