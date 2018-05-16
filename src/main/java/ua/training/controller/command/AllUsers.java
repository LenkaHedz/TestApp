package ua.training.controller.command;

import ua.training.constants.AttributeNames;
import ua.training.model.entity.User;
import ua.training.model.service.UserDaoService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AllUsers implements Command {

    private UserDaoService userService;

    public AllUsers(UserDaoService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        System.out.println("users go-go-go");

        List<User> userList = userService.findAll();
        request.setAttribute(AttributeNames.LOGGED_USERS_COUNT, userList.size());
        request.setAttribute("userList", userList);
        return "/WEB-INF/admin/allusers.jsp";
    }
}
