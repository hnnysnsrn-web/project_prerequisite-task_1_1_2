package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // set up a database connection
    private static final String URL = "jdbc:mysql://localhost:3306/DBI_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
