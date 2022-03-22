/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author m.amin
 */
public  class Login {
    public static boolean login (String username,String password){
        Connection connection = DatabaseConnection.con();
        Statement statement = null;
        ResultSet rs = null;
        boolean login = false;

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery("select USER_NAME ,USER_PASS FROM LOGIN where USER_NAME='"+ username+"' and USER_PASS='"+password+"' ");
            if (rs.next()){
                
                login=true;                

            }
            else {
                login=false; 
            }

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } finally {

            // Step 3: Closing database connection
            try {
                if (null != connection) {

                    // cleanup resources, once after processing
                    rs.close();
                    statement.close();

                    // and then finally close connection
                    connection.close();
                }
            } catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }        
        return login;
    }
    
    
}
