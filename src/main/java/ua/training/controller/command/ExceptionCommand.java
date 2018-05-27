package ua.training.controller.command;

import ua.training.model.entity.User;

import javax.servlet.http.HttpServletRequest;

@AccessRequired(roles = {User.Role.ADMIN, User.Role.USER, User.Role.GUEST})
public class ExceptionCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        throw new RuntimeException("Generated exception");
    }
}
