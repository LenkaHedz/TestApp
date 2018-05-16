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
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Servlet extends HttpServlet {
    private Map<String, Command> commands =  new ConcurrentHashMap<>();

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
        /*String path = request.getRequestURI();
        System.out.println("path:" + path);
        path = path.replaceAll(PageNames.API , PageNames.REPLACE);
        System.out.println("path:" + path);
        Command command = commands.getOrDefault(path ,
                (r)-> PageNames.INDEX);
        System.out.println("command:" + command.getClass().getName());
        String page = command.execute(request);
        System.out.println(page);
        if(page.contains(PageNames.REDIRECT)){
            response.sendRedirect(page.replace(PageNames.REDIRECT_TO, PageNames.API));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }*/
        String path = request.getRequestURI();

        path = path.replaceAll(".*/test/" , "");

        Command command = commands.getOrDefault(path,
                (r)->"/index.jsp");
        System.out.println(path);
        String page = command.execute(request);
        System.out.println(page);
        if(page.contains("redirect")){
            response.sendRedirect(page.replace("redirect:", ""));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }

    @Override
    public void destroy(){
    }
}