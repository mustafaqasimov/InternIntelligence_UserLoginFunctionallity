package az.Processing;

import az.Connection.DBConnection;
import az.Security_Utils.Security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Process {
    private static ResultSet resultSet = null;
    private static PreparedStatement preparedStatement = null;

    public static boolean register(String username, String password){
        String hashedpassword = Security.hashedpassword(password);
        String query = "INSERT INTO userdb (username , passwords) VALUES(?,?)";

        try (Connection connect = DBConnection.getConnect()){
            preparedStatement = connect.prepareStatement(query);

            preparedStatement.setString(1,username);
            preparedStatement.setString(2,hashedpassword);
            preparedStatement.executeUpdate();
            System.out.println("User has registered! ");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean login(String username, String password){
        String hashedpassword = Security.hashedpassword(password);
        String query = "SELECT * FROM userdb WHERE username = ? AND passwords = ?";

        Connection connect = DBConnection.getConnect();
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,hashedpassword);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                System.out.println("Login succesfull!");
                return true;
            }else{
                System.out.println("Username or password is incorrect!");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void logout(){
        System.out.println("User logout succesfull");
    }
}
