package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.QuestionDao;
import ua.training.model.entity.Question;

import java.util.List;
import java.util.Optional;

public class QuestionDaoService {

    private static final QuestionDao dao = DaoFactory.getInstance().createQuestionDao();

    public static void create(Question question) { dao.create(question); }

    public static Optional<Question> findById(long id) { return dao.findById(id); }

    public static List<Question> findAll() { return dao.findAll(); }

    public static List<Question> findByIdTest(long idtest) { return dao.findByIdTest(idtest); }

    public static void update(Question question){ dao.update(question); }

    public static void delete(long id) { dao.delete(id); }

    public static void close() {
        try {
            dao.close();
        } catch (Exception e)  {
            throw new RuntimeException(e);
        }
    }
}
