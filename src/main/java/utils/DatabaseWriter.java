package utils;


import java.sql.*;
import java.time.LocalTime;

public class DatabaseWriter {
    //language=SQL
    private static final String INSERT_DATA = "INSERT INTO TestCase(status,date,name) values (?,?,?);";

    private final Database db;

    public DatabaseWriter(Database db) {
        this.db = db;
    }


    public void writeResult( String testName, boolean status) {
        try (Connection connection = db.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_DATA, Statement.RETURN_GENERATED_KEYS)) {

            if (!status) {
                statement.setString(1, "Fail");

            } else {
                statement.setString(1, "Pass");
            }
            statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            statement.setString(3, testName);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }

    }
}