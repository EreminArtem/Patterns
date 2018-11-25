package lesson6;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapper {
    public static final String USER_ID = "id";
    public static final String USER_TABLE_NAME = "user_table";
    public static final String NAME_COLUMN = "user_name";
    public static final String LASTNAME_COLUMN = "user_lastname";
    public static final String POSITION_COLUMN = "user_position";


    private Connection connection;
    private PreparedStatement statement;
    private static Mapper ourInstance = new Mapper();

    public static Mapper getInstance() {
        return ourInstance;
    }

    private Mapper() {
        connect();
    }

    private void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:db.db");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createNewUser(final User user) {
        try {
            statement = connection.prepareStatement("INSERT INTO " + USER_TABLE_NAME + "(" +
                    NAME_COLUMN + ", " +
                    LASTNAME_COLUMN + ", " +
                    POSITION_COLUMN + ") " +
                    "VALUES (?,?,?);");
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getPosition());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public User getUser(final int id) throws SQLException {
        statement = connection.prepareStatement("SELECT " + "*" + " FROM " +
                USER_TABLE_NAME + " WHERE (" +
                USER_ID + " = '" + id + "' );");
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        if (resultSet != null && !resultSet.isClosed()) {
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
                return user;
            }
        }
        return null;
    }

    public Map<Integer, User> findAll() throws SQLException {
        Map<Integer, User> userList = new HashMap<>();
        statement = connection.prepareStatement("SELECT " + "*" + " FROM " +
                USER_TABLE_NAME + ";");
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        if (resultSet != null && !resultSet.isClosed()) {
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
                userList.put(resultSet.getInt(1), user);
            }
        }
        return userList;
    }
}
