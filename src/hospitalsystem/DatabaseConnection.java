/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author m.amin
 */
public class DatabaseConnection {

    public static Connection con() {
        Connection con = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String msAccessDBName = ".\\data\\hospital.accdb";
            String dbURL = "jdbc:ucanaccess://" + msAccessDBName;            // Step 2.A: Create and get connection using DriverManager class
            con = DriverManager.getConnection(dbURL);
            //JOptionPane.showMessageDialog(null, "connected");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return con;

    }


}
