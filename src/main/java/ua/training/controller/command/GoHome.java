package ua.training.controller.command;

import ua.training.constants.AttributeNames;
import ua.training.constants.PageNames;
import ua.training.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public class GoHome implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String userRole = request.getSession().getAttribute(AttributeNames.ROLE).toString();
        if(userRole.equals(User.Role.ADMIN)) {
            return PageNames.ADMIN_INDEX;
        }
        if(userRole.equals(User.Role.USER)) {
            return PageNames.USER_INDEX;
        }
        return PageNames.INDEX;
    }
}
