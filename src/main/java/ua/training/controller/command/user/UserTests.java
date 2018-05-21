package ua.training.controller.command.user;

import ua.training.constants.AttributeNames;
import ua.training.constants.PageNames;
import ua.training.controller.command.Command;
import ua.training.model.entity.UserTest;
import ua.training.model.service.UserTestDaoService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserTests implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        UserTestDaoService userTestService = new UserTestDaoService();
        long userid = Long.parseLong(request.getSession().getAttribute(AttributeNames.LOGGED_USER_ID).toString());
        List<UserTest> userTestList = userTestService.findByUser(userid);
        request.setAttribute(AttributeNames.ALL_TESTS_COUNT, userTestList.size());
        request.setAttribute(AttributeNames.TEST_LIST, userTestList);
        return PageNames.USER_TESTS;
    }
}