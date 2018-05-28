package ua.training.controller.command.admin;

import ua.training.constants.AttributeNames;
import ua.training.constants.PageNames;
import ua.training.controller.command.AccessRequired;
import ua.training.controller.command.Command;
import ua.training.model.entity.User;
import ua.training.model.entity.UserAnswer;
import ua.training.model.service.UserAnswerDaoService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AccessRequired(roles = {User.Role.ADMIN})
public class Results implements Command {
    private UserAnswerDaoService userAnswerService;

    @Override
    public String execute(HttpServletRequest request) {
        long usertestid;
        String testName;
        int allBallCount;
        if(request.getParameter(AttributeNames.USER_TEST_ID) != null){
            usertestid = Long.parseLong(request.getParameter(AttributeNames.USER_TEST_ID));
            testName = request.getParameter(AttributeNames.TEST_NAME);
            allBallCount = Integer.parseInt(request.getParameter(AttributeNames.ALL_BALL_COUNT));
        } else if (request.getSession().getAttribute(AttributeNames.USER_TEST_ID) != null) {
            usertestid = (long) request.getSession().getAttribute(AttributeNames.USER_TEST_ID);
            testName = request.getSession().getAttribute(AttributeNames.TEST_NAME).toString();
            allBallCount = (int) request.getSession().getAttribute(AttributeNames.ALL_BALL_COUNT);
        } else {
            return PageNames.ALL_USER_TESTS;
        }
        List<UserAnswer> userAnswerList = userAnswerService.findByUserTestId(usertestid);
        request.getSession().setAttribute(AttributeNames.USER_TEST_ID, usertestid);
        request.getSession().setAttribute(AttributeNames.TEST_NAME, testName);
        request.getSession().setAttribute(AttributeNames.ALL_BALL_COUNT, allBallCount);
        request.getSession().setAttribute(AttributeNames.USER_ANSWER_LIST, userAnswerList);
        return PageNames.ADMIN_RESULTS;
    }
}
