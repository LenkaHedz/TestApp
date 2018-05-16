package ua.training.model.dao.imp;

import ua.training.model.dao.UserAnswerDao;
import ua.training.constants.ColumnNames;
import ua.training.constants.Queries;
import ua.training.model.entity.UserAnswer;
import ua.training.model.entity.builder.UserAnswerBuilder;
import ua.training.model.service.AnswerDaoService;
import ua.training.model.service.UserTestDaoService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUserAnswerDao implements UserAnswerDao {

    private Connection connection;

    public JDBCUserAnswerDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(UserAnswer userAnswer) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.USER_ANSWER_CREATE)){
            ps.setLong(1 , userAnswer.getUserTest().getId());
            ps.setLong(2 , userAnswer.getAnswer().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserAnswer findById(long id) {

        try (PreparedStatement ps = connection.prepareStatement(Queries.USER_ANSWER_FIND_BY_ID)){
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
    public List<UserAnswer> findAll() {
        List<UserAnswer> resultList = new ArrayList<>();
        try (Statement ps = connection.createStatement()){
            ResultSet rs = ps.executeQuery(Queries.USER_ANSWER_FIND_ALL);
            while ( rs.next() ){
                resultList.add(extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    private UserAnswer extractFromResultSet(ResultSet rs) throws SQLException {
        long id         = rs.getLong(ColumnNames.USER_ANSWER_ID);
        long idUserTest = rs.getLong(ColumnNames.USER_ANSWER_ID_USER_TEST);
        long idAnswer   = rs.getLong(ColumnNames.USER_ANSWER_ID_ANSWER);

        return new UserAnswerBuilder().setId(id).setUserTest(UserTestDaoService.findById(idUserTest))
                .setAnswer(AnswerDaoService.findById(idAnswer)).buildUserAnswer();
    }

    @Override
    public void update(UserAnswer userAnswer) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.USER_ANSWER_UPDATE)){
            ps.setLong(1 , userAnswer.getUserTest().getId());
            ps.setLong(2 , userAnswer.getAnswer().getId());
            ps.setLong(3 , userAnswer.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.USER_ANSWER_DELETE)){
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
