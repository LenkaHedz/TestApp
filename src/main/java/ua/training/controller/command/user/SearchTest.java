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
        String name = request.getParameter(AttributeNames.NAME);
        TestDaoService testService = new TestDaoService();
        List<Test> testList = testService.findByName(name);
        request.setAttribute(AttributeNames.ALL_TESTS_COUNT, testList.size());
        request.setAttribute(AttributeNames.TEST_LIST, testList);
        return PageNames.TESTS_TO_GO;
    }
}