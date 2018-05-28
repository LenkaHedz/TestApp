package ua.training.controller.command.user;

import ua.training.constants.AttributeNames;
import ua.training.constants.PageNames;
import ua.training.controller.command.AccessRequired;
import ua.training.controller.command.Command;
import ua.training.model.entity.Test;
import ua.training.model.entity.User;
import ua.training.model.service.TestDaoService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AccessRequired(roles = {User.Role.USER})
public class SearchTest implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        TestDaoService testService = new TestDaoService();
        String name = request.getParameter(AttributeNames.NAME);
        List<Test> testList = testService.findByName(name);
        int allListSize = testList.size();
        request.getSession().setAttribute(AttributeNames.ALL_TESTS_COUNT, allListSize);
        request.getSession().setAttribute(AttributeNames.TEST_LIST, testList);
        request.getSession().setAttribute(AttributeNames.NUMBER_OF_PAGES, 1);
        return PageNames.TESTS_TO_GO;

    }
}