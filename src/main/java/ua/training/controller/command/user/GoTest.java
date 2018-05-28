package ua.training.controller.command.user;

import org.apache.log4j.Logger;
import ua.training.constants.AttributeNames;
import ua.training.constants.MailConstants;
import ua.training.constants.PageNames;
import ua.training.controller.command.AccessRequired;
import ua.training.controller.command.Command;
import ua.training.controller.util.DataValidator;
import ua.training.model.entity.*;
import ua.training.model.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AccessRequired(roles = {User.Role.USER})
public class GoTest implements Command {

    final static Logger logger = Logger.getLogger(GoTest.class);
    private TestDaoService testService;
    private UserTestDaoService userTestService;
    private QuestionDaoService questionService;
    private AnswerDaoService answerService;
    private UserAnswerDaoService userAnswerService;

    @Override
    public String execute(HttpServletRequest request) {
        int num = 1;
        UserTest userTest;
        long usertestid;
        long userid;
        List<Question> questionList;
        if(request.getParameter(AttributeNames.ID_TEST) != null){
            long testid = Long.parseLong(request.getParameter(AttributeNames.ID_TEST));
            userid = Long.parseLong(request.getSession().getAttribute(AttributeNames.LOGGED_USER_ID).toString());
            userTest = userTestService.createById(userid, testid).get();
            usertestid = userTest.getId();
            Test test = testService.findById(testid).get();
            questionList = questionService.findByIdTest(testid);
            request.getSession().setAttribute(AttributeNames.ID_TEST, test.getId());
            request.getSession().setAttribute(AttributeNames.TEST_NAME, test.getName());
            request.getSession().setAttribute(AttributeNames.USER_TEST_ID, usertestid);
            request.getSession().setAttribute(AttributeNames.QUESTION_LIST, questionList);
        } else if (request.getSession().getAttribute(AttributeNames.USER_TEST_ID) != null) {
            usertestid = (long) request.getSession().getAttribute(AttributeNames.USER_TEST_ID);
            num = DataValidator.recordAnswers(request, usertestid);
        } else {
            return PageNames.TESTS_TO_GO;
        }
        questionList = (List<Question>) request.getSession().getAttribute(AttributeNames.QUESTION_LIST);
        if(num == questionList.size()){
            userTest = userTestService.findById(usertestid).get();
            MailSender.send(MailConstants.THEME_NAME + userTest.getTest().getName(), MailConstants.THEME_TEXT + userTest.getBall(), userTest.getUser().getLogin());
            logger.error(MailConstants.THEME_NAME + userTest.getTest().getName());
            List<UserAnswer> userAnswerList = userAnswerService.findByUserTestId(usertestid);
            request.getSession().setAttribute(AttributeNames.ALL_BALL_COUNT, userTest.getBall());
            request.getSession().setAttribute(AttributeNames.USER_ANSWER_LIST, userAnswerList);
            return PageNames.USER_TEST_RESULT;
        }
        Question question = questionList.get(num);
        List<Answer> answerList = answerService.findByIdQuestion(question.getId());
        int correctAnswers = 0;
        for(Answer answer:answerList){
            correctAnswers = correctAnswers + answer.getBall() > 0 ? 1 : 0 ;
        }
        request.getSession().setAttribute(AttributeNames.NUM, num);
        request.getSession().setAttribute(AttributeNames.QUESTION, question);
        request.getSession().setAttribute(AttributeNames.ANSWER_LIST, answerList);
        request.getSession().setAttribute(AttributeNames.CORRECT_ANSWERS, correctAnswers);
        return PageNames.TEST_PAGE;
    }
}