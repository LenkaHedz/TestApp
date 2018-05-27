package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.TestDao;
import ua.training.model.entity.Test;

import java.util.List;
import java.util.Optional;

public class TestDaoService {

    private final static TestDao dao = DaoFactory.getInstance().createTestDao();

    public static void create(Test test) { dao.create(test); }

    public static Optional<Test> findById(long id) { return dao.findById(id); }

    public static List<Test> findAll() { return dao.findAll(); }

    public static List<Test> findByNum(int num) { return dao.findByNum(num); }

    public static List<Test> findByName(String name) { return dao.findByName(name); }

    public static void update(Test test) { dao.update(test); }

    public static void delete(long id) { dao.delete(id); }

    public static void close() {
        try {
            dao.close();
        } catch (Exception e)  {
            throw new RuntimeException(e);
        }
    }
}
