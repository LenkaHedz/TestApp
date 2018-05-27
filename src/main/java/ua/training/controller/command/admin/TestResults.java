package ua.training.controller.command.admin;

import ua.training.constants.AttributeNames;
import ua.training.constants.PageNames;
import ua.training.controller.command.AccessRequired;
import ua.training.controller.command.Command;
import ua.training.model.entity.User;

import javax.servlet.http.HttpServletRequest;

@AccessRequired(roles = {User.Role.ADMIN})
public class TestResults implements Command {

   /* private TestDaoService testService;
    private UserTestDaoService userTestService;
    private QuestionDaoService questionService;
    private AnswerDaoService answerService;
    private UserAnswerDaoService userAnswerService;*/

    @Override
    public String execute(HttpServletRequest request) {
        /*usertestid = Long.parseLong(request.getParameter(AttributeNames.USER_TEST_ID));
        List<Question> questionList = questionService.findByIdTest(testid);
        List<UserAnswer> userAnswerList = userAnswerService.findByUserTestId(usertestid);
        request.setAttribute(AttributeNames.TEST_NAME, test.getName());
        request.setAttribute(AttributeNames.ALL_BALL_COUNT, userTest.getBall());
        request.setAttribute(AttributeNames.USER_ANSWER_LIST, userAnswerList);*/
        return PageNames.USER_TEST_RESULT;
    }
}
