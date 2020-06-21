package DataBase;

import authentication.User;
import sun.security.util.ArrayUtil;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase extends DataBaseConnection {
    private Connection connection;

    public DataBase() {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnection();
    }

    public void addDatabase(String name, String username, String password) throws SQLException {
        String query = "INSERT INTO `homework3`.`user_table` (`name`, `username`, `password`)" +
                "VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, username);
        preparedStatement.setString(3, password);
        preparedStatement.execute();
    }

    public User createUser(String name) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM homework3.user_table WHERE name = " + name;
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            String userName = resultSet.getString("username");
            String password = resultSet.getString("password");
            return new User(name, userName, password);
        }
        return null;
    }



    public boolean checkUser(String username, String password) {
        boolean result  = false;
        try {
            String query = "SELECT * FROM user_table WHERE USERNAME = ? AND PASSWORD = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
                result = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void deleteUser(String userName){
        try {
            String query = "DELETE FROM user_table WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editNameofUser(String targetName,String editName){
        try {
            String query = "UPDATE user_table SET NAME = ? WHERE NAME = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, editName);
            preparedStatement.setString(2, targetName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUser() {
        List<User> result = new ArrayList<User>();
        try {
            String query = "SELECT * FROM user_table";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                result.add(user);
            }
            preparedStatement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
































