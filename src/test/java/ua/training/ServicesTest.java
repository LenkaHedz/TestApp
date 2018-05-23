package ua.training;

import org.junit.*;
import ua.training.model.entity.User;
import ua.training.model.service.MailSender;
import ua.training.model.service.UserDaoService;

public class ServicesTest {

    @Test
    public void testLogin(){
        UserDaoService userService = new UserDaoService();
        String login = "ivanov@test.ua";
        String password = "23456";
        User user = userService.login(login, password);
        Assert.assertNotNull(user.getId());
        userService.delete(user.getId());
    }

    @Test
    public void testMailSender(){
        MailSender.send("Test TESTS", "Hello! I`m testing", "test@gmail.com");
    }

}
