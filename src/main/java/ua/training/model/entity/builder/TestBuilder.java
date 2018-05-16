package ua.training.model.entity.builder;

import ua.training.model.entity.Test;

public class TestBuilder {
    private Test test = new Test();

    public TestBuilder() {
    }

    public TestBuilder setId(long id) {
        test.setId(id);
        return this;
    }

    public TestBuilder setCategory(Test.Category category) {
        test.setCategory(category);
        return this;
    }

    public TestBuilder setName(String name) {
        test.setName(name);
        return this;
    }

    public TestBuilder setDescription(String description) {
        test.setDescription(description);
        return this;
    }

    public Test buildTest() { return test; }
}
