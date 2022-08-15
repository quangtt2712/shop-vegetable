/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.daos;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sample.dtos.Category;
import sample.utils.DBUtils;

/**
 *
 * @author 2
 */
public class CategoryDAO {

    public List<Category> getAllCategories() {
        List<Category> listCategories = new ArrayList<>();
        try {
            String sql = "select * from tblCategory";
            Connection conn = new DBUtils().getConnection();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
//                Category category = new Category(rs.getInt(1), rs.getString(2));
                Category category = Category.builder()
                        .catagoryID(rs.getInt(1))
                        .catagoryName(rs.getString(2))
                        .build();
                listCategories.add(category);
                
                
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCategories;
    }
    
}
