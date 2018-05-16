package ua.training.controller;

import ua.training.controller.command.*;
import ua.training.constants.AttributeNames;
import ua.training.constants.CommandNames;
import ua.training.constants.PageNames;
import ua.training.model.service.UserDaoService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    public void init(ServletConfig servletConfig){
        servletConfig.getServletContext().setAttribute(AttributeNames.LOGGED_USERS, new HashSet<String>());

        UserDaoService userService = new UserDaoService();

        commands.put(CommandNames.REGISTRATION, new Registration(userService));
        commands.put(CommandNames.LOGIN, new LoginCommand());
        commands.put(CommandNames.LOGOUT, new LogoutCommand());
        commands.put(CommandNames.EXCEPTION, new ExceptionCommand());
        commands.put(CommandNames.ALL_USERS, new AllUsers(userService));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        path = path.replaceAll(PageNames.API , PageNames.REPLACE);
        Command command = commands.getOrDefault(path ,
                (r)-> PageNames.INDEX);
        String page = command.execute(request);
        if(page.contains(PageNames.REDIRECT)){
            response.sendRedirect(page.replace(PageNames.REDIRECT_TO, PageNames.API));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }

    @Override
    public void destroy(){
    }
}