package ua.training.model.entity;

public class UserAnswer {
    private long id;
    private UserTest userTest;
    private Answer answer;

    public UserAnswer() {
    }

    public UserAnswer(long id, UserTest userTest, Answer answer) {
        this.id = id;
        this.userTest = userTest;
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserTest getUserTest() {
        return userTest;
    }

    public void setUserTest(UserTest userTest) {
        this.userTest = userTest;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "UserAnswer{" +
                //"id=" + id +
                "user=" + userTest.getUser().getName() +
                ", question=" + answer.getQuestion().getName() +
                ", answer=" + answer.getName() +
                ", ball=" + answer.getBall() +
                '}';
    }
}
