package ua.training.controller.command;
import ua.training.constants.AttributeNames;
import ua.training.constants.PageNames;
import ua.training.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String login = (String)request.getSession().getAttribute(AttributeNames.LOGGED_USER_LOGIN);
        @SuppressWarnings("unchecked")
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute(AttributeNames.LOGGED_USERS);
        loggedUsers.remove(login);
        request.getSession().setAttribute(AttributeNames.LOGGED_USER_ROLE, User.Role.GUEST);
        request.getSession().getServletContext().setAttribute(AttributeNames.LOGGED_USERS, loggedUsers);
        return PageNames.INDEX;
    }

}
