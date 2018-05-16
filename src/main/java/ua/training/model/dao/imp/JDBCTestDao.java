package ua.training.model.dao.imp;

import ua.training.model.dao.TestDao;
import ua.training.constants.ColumnNames;
import ua.training.constants.Queries;
import ua.training.model.entity.Test;
import ua.training.model.entity.builder.TestBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTestDao implements TestDao {

    private Connection connection;

    public JDBCTestDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Test test) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.TEST_CREATE)){
            ps.setString(1 , firstUpperCase(test.getCategory().toString()));
            ps.setString(2 , test.getName());
            ps.setString(3 , test.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Test findById(long id) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.TEST_FIND_BY_ID)){
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

    private Test extractFromResultSet(ResultSet rs) throws SQLException {
        long id            = rs.getLong(ColumnNames.TEST_ID);
        String category    = rs.getString(ColumnNames.TEST_CATEGORY).toUpperCase();
        String name        = rs.getString(ColumnNames.TEST_NAME);
        String description = rs.getString(ColumnNames.TEST_DESCRIPTION);
        System.out.println(category);
        return new TestBuilder().setId(id).setCategory(Test.Category.valueOf(category))
                .setName(name).setDescription(description).buildTest();
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
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public void update(Test test) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.TEST_UPDATE)){
            ps.setString(1 , firstUpperCase(test.getCategory().toString()));
            ps.setString(2 , test.getName());
            ps.setString(3 , test.getDescription());
            ps.setLong(4 , test.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.TEST_DELETE)){
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

    private String firstUpperCase(String word){
        if(word == null || word.isEmpty()){
            return "";
        }
        return word.substring(0, 1).toUpperCase().concat(word.substring(1).toLowerCase());
    }
}
