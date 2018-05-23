package ua.training.controller.filter;

import org.apache.log4j.Logger;
import ua.training.constants.AttributeNames;
import ua.training.constants.EncodingTypes;
import ua.training.constants.PageNames;
import ua.training.controller.command.LoginCommand;
import ua.training.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        final Logger logger = Logger.getLogger(LoginCommand.class);

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse resp = (HttpServletResponse) response;

        final User.Role userRole = (User.Role)req.getSession().getAttribute(AttributeNames.LOGGED_USER_ROLE);
        final String userLogin   = (String)req.getSession().getAttribute(AttributeNames.LOGIN);
        final String url =  req.getRequestURI();

        if (url.contains(EncodingTypes.ADMIN_PATTERN) && userRole != User.Role.ADMIN){
            resp.sendRedirect(PageNames.INDEX);
            logger.error("unauthorized access"+ userLogin + userRole);
            return;
        }
        filterChain.doFilter(req, response);
    }

    @Override
    public void destroy() {

    }
}
