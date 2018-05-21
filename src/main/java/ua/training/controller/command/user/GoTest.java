package ua.training.controller.command.user;

import ua.training.constants.AttributeNames;
import ua.training.constants.PageNames;
import ua.training.controller.command.Command;
import ua.training.model.entity.Answer;
import ua.training.model.entity.Question;
import ua.training.model.entity.Test;
import ua.training.model.entity.UserTest;
import ua.training.model.service.AnswerDaoService;
import ua.training.model.service.QuestionDaoService;
import ua.training.model.service.TestDaoService;
import ua.training.model.service.UserTestDaoService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoTest implements Command {

    private TestDaoService testService;
    private UserTestDaoService userTestService;
    private QuestionDaoService questionService;
    private AnswerDaoService answerService;

    @Override
    public String execute(HttpServletRequest request) {
        if(request.getParameter(AttributeNames.ID_TEST) == null){
            return PageNames.TESTS_TO_GO;
        }
        int num = Integer.parseInt(request.getParameter(AttributeNames.NUM));
        long idtest = Long.parseLong(request.getParameter(AttributeNames.ID_TEST));
        Test test = testService.findById(idtest);
        if(num == 0){
            long userid = Long.parseLong(request.getSession().getAttribute(AttributeNames.LOGGED_USER_ID).toString());
            UserTest userTest = userTestService.createById(userid, idtest);
        }
        Question question = questionService.findByIdTest(idtest).get(num);
        List<Answer> answerList = answerService.findByIdQuestion(question.getId());
        request.setAttribute(AttributeNames.NUM, num+1);
        request.setAttribute("test", test);
        request.setAttribute("question", question);
        request.setAttribute("answerList", answerList);
        return PageNames.TEST_PAGE;
    }
}