package ua.training.model.dao.imp;

import org.apache.log4j.Logger;
import ua.training.model.dao.TestDao;
import ua.training.constants.ColumnNames;
import ua.training.constants.Queries;
import ua.training.model.entity.Test;
import ua.training.model.entity.builder.TestBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCTestDao implements TestDao {

    final static Logger logger = Logger.getLogger(JDBCTestDao.class);

    private Connection connection;

    public JDBCTestDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Test test) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.TEST_CREATE)){
            ps.setString(1 , test.getCategory().getDescription());
            ps.setString(2 , test.getName());
            ps.setString(3 , test.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Test> findById(long id) {
        Optional<Test> test = Optional.empty();
        try (PreparedStatement ps = connection.prepareStatement(Queries.TEST_FIND_BY_ID)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ){
                test = Optional.of(extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
        return test;
    }

    private Test extractFromResultSet(ResultSet rs) throws SQLException {
        long id            = rs.getLong(ColumnNames.TEST_ID);
        String category    = rs.getString(ColumnNames.TEST_CATEGORY).toUpperCase();
        String name        = rs.getString(ColumnNames.TEST_NAME);
        String description = rs.getString(ColumnNames.TEST_DESCRIPTION);
        return new TestBuilder().setId(id).setCategory(Test.Category.valueOf(category))
                .setName(name).setDescription(description).buildTest();
    }

    @Override
    public List<Test> findByNum(int num) {
        List<Test> resultList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(Queries.TEST_FIND_BY_NUM)){
            ps.setInt(1, num);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                resultList.add(extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public List<Test> findByName(String name) {
        List<Test> resultList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(Queries.TEST_FIND_BY_NAME)){
            ps.setString(1, '%'+name+'%');
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                resultList.add(extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public List<Test> findAll() {
        List<Test> resultList = new ArrayList<>();
        try (Statement ps = connection.createStatement()){
            ResultSet rs = ps.executeQuery(Queries.TEST_FIND_ALL);
            while ( rs.next() ){
                resultList.add(extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public void update(Test test) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.TEST_UPDATE)){
            ps.setString(1 , test.getCategory().getDescription());
            ps.setString(2 , test.getName());
            ps.setString(3 , test.getDescription());
            ps.setLong(4 , test.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Command for Admin:
     * Delete Test without autocommit
     * 1) delete users answers on test
     * 2) delete users tests
     * 3) delete tests answers
     * 4) delete tests questions
     * 5) delete test
     * Set autocommit true
     */
    @Override
    public void delete(long id) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(Queries.TEST_DELETE_USER_ANSWER);
            ps.setLong(1, id);
            ps.executeUpdate();
            ps = connection.prepareStatement(Queries.TEST_DELETE_USER_TEST);
            ps.setLong(1, id);
            ps.executeUpdate();
            ps = connection.prepareStatement(Queries.TEST_DELETE_ANSWER);
            ps.setLong(1, id);
            ps.executeUpdate();
            ps = connection.prepareStatement(Queries.TEST_DELETE_QUESTION);
            ps.setLong(1, id);
            ps.executeUpdate();
            ps = connection.prepareStatement(Queries.TEST_DELETE);
            ps.setLong(1, id);
            ps.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (Exception e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }
}
