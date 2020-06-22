package DataBase;
import java.sql.*;

public class DataBaseConnection {
    private Connection connection;

    public DataBaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/homework3","PhangPhang"
            ,"PhangPhang789");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

//    public static void main(String[] args) {
//        DataBaseConnection dataBaseConnection = new DataBaseConnection();
//        System.out.println(dataBaseConnection.getConnection());
//    }

}
