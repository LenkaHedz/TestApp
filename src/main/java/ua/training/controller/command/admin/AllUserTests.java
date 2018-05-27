package ua.training.controller.command.admin;

import ua.training.constants.AttributeNames;
import ua.training.constants.PageNames;
import ua.training.controller.command.AccessRequired;
import ua.training.controller.command.Command;
import ua.training.model.entity.User;
import ua.training.model.entity.UserTest;
import ua.training.model.service.UserDaoService;
import ua.training.model.service.UserTestDaoService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@AccessRequired(roles = {User.Role.ADMIN})
public class AllUserTests implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        UserDaoService userDaoService = new UserDaoService();
        UserTestDaoService userTestService = new UserTestDaoService();
        User user;
        if(request.getParameter(AttributeNames.USER_ID) != null){
            user = userDaoService.findById(Long.parseLong(request.getParameter(AttributeNames.USER_ID))).get();
            request.getSession().setAttribute(AttributeNames.ACTIVE_USER, user);
        } else if (request.getSession().getAttribute(AttributeNames.ACTIVE_USER) != null) {
            user = (User) request.getSession().getAttribute(AttributeNames.ACTIVE_USER);
        } else {
            return PageNames.ALL_USERS;
        }
        int numPage = request.getParameter(AttributeNames.PAGE) == null ? 1 : Integer.parseInt(request.getParameter(AttributeNames.PAGE));
        int num = numPage * AttributeNames.NUM_ROWS - AttributeNames.NUM_ROWS;
        List<UserTest> userTestList = userTestService.findByUserNum(user.getId(), num);
        int allListSize = userTestService.findByUser(user.getId()).size();
        int numberOfPages = (int)Math.ceil((double) allListSize / AttributeNames.NUM_ROWS);
        request.getSession().setAttribute(AttributeNames.ALL_TESTS_COUNT, allListSize);
        request.getSession().setAttribute(AttributeNames.TEST_LIST, userTestList);
        request.getSession().setAttribute(AttributeNames.NUMBER_OF_PAGES, numberOfPages);
        return PageNames.ALL_USER_TESTS;
    }
}