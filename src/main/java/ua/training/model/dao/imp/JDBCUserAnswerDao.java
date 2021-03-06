package ua.training.model.dao.imp;

import ua.training.model.dao.UserAnswerDao;
import ua.training.constants.ColumnNames;
import ua.training.constants.Queries;
import ua.training.model.entity.Answer;
import ua.training.model.entity.UserAnswer;
import ua.training.model.entity.UserTest;
import ua.training.model.entity.builder.UserAnswerBuilder;
import ua.training.model.service.AnswerDaoService;
import ua.training.model.service.UserTestDaoService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public void createById(long userTestId, long answerId) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.USER_ANSWER_CREATE)){
            ps.setLong(1 , userTestId);
            ps.setLong(2 , answerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<UserAnswer> findById(long id) {
        Optional<UserAnswer> userAnswer = Optional.empty();
        try (PreparedStatement ps = connection.prepareStatement(Queries.USER_ANSWER_FIND_BY_ID)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ){
                userAnswer = Optional.of(extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userAnswer;
    }

    @Override
    public List<UserAnswer> findByUserTestId(long userTestId) {
        List<UserAnswer> resultList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(Queries.USER_ANSWER_FIND_BY_USER_TEST_ID)){
            ps.setLong(1, userTestId);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                resultList.add(extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
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

        return new UserAnswerBuilder().setId(id).setUserTest(UserTestDaoService.findById(idUserTest).get())
                .setAnswer(AnswerDaoService.findById(idAnswer).get()).buildUserAnswer();
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
