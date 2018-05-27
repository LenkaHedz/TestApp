package ua.training.controller.command;

import ua.training.constants.AttributeNames;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

public class CommandUtility {
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
