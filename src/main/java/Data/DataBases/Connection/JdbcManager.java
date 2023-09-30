package Data.DataBases.Connection;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcManager {

    public static String resultSetToString(ResultSet resultSet) throws SQLException {
        StringBuilder stringBuilder = new StringBuilder();

        int columnCount = resultSet.getMetaData().getColumnCount();

        if (!(resultSet.next())) throw new RuntimeException("No data found in the resultSet.");

        do {
            for (int i = 1; i < columnCount; i++)
                stringBuilder.append(resultSet.getString(i)).append(" ");

            stringBuilder.append(resultSet.getString(columnCount)).append("\n");
        } while (resultSet.next());

        resultSet.close();

        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();//to remove last "\n"
    }

    public final java.sql.Connection connection;
    public final Statement statement;

    public JdbcManager(String propertiesFilePath) {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propertiesFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read Properties File.\n", e);
        }

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(properties.getProperty("db.connectionUrl"));
            statement = connection.createStatement();
        } catch (Exception e) {
            throw new RuntimeException("Failed to connect to the database.\n", e);
        }
    }

    public void close() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error closing the database.\n", e);
        }
    }

    public JdbcManager setAutoCommit(boolean bool) throws SQLException {
        connection.setAutoCommit(bool);
        return this;
    }

    public JdbcManager rollback() throws SQLException {
        connection.rollback();
        return this;
    }

    public JdbcManager commit() throws SQLException {
        connection.commit();
        return this;
    }

    public ResultSet executeQuery(String query) {
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL query.\n", e);
        }
    }

    public int executeUpdate(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL query.\n", e);
        }
    }

    public String queryToString(String query) throws SQLException {
        return resultSetToString(statement.executeQuery(query));
    }


}
