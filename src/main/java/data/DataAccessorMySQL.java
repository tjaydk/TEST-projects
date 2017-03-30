package data;

import java.sql.*;

public class DataAccessorMySQL {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    public String testQuery(String query) {
        long t1 = System.currentTimeMillis();

        try {
            connection = DriverManager.getConnection(Credentials.url, Credentials.user, Credentials.password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return (System.currentTimeMillis() - t1) + " ms";
    }
}
