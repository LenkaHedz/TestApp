package ua.training.model.entity;

public class Question {
    private long id;
    private Test test;
    private String name;

    public Question() {
    }

    public Question(long id, Test test, String name) {
        this.id = id;
        this.test = test;
        this.name = name;
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

    @Override
    public String toString() {
        return "Question{" +
                //"id=" + id +
                "test=" + test.getName() +
                ", name='" + name + '\'' +
                '}';
    }
}
