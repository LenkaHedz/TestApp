package ua.training;

import org.junit.*;
import ua.training.controller.command.LogoutCommand;
import ua.training.model.entity.User;
import ua.training.model.service.MailSender;
import ua.training.model.service.TestDaoService;
import ua.training.model.service.UserDaoService;

import java.util.Optional;

public class ServicesTest {

    @Test
    public void testLogin(){
        UserDaoService userService = new UserDaoService();
        String login = "ivanov@test.ua";
        String password = "23456";
        Optional<User> userOptional = userService.login(login, password);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            Assert.assertNotNull(user.getId());
            userService.delete(user.getId());
        }
    }

    @Test
    public void testMailSender(){
        MailSender.send("Test TESTS", "Hello! I`m testing", "test@gmail.com");
    }

    @Test
    public void testDeteleWithAutocommit(){
        TestDaoService testDao = new TestDaoService();
        testDao.delete(1);
    }

}
