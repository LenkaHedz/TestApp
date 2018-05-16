package ua.training.controller.command;

import ua.training.constants.AttributeNames;
import ua.training.constants.PageNames;
import ua.training.constants.ResponseMessages;
import ua.training.model.entity.User;
import ua.training.model.service.UserDaoService;
import ua.training.controller.util.DataValidator;
import ua.training.controller.util.ResourceBundleUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class LoginCommand implements Command {

    private UserDaoService userService;

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(AttributeNames.LOGIN);
        String password = request.getParameter(AttributeNames.PASSWORD);

        if (DataValidator.parameterIsEmptyOrNull(login, password)) {
            setErrorMessage(request, ResponseMessages.REGISTRATION_NOT_ALL_FIELDS);
            return PageNames.LOGIN;
        }

        User user = userService.login(login, password);

        if(CommandUtility.checkUserIsLogged(request, login)){
            setErrorMessage(request, ResponseMessages.LOGIN_USER_IS_LOGGED);
            return PageNames.LOGIN;
        }
        request.getSession().setAttribute(AttributeNames.USER, user);
        request.getSession().setAttribute(AttributeNames.LOGGED_USER_ID, user.getId());
        request.getSession().setAttribute(AttributeNames.LOGGED_USER_LOGIN, user.getLogin().toLowerCase());
        request.getSession().setAttribute(AttributeNames.LOGGED_USER_ROLE, user.getRole());
        return getPageByRole(user.getRole());
    }

    private String getPageByRole(User.Role userRole) {
        return userRole == User.Role.ADMIN ? PageNames.ADMIN_MENU : PageNames.USER_MENU;
    }

    private void setErrorMessage(HttpServletRequest request, String message) {
        Locale locale = (Locale)request.getSession().getAttribute(AttributeNames.LANGUAGE);

        request.setAttribute(AttributeNames.WRONG_INPUT_MESSAGE, ResourceBundleUtil.
                getPropertyFromLangBundle(message, locale));
    }

}

