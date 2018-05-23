package ua.training.controller.command.user;

import org.apache.log4j.Logger;
import ua.training.constants.AttributeNames;
import ua.training.constants.MailConstants;
import ua.training.constants.PageNames;
import ua.training.controller.command.Command;
import ua.training.model.entity.*;
import ua.training.model.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoTest implements Command {

    final static Logger logger = Logger.getLogger(GoTest.class);
    private TestDaoService testService;
    private UserTestDaoService userTestService;
    private QuestionDaoService questionService;
    private AnswerDaoService answerService;
    private UserAnswerDaoService userAnswerService;

    @Override
    public String execute(HttpServletRequest request) {
        if(request.getParameter(AttributeNames.ID_TEST) == null){
            List<Test> testList = testService.findAll();
            request.setAttribute(AttributeNames.ALL_TESTS_COUNT, testList.size());
            request.setAttribute(AttributeNames.TEST_LIST, testList);
            return PageNames.TESTS_TO_GO;
        }
        int num = Integer.parseInt(request.getParameter(AttributeNames.NUM));
        long testid = Long.parseLong(request.getParameter(AttributeNames.ID_TEST));
        Test test = testService.findById(testid).get();
        UserTest userTest;
        long usertestid;
        if(num == 0){
            long userid = Long.parseLong(request.getSession().getAttribute(AttributeNames.LOGGED_USER_ID).toString());
            userTest = userTestService.createById(userid, testid).get();
            usertestid = userTest.getId();
        } else {
            usertestid = Long.parseLong(request.getParameter(AttributeNames.USER_TEST_ID));
            userTest = userTestService.findById(usertestid).get();
            String[] answeridList = request.getParameterValues(AttributeNames.ANSWER_ID);
            for (String answerid: answeridList) {
                userAnswerService.createById(usertestid, Long.parseLong(answerid));
            }
        }
        List<Question> questionList = questionService.findByIdTest(testid);
        if(num == questionList.size()){
            MailSender.send(MailConstants.THEME_NAME + userTest.getTest().getName(), MailConstants.THEME_TEXT + userTest.getBall(), userTest.getUser().getLogin());
            logger.error(MailConstants.THEME_NAME + userTest.getTest().getName());
            List<UserAnswer> userAnswerList = userAnswerService.findByUserTestId(usertestid);
            request.setAttribute(AttributeNames.TEST_NAME, test.getName());
            request.setAttribute(AttributeNames.ALL_BALL_COUNT, userTest.getBall());
            request.setAttribute(AttributeNames.USER_ANSWER_LIST, userAnswerList);
            return PageNames.USER_TEST_RESULT;
        }
        Question question = questionList.get(num);
        List<Answer> answerList = answerService.findByIdQuestion(question.getId());
        request.setAttribute(AttributeNames.NUM, num+1);
        request.setAttribute(AttributeNames.ID_TEST, test.getId());
        request.setAttribute(AttributeNames.TEST_NAME, test.getName());
        request.setAttribute(AttributeNames.USER_TEST_ID, usertestid);
        request.setAttribute(AttributeNames.QUESTION_LIST, questionList);
        request.setAttribute(AttributeNames.QUESTION, question);
        request.setAttribute(AttributeNames.ANSWER_LIST, answerList);
        return PageNames.TEST_PAGE;
    }
}