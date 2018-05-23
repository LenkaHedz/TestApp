package ua.training.controller.command.admin;

import ua.training.constants.AttributeNames;
import ua.training.constants.PageNames;
import ua.training.controller.command.Command;
import ua.training.model.entity.User;
import ua.training.model.service.UserDaoService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AllUsers implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        UserDaoService userService = new UserDaoService();
        List<User> userList = userService.findAll();
        request.setAttribute(AttributeNames.ALL_USERS_COUNT, userList.size());
        request.setAttribute(AttributeNames.USER_LIST, userList);
        return PageNames.ALL_USERS;
    }
}
