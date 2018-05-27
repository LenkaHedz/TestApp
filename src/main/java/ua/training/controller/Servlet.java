package ua.training.controller;

import ua.training.constants.PageNames;
import ua.training.controller.command.*;
import ua.training.constants.AttributeNames;
import ua.training.constants.CommandNames;
import ua.training.controller.command.admin.AllTests;
import ua.training.controller.command.admin.AllUsers;
import ua.training.controller.command.admin.TestResults;
import ua.training.controller.command.admin.AllUserTests;
import ua.training.controller.command.user.SearchTest;
import ua.training.controller.command.user.GoTest;
import ua.training.controller.command.user.SendToMail;
import ua.training.controller.command.user.TestsToGo;
import ua.training.controller.command.user.UserTests;
import ua.training.controller.util.DataValidator;
import ua.training.model.entity.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Servlet extends HttpServlet {
    private final Map<String, Command> commands =  new ConcurrentHashMap<>();

    public void init(ServletConfig servletConfig){
        servletConfig.getServletContext().setAttribute(AttributeNames.LOGGED_USERS, new HashSet<String>());
        commands.put(CommandNames.REGISTRATION, new Registration());
        commands.put(CommandNames.LOGIN, new LoginCommand());
        commands.put(CommandNames.LOGOUT, new LogoutCommand());
        commands.put(CommandNames.EXCEPTION, new ExceptionCommand());
        commands.put(CommandNames.GO_HOME, new GoHome());

        commands.put(CommandNames.USER_TESTS, new UserTests());
        commands.put(CommandNames.TESTS_TO_GO, new TestsToGo());
        commands.put(CommandNames.SEARCH_TEST, new SearchTest());
        commands.put(CommandNames.GO_TEST, new GoTest());
        commands.put(CommandNames.SEND_TO_MAIL, new SendToMail());

        commands.put(CommandNames.ALL_USERS, new AllUsers());
        commands.put(CommandNames.ALL_TESTS, new AllTests());
        commands.put(CommandNames.ALL_USER_TESTS, new AllUserTests());
        commands.put(CommandNames.TESTS_RESULTS, new TestResults());
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
        String path = request.getRequestURI().replaceAll(PageNames.API , PageNames.REPLACE);
        Command command = commands.getOrDefault(path, (r)-> PageNames.REDIRECT_TO + PageNames.INDEX);
        User.Role role = (User.Role) request.getSession().getAttribute(AttributeNames.LOGGED_USER_ROLE);
        if(role == null){
            role = User.Role.GUEST;
        }
        String page;
        if(isAccessAllowed(command, role) ){
            page = command.execute(request);
        } else {
            page = DataValidator.getIndexByRole(role);
        }
        if(page.contains(PageNames.REDIRECT)){
            response.sendRedirect(page.replace(PageNames.REDIRECT_TO, PageNames.REPLACE));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }

    public static boolean isAccessAllowed(Command command, User.Role role) {
        Class<?> commandClass = command.getClass();
        AccessRequired accessRequired = commandClass.getAnnotation(AccessRequired.class);
        return Objects.nonNull(accessRequired) &&
                Arrays.asList(accessRequired.roles()).contains(role);
    }

    @Override
    public void destroy(){
    }
}