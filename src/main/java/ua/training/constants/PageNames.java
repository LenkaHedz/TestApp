package ua.training.constants;

public interface PageNames {
    String API            = ".*/test/";
    String REPLACE        = "";
    String INDEX          = "/index.jsp";
    String REDIRECT       = "redirect";
    String REDIRECT_TO    = "redirect:";

    String REDIRECT_INDEX = "redirect:/test/index.jsp";

    String ERROR       = "/error.jsp";

    String LOGIN          = "/login.jsp";
    String REGISTRATION   = "/registration.jsp";

    String USER_INDEX     = "/WEB-INF/user/userindex.jsp";
    String ADMIN_INDEX    = "/admin/menu";

    String ALL_USERS   = "/WEB-INF/admin/allusers.jsp";
    String ALL_TESTS   = "/WEB-INF/admin/alltests.jsp";

    String TESTS_TO_GO = "/WEB-INF/user/teststogo.jsp";
    String TEST_PAGE   = "/WEB-INF/user/testpage.jsp";

    String USER_TESTS  = "/WEB-INF/user/usertests.jsp";
    String TEST_RESULT = "/WEB-INF/user/testresult.jsp";
}
