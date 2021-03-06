package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.AnswerDao;
import ua.training.model.entity.Answer;

import java.util.List;
import java.util.Optional;

public class AnswerDaoService {

    private static final AnswerDao dao = DaoFactory.getInstance().createAnswerDao();

    public static void create(Answer answer) { dao.create(answer); }

    public static Optional<Answer> findById(long id) { return dao.findById(id); }

    public static List<Answer> findAll() { return dao.findAll(); }

    public static List<Answer> findByIdQuestion(long idquestion) { return dao.findByIdQuestion(idquestion); }

    public static void update(Answer answer){ dao.update(answer); }

    public static void delete(long id) { dao.delete(id); }

    public static void close() {
        try {
            dao.close();
        } catch (Exception e)  {
            throw new RuntimeException(e);
        }
    }
}
