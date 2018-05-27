package ua.training.controller.command;

import ua.training.constants.AttributeNames;
import ua.training.model.entity.User;

import javax.servlet.http.HttpServletRequest;

@AccessRequired(roles = {User.Role.ADMIN, User.Role.USER, User.Role.GUEST})
public class LanguageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String url = request.getHeader(AttributeNames.REFERER);
        request.getSession().setAttribute(AttributeNames.LANGUAGE,
                request.getParameter(AttributeNames.LANGUAGE));
        return url;
    }
}
