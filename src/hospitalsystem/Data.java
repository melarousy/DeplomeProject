/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author m.amin
 */
public class Data {

    public static ResultSet Get_Data(String Query) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            Connection con = DatabaseConnection.con();
            String sql = Query;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;

        }
    }
        
        

    public static int Save_Data(String Query) {

        try {
            Connection con = DatabaseConnection.con();
            PreparedStatement pst = null;
            pst = con.prepareStatement(Query);
            pst.execute();
            return 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 1;

        }
    }

}
