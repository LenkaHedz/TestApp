package ua.training.controller.command;
import ua.training.constants.AttributeNames;
import ua.training.constants.PageNames;
import ua.training.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        //HttpSession session = request.getSession();
        //session.removeAttribute(AttributeNames.USER);
        CommandUtility.setUserRole(request, User.Role.GUEST, AttributeNames.GUEST);
        return "redirect:/index.jsp"; /*PageNames.INDEX;*/
    }

}
