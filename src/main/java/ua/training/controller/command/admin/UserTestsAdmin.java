package ua.training.controller.command.admin;

import ua.training.constants.AttributeNames;
import ua.training.constants.PageNames;
import ua.training.controller.command.Command;
import ua.training.model.entity.User;
import ua.training.model.entity.UserTest;
import ua.training.model.service.UserTestDaoService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserTestsAdmin implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        UserTestDaoService userTestService = new UserTestDaoService();
        long userid = Long.parseLong(request.getParameter(AttributeNames.USER_ID));
        List<UserTest> userTestList = userTestService.findByUser(userid);
        request.setAttribute(AttributeNames.ALL_TESTS_COUNT, userTestList.size());
        request.setAttribute(AttributeNames.TEST_LIST, userTestList);
        return PageNames.USER_TESTS_ADMIN;
    }
}