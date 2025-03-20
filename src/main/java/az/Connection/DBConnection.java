package az.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String URL = "jdbc:mysql://localhost:3306/user";
    private static String username1 = "username";
    private static String password1= "password";
    private static Connection connection = null;

    public static Connection getConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL,username1,password1);
            System.out.println("Connection has succesfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            connection.close();
            System.out.println("Connection has closed!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
