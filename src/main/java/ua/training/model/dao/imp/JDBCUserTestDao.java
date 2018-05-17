package ua.training.model.dao.imp;

import ua.training.model.dao.UserTestDao;
import ua.training.constants.ColumnNames;
import ua.training.constants.Queries;
import ua.training.model.entity.UserTest;
import ua.training.model.entity.builder.UserTestBuilder;
import ua.training.model.service.TestDaoService;
import ua.training.model.service.UserDaoService;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCUserTestDao implements UserTestDao {

    private Connection connection;

    public JDBCUserTestDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(UserTest userTest) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.USER_TEST_CREATE)){
            ps.setLong(1 , userTest.getUser().getId());
            ps.setLong(2 , userTest.getTest().getId());
            ps.setDate(3 , Date.valueOf(userTest.getDatePass()));
            ps.setInt(4 , userTest.getBall());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserTest findById(long id) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.USER_TEST_FIND_BY_ID)){
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
    public List<UserTest> findAll() {
        List<UserTest> resultList = new ArrayList<>();
        try (Statement ps = connection.createStatement()){
            ResultSet rs = ps.executeQuery(Queries.USER_TEST_FIND_ALL);
            while ( rs.next() ){
                resultList.add(extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    private UserTest extractFromResultSet(ResultSet rs) throws SQLException {
        long id            = rs.getLong(ColumnNames.USER_TEST_ID);
        long idUser        = rs.getLong(ColumnNames.USER_TEST_ID_USER);
        long idTest        = rs.getLong(ColumnNames.USER_TEST_ID_TEST);
        LocalDate datePass = rs.getDate(ColumnNames.USER_TEST_DATE_PASS).toLocalDate();
        int ball           = rs.getInt(ColumnNames.USER_TEST_BALL);

        return new UserTestBuilder().setId(id).setUser(UserDaoService.findById(idUser))
                .setTest(TestDaoService.findById(idTest)).setDatePass(datePass).setBall(ball).buildUserTest();
    }

    @Override
    public List<UserTest> findByUser(long iduser) {
        List<UserTest> resultList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(Queries.USER_TEST_FIND_BY_USER_ID)){
            ps.setLong(1, iduser);
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
    public void update(UserTest userTest){
        try (PreparedStatement ps = connection.prepareStatement(Queries.USER_TEST_UPDATE)){
        ps.setLong(1 , userTest.getUser().getId());
        ps.setLong(2 , userTest.getTest().getId());
        ps.setDate(3 , Date.valueOf(userTest.getDatePass()));
        ps.setInt(4 , userTest.getBall());
        ps.setLong(5 , userTest.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

    @Override
    public void delete(long id) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.USER_TEST_DELETE)){
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
