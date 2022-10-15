package utils;

import org.postgresql.jdbc.FieldMetadata;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

public class DatabaseReader {

    //language=SQL
    private static final String SQL_SELECT_BY_KEY = "SELECT * FROM keys where key = ?;";

    private final Database db;

    public DatabaseReader(Database db) {
        this.db = db;
    }

//    private static final Function<ResultSet, Key> keyRowMapper = row -> {
//        try {
//            return Key.builder()
//                    .id(row.getLong("id"))
//                    .key(row.getString("key"))
//                    .value(row.getString("value"))
//                    .build();
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        }
//    };

    public String readParam(String key) {
        try (Connection connection = db.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_KEY)) {

            statement.setString(1, key);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String value = resultSet.getString("value");
                    System.out.println(value);
                    return (value);
//                    return keyRowMapper.apply(resultSet).getValue();
                } else {
                    return null;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }

    }
}
