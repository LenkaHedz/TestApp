package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private long id;
    private Category category;
    private String name;
    private String description;
    private List<Question> questions = new ArrayList<>();

    public Test() {
    }

    public Test(long id, Category category, String name, String description) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
    }

    public Test(long id, Category category, String name, String description, List<Question> questions) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
        this.questions = questions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public boolean addQuestion(Question question){
        return(this.questions.add(question));
    }

    @Override
    public String toString() {
        return "Test{" +
                //"id=" + id +
                "category=" + category +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public enum Category {
        BIOLOGY, PROGRAMMING, MATHEMATICS;
    }
}
