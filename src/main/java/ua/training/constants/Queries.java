package ua.training.constants;

import java.util.ResourceBundle;

public interface Queries {
    ResourceBundle bundle = ResourceBundle.getBundle("dao");

    String USER_CREATE            = bundle.getString("query.user.create");
    String USER_FIND_BY_ID        = bundle.getString("query.user.findById");
    String USER_FIND_ALL          = bundle.getString("query.user.findAll");
    String USER_UPDATE            = bundle.getString("query.user.update");
    String USER_DELETE            = bundle.getString("query.user.delete");
    String USER_LOGIN             = bundle.getString("query.user.login");
    String USER_FIND_BY_LOGIN     = bundle.getString("query.user.findByLogin");
    String USER_GET_BALL          = bundle.getString("query.user.getBall");

    String TEST_CREATE            = bundle.getString("query.test.create");
    String TEST_FIND_BY_ID        = bundle.getString("query.test.findById");
    String TEST_FIND_BY_NAME      = bundle.getString("query.test.findByName");
    String TEST_FIND_ALL          = bundle.getString("query.test.findAll");
    String TEST_UPDATE            = bundle.getString("query.test.update");
    String TEST_DELETE            = bundle.getString("query.test.delete");

    String QUESTION_CREATE        = bundle.getString("query.question.create");
    String QUESTION_FIND_BY_ID    = bundle.getString("query.question.findById");
    String QUESTION_FIND_ALL      = bundle.getString("query.question.findAll");
    String QUESTION_UPDATE        = bundle.getString("query.question.update");
    String QUESTION_DELETE        = bundle.getString("query.question.delete");

    String ANSWER_CREATE          = bundle.getString("query.answer.create");
    String ANSWER_FIND_BY_ID      = bundle.getString("query.answer.findById");
    String ANSWER_FIND_ALL        = bundle.getString("query.answer.findAll");
    String ANSWER_UPDATE          = bundle.getString("query.answer.update");
    String ANSWER_DELETE          = bundle.getString("query.answer.delete");

    String USER_TEST_CREATE       = bundle.getString("query.user_test.create");
    String USER_TEST_FIND_BY_ID   = bundle.getString("query.user_test.findById");
    String USER_TEST_FIND_ALL     = bundle.getString("query.user_test.findAll");
    String USER_TEST_UPDATE       = bundle.getString("query.user_test.update");
    String USER_TEST_DELETE       = bundle.getString("query.user_test.delete");

    String USER_ANSWER_CREATE     = bundle.getString("query.user_answer.create");
    String USER_ANSWER_FIND_BY_ID = bundle.getString("query.user_answer.findById");
    String USER_ANSWER_FIND_ALL   = bundle.getString("query.user_answer.findAll");
    String USER_ANSWER_UPDATE     = bundle.getString("query.user_answer.update");
    String USER_ANSWER_DELETE     = bundle.getString("query.user_answer.delete");

}
