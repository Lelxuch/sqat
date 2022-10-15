package utils;


import java.sql.*;
import java.time.LocalTime;

public class DatabaseWriter {
    //language=SQL
    private static final String INSERT_DATA = "INSERT INTO TestCase(status,time,testName) values (?,?,?);";

    private final Database db;

    public DatabaseWriter(Database db) {
        this.db = db;
    }


    public void writeResult(String expected, String actual, String testName, boolean pass) {
        try (Connection connection = db.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_DATA, Statement.RETURN_GENERATED_KEYS)) {

            if (!pass) {
                statement.setString(1, "Skip Requested");
            } else {
                if (expected.equals(actual)) {
                    statement.setString(1, "Pass");
                } else {
                    statement.setString(1, "Fail");
                }
            }
            statement.setTime(2, Time.valueOf(LocalTime.now()));
            statement.setString(3, testName);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }

    }
}