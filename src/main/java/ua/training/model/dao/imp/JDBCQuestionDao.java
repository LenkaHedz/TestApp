package ua.training.model.dao.imp;

import ua.training.model.dao.QuestionDao;
import ua.training.constants.ColumnNames;
import ua.training.constants.Queries;
import ua.training.model.entity.Question;
import ua.training.model.entity.builder.QuestionBuilder;
import ua.training.model.service.TestDaoService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCQuestionDao implements QuestionDao {

    private Connection connection;

    public JDBCQuestionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Question question) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.QUESTION_CREATE)){
            ps.setLong(1 , question.getTest().getId());
            ps.setString(2 , question.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Question findById(long id) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.QUESTION_FIND_BY_ID)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ){
                return extractFromResultSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Question extractFromResultSet(ResultSet rs) throws SQLException {
        long id     = rs.getLong(ColumnNames.QUESTION_ID);
        long idTest = rs.getLong(ColumnNames.QUESTION_ID_TEST);
        String name = rs.getString(ColumnNames.QUESTION_NAME);
        return new QuestionBuilder().setId(id).setTest(TestDaoService.findById(idTest)).setName(name).buildQuestion();
    }

    @Override
    public List<Question> findAll() {
        List<Question> resultList = new ArrayList<>();
        try (Statement ps = connection.createStatement()){
            ResultSet rs = ps.executeQuery(Queries.QUESTION_FIND_ALL);
            while ( rs.next() ){
                resultList.add(extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public void update(Question question) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.QUESTION_UPDATE)){
            ps.setLong(1 , question.getTest().getId());
            ps.setString(2 , question.getName());
            ps.setLong(3 , question.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.QUESTION_DELETE)){
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
