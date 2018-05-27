package ua.training.controller.command.admin;

import ua.training.constants.AttributeNames;
import ua.training.constants.PageNames;
import ua.training.controller.command.AccessRequired;
import ua.training.controller.command.Command;
import ua.training.model.entity.Test;
import ua.training.model.entity.User;
import ua.training.model.service.TestDaoService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AccessRequired(roles = {User.Role.ADMIN})
public class AllTests implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        TestDaoService testService = new TestDaoService();
        int numPage = request.getParameter(AttributeNames.PAGE) == null ? 1 : Integer.parseInt(request.getParameter(AttributeNames.PAGE));
        int num = numPage * AttributeNames.NUM_ROWS - AttributeNames.NUM_ROWS;
        List<Test> testList = testService.findByNum(num);
        int allListSize = testService.findAll().size();
        int numberOfPages = (int)Math.ceil((double) allListSize / AttributeNames.NUM_ROWS);
        request.getSession().setAttribute(AttributeNames.ALL_TESTS_COUNT, allListSize);
        request.getSession().setAttribute(AttributeNames.TEST_LIST, testList);
        request.getSession().setAttribute(AttributeNames.NUMBER_OF_PAGES, numberOfPages);
        return PageNames.ALL_TESTS;
    }
}
