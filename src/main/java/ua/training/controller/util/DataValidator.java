package ua.training.controller.util;

import org.apache.log4j.Logger;
import ua.training.constants.AttributeNames;
import ua.training.constants.PageNames;
import ua.training.controller.Servlet;
import ua.training.controller.command.AccessRequired;
import ua.training.controller.command.Command;
import ua.training.controller.command.LoginCommand;
import ua.training.model.entity.User;
import ua.training.model.service.UserAnswerDaoService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class DataValidator {

    public static boolean parameterIsEmptyOrNull(String ... parameters) {
        for (String parameter: parameters ) {
            if (parameter == null || parameter.equals("")) {
                return true;
            }
        }
        return false;
    }

    public static boolean passwordsAreEquals(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public static String getIndexByRole(User.Role role) {
        if(role == User.Role.ADMIN) {
            return PageNames.ADMIN_INDEX;
        }
        if(role == User.Role.USER) {
            return PageNames.USER_INDEX;
        }
        return PageNames.INDEX;
    }

}
