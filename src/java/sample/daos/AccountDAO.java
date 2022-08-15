/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sample.dtos.Account;
import sample.dtos.Category;
import sample.utils.DBUtils;

/**
 *
 * @author 2
 */
public class AccountDAO {

    public Account login(String username, String password) {

        
        try {
            String sql = "select * from tblUsers where fullName = ? and password = ?";
            Connection conn = new DBUtils().getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Account acount = Account.builder()
                        .userID(rs.getInt(1))
                        .fullName(rs.getString(2))
                        .password(rs.getString(3))
                        .roleID(rs.getString(4))
                        .address(rs.getString(5))
                        .date(rs.getString(6))
                        .phone(rs.getString(7))
                        .email(rs.getString(8))
                        .status(rs.getBoolean(9))
                        .build();
                return acount;

            }
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
