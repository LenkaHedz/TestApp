package ua.training.model.entity;

public class Test {
    private long id;
    private Category category;
    private String name;
    private String description;

    public Test() {
    }

    public Test(long id, Category category, String name, String description) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
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
        BIOLOGY("Biology"),
        PROGRAMMING("Programming"),
        MATHEMATICS("Mathematics");

        private String description;

        private Category(String description) {
            this.description = description;
        }

        public String getDescription() {return description;}
    }
}
