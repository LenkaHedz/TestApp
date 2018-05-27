package ua.training.controller.command.user;

import ua.training.constants.AttributeNames;
import ua.training.constants.PageNames;
import ua.training.controller.command.AccessRequired;
import ua.training.controller.command.Command;
import ua.training.model.entity.User;
import ua.training.model.entity.UserTest;
import ua.training.model.service.UserTestDaoService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AccessRequired(roles = {User.Role.USER})
public class UserTests implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        UserTestDaoService userTestService = new UserTestDaoService();
        long userid = Long.parseLong(request.getSession().getAttribute(AttributeNames.LOGGED_USER_ID).toString());
        int numPage = request.getParameter(AttributeNames.PAGE) == null ? 1 : Integer.parseInt(request.getParameter(AttributeNames.PAGE));
        int num = numPage * AttributeNames.NUM_ROWS - AttributeNames.NUM_ROWS;
        List<UserTest> userTestList = userTestService.findByUserNum(userid, num);
        int allListSize = userTestService.findByUser(userid).size();
        int numberOfPages = (int)Math.ceil((double) allListSize / AttributeNames.NUM_ROWS);
        request.getSession().setAttribute(AttributeNames.ALL_TESTS_COUNT, allListSize);
        request.getSession().setAttribute(AttributeNames.TEST_LIST, userTestList);
        request.getSession().setAttribute(AttributeNames.NUMBER_OF_PAGES, numberOfPages);
        return PageNames.USER_TESTS;
    }

}