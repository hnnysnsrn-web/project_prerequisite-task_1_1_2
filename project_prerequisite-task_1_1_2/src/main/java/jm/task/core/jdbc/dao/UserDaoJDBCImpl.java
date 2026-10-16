package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXiSTS users(" +
                     "id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                     "name VARCHAR(30), " +
                     "lastName VARCHAR(100) NOT NULL, " +
                     "age TINYINT)";

        try (Connection connection = Util.getConnection();
            Statement stat = connection.createStatement()) {
            stat.executeUpdate(sql);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";

        try (Connection connection = Util.getConnection();
            Statement stat = connection.createStatement()) {
            stat.executeUpdate(sql);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String  sql = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";

        try (Connection connection = Util.getConnection();
            PreparedStatement preparedstat = connection.prepareStatement(sql)) {
            preparedstat.setString(1, name);
            preparedstat.setString(2, lastName);
            preparedstat.setByte(3, age);
            preparedstat.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection connection = Util.getConnection();
            PreparedStatement preparedstat = connection.prepareStatement(sql)) {
            preparedstat.setLong(1, id);
            preparedstat.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT id, name, lastName, age FROM users";

        try (Connection connection = Util.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  users;
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE TABLE users";

        try (Connection connection = Util.getConnection();
             Statement stat = connection.createStatement()) {
            stat.executeUpdate(sql);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
