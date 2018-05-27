package ua.training.controller.command.user;

import org.apache.log4j.Logger;
import ua.training.constants.AttributeNames;
import ua.training.constants.MailConstants;
import ua.training.constants.PageNames;
import ua.training.controller.command.AccessRequired;
import ua.training.controller.command.Command;
import ua.training.model.entity.User;
import ua.training.model.entity.UserTest;
import ua.training.model.service.MailSender;
import ua.training.model.service.UserTestDaoService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@AccessRequired(roles = {User.Role.USER})
public class SendToMail implements Command {

    final static Logger logger = Logger.getLogger(SendToMail.class);
    private UserTestDaoService userTestService;

    @Override
    public String execute(HttpServletRequest request) {
        List<UserTest> userTestList = userTestService.findByUser(Long.parseLong(request.getSession().getAttribute(AttributeNames.LOGGED_USER_ID).toString()));
        request.setAttribute(AttributeNames.ALL_TESTS_COUNT, userTestList.size());
        request.setAttribute(AttributeNames.TEST_LIST, userTestList);
        if(request.getParameter(AttributeNames.USER_TEST_ID) == null){
            return PageNames.USER_TESTS;
        }
        Optional<UserTest> userTestOpt = userTestService.findById(Long.parseLong(request.getParameter(AttributeNames.USER_TEST_ID)));
        if (!userTestOpt.isPresent()) {
            logger.error(MailConstants.ERROR_DATA);
            return PageNames.USER_TESTS;
        }
        UserTest userTest = userTestOpt.get();
        MailSender.send(MailConstants.THEME_NAME + userTest.getTest().getName(), MailConstants.THEME_TEXT + userTest.getBall(), userTest.getUser().getLogin());
        logger.error(MailConstants.THEME_NAME + userTest.getTest().getName());
        return PageNames.USER_TESTS;
    }


}
