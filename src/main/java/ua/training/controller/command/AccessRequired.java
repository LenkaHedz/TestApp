package ua.training.controller.command;

import ua.training.model.entity.User;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AccessRequired {
    User.Role[] roles();
}
