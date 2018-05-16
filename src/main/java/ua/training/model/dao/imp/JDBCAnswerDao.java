package ua.training.model.dao.imp;

import ua.training.model.dao.AnswerDao;
import ua.training.model.entity.Answer;
import ua.training.constants.Queries;
import ua.training.constants.ColumnNames;
import ua.training.model.entity.builder.AnswerBuilder;
import ua.training.model.service.QuestionDaoService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCAnswerDao implements AnswerDao {

    private Connection connection;

    public JDBCAnswerDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Answer answer) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.ANSWER_CREATE)){
            ps.setLong(1 , answer.getQuestion().getId());
            ps.setString(2 , answer.getName());
            ps.setInt(3 , answer.getBall());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Answer findById(long id) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.ANSWER_FIND_BY_ID)){
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

    @Override
    public List<Answer> findAll() {
        List<Answer> resultList = new ArrayList<>();
        try (Statement ps = connection.createStatement()){
            ResultSet rs = ps.executeQuery(Queries.ANSWER_FIND_ALL);
            while ( rs.next() ){
                resultList.add(extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    private Answer extractFromResultSet(ResultSet rs) throws SQLException {
        long id         = rs.getLong(ColumnNames.ANSWER_ID);
        long idQuestion = rs.getLong(ColumnNames.ANSWER_ID_QUESTION);
        String name     = rs.getString(ColumnNames.ANSWER_NAME);
        int ball        = rs.getInt(ColumnNames.ANSWER_BALL);
        return new AnswerBuilder().setId(id).setQuestion(QuestionDaoService.findById(idQuestion))
                .setName(name).setBall(ball).buildAnswer();
    }

    @Override
    public void update(Answer answer) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.ANSWER_UPDATE)){
            ps.setLong(1 , answer.getQuestion().getId());
            ps.setString(2 , answer.getName());
            ps.setLong(3 , answer.getBall());
            ps.setLong(4 , answer.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.ANSWER_DELETE)){
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
