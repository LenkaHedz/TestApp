package ua.training.controller.command;

import ua.training.constants.AttributeNames;
import ua.training.model.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

public class CommandUtility {
    static void setUserRole(HttpServletRequest request, User.Role role, String login) {
        HttpSession session = request.getSession();
        ServletContext context = session.getServletContext();
        context.setAttribute(AttributeNames.LOGIN, login);
        session.setAttribute(AttributeNames.ROLE, role);
    }

    static boolean checkUserIsLogged(HttpServletRequest request, String login){
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute(AttributeNames.LOGGED_USERS);
        if(loggedUsers.stream().anyMatch(login::equals)){
            return true;
        }
        loggedUsers.add(login);
        request.getSession().getServletContext()
                .setAttribute(AttributeNames.LOGGED_USERS, loggedUsers);
        return false;
    }
}
