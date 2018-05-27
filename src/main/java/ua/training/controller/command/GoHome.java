package ua.training.controller.command;

import ua.training.constants.AttributeNames;
import ua.training.constants.PageNames;
import ua.training.controller.util.DataValidator;
import ua.training.model.entity.User;

import javax.servlet.http.HttpServletRequest;

@AccessRequired(roles = {User.Role.ADMIN, User.Role.USER, User.Role.GUEST})
public class GoHome implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        User.Role role = (User.Role) request.getSession().getAttribute(AttributeNames.LOGGED_USER_ROLE);
        if(role == null){
            role = User.Role.GUEST;
        }
        return DataValidator.getIndexByRole(role);
    }
}
