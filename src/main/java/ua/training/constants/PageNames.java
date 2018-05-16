package ua.training.constants;

public interface PageNames {
    String API            = ".*/test";
    String REPLACE        = "";
    String INDEX          = "index.jsp";
    String REDIRECT       = "redirect";
    String REDIRECT_TO    = "redirect:";
    String REDIRECT_INDEX = "redirect:/test/index.jsp";

    String ERROR       = "/error.jsp";

    String LOGIN          = "/login.jsp";
    String REGISTRATION   = "/registration.jsp";

    String USER_MENU            = "/WEB-INF/user/user-menu.jsp";
    String ADMIN_MENU           = "/WEB-INF/admin/admin-menu.jsp";

    String REDIRECT_USER_MENU   = "redirect:/WEB-INF/user/user-menu.jsp";
    String REDIRECT_ADMIN_MENU  = "redirect:/WEB-INF/admin/admin-menu.jsp";

    String ALL_USERS   = "/WEB-INF/admin/allusers.jsp";
    String ALL_TESTS   = "/WEB-INF/admin/alltests.jsp";

    String TESTS_TO_GO = "/WEB-INF/user/teststogo.jsp";
}
