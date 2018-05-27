package ua.training.controller.command;

import org.apache.log4j.Logger;
import ua.training.constants.AttributeNames;
import ua.training.constants.PageNames;
import ua.training.constants.ResponseMessages;
import ua.training.model.entity.User;
import ua.training.model.service.UserDaoService;
import ua.training.controller.util.DataValidator;
import ua.training.controller.util.ResourceBundleUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.Optional;

@AccessRequired(roles = {User.Role.GUEST})
public class LoginCommand implements Command {

    final static Logger logger = Logger.getLogger(LoginCommand.class);
    private UserDaoService userService;

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(AttributeNames.LOGIN);
        String password = request.getParameter(AttributeNames.PASSWORD);
        if (DataValidator.parameterIsEmptyOrNull(login, password)) {
            setErrorMessage(request, ResponseMessages.REGISTRATION_NOT_ALL_FIELDS);
            return PageNames.LOGIN;
        }

        Optional<User> user = userService.login(login, password);
        if (!user.isPresent()) {
            ResourceBundleUtil.setErrorMessage(request, ResponseMessages.LOGIN_ERROR);
            return PageNames.LOGIN;
        }

        User loggedUser = user.get();

        if(CommandUtility.checkUserIsLogged(request, login)){
            setErrorMessage(request, ResponseMessages.LOGIN_USER_IS_LOGGED);
            return PageNames.LOGIN;
        }
        request.getSession().setAttribute(AttributeNames.USER, loggedUser);
        request.getSession().setAttribute(AttributeNames.LOGGED_USER_ID, loggedUser.getId());
        request.getSession().setAttribute(AttributeNames.LOGGED_USER_LOGIN, loggedUser.getLogin().toLowerCase());
        request.getSession().setAttribute(AttributeNames.LOGGED_USER_ROLE, loggedUser.getRole());
        return DataValidator.getIndexByRole(loggedUser.getRole());
    }

    private void setErrorMessage(HttpServletRequest request, String message) {
        logger.error(message);
        Locale locale = (Locale)request.getSession().getAttribute(AttributeNames.LANGUAGE);
        request.setAttribute(AttributeNames.WRONG_INPUT_MESSAGE, ResourceBundleUtil.
                getPropertyFromLangBundle(message, locale));
    }

}

