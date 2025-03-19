/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package register.dal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;
/**
 *
 * @author nemesis
 */
public class DAO {
    public static int register(UserDTO user) throws SQLException {
        int result = -1;
        
        DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/register", "root", "root");
        
        PreparedStatement statement = connection.prepareStatement("Insert into UserTable values (?, ?)");
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        
        
        result = statement.executeUpdate();
        statement.close();
        connection.close();
        
        System.out.println("Registration Successful");

        return result;
    }
    
    public static boolean login(UserDTO user) throws SQLException {
        boolean result = false;
        
        DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());                
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/register", "root", "root");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM USERTABLE WHERE USERNAME=? AND PASSWORD=?");
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        ResultSet set = statement.executeQuery();
        
        if (set.next()) {
            result = true;
        }
        
        statement.close();
        connection.close();
                    
        return result;
    }
}
