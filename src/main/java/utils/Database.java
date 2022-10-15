package utils;
import utils.ConfigProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;


    public Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }
        try {
            connection = DriverManager
                    .getConnection(ConfigProperties.getProperty("db_url"),
                                    ConfigProperties.getProperty("db_username"),
                                    ConfigProperties.getProperty("db_password"));
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        return connection;
    }

    public void createTestingTable(){
        try(
            Statement stmt = connection.createStatement();
        ) {
            String table_name = ConfigProperties.getProperty("table_name");
            String keys_table_name = ConfigProperties.getProperty("keys_table_name");
            String sql = String.format("""
                    CREATE TABLE IF NOT EXISTS %s (
                        name VARCHAR(255),
                        date TIMESTAMP,
                        status VARCHAR(30)
                    );
                 
                    """, table_name);
            String sql2 = String.format("""
                    CREATE TABLE IF NOT EXISTS %s (
                                            key TEXT,
                                            VALUE TEXT
                                        );
                    """,keys_table_name);
            System.out.println(sql);
            stmt.executeUpdate(sql);
            System.out.println(sql2);
            stmt.executeUpdate(sql2);
            System.out.println("Created table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeQuery(String query) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
          }
    }

    public static List<String> getColumnNames(String query) {
        executeQuery(query);
        List<String> columns = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++){
                columns.add(rsmd.getColumnName(i));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return columns;
    }

    public static List<Map<String, Object>> getQueryResultMap(String query) {
        executeQuery(query);
        List<Map<String, Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> colNameValueMap = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    colNameValueMap.put(rsmd.getColumnName(i), resultSet.getObject(i));
                }
                rowList.add(colNameValueMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowList;
    }

    public static List<List<Object>> getQueryResultList(String query) {
        executeQuery(query);
        List<List<Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try{
            rsmd = resultSet.getMetaData();
            while (resultSet.next()){
                List<Object> row = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++){
                    row.add(resultSet.getObject(i));
                }
                rowList.add(row);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return rowList;
    }

    public static List<Object> getColumnData(String query, String column) {
        executeQuery(query);
        List<Object> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                rowList.add(resultSet.getObject(column));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rowList;
    }

    public static void destroy() {
        try{
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
