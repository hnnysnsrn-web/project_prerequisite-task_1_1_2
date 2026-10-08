package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE users(" +
                     "id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
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
        String sql = "DROP TABLE users";

        try (Connection connection = Util.getConnectio();
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
            preparedStat.setLong(1, id);
            preparedStat.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        return null;
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
