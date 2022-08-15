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
import sample.dtos.Product;
import sample.utils.DBUtils;

/**
 *
 * @author 2
 */
public class ProductDAO {

    public List<Product> getAllProducts() {
        List<Product> listProducts = new ArrayList<>();
        try {
            String sql = "select * from tblProduct";
            
            Connection conn = new DBUtils().getConnection();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                Product product = Product.builder()
                        .productID(rs.getInt(1))
                        .productName(rs.getString(2))
                        .image(rs.getString(3))
                        .price(rs.getInt(4))
                        .quantity(rs.getInt(5))
                        .catagoryID(rs.getInt(6))
//                        .imporDate(rs.getString(7))
//                        .usingDate(rs.getString(8))
                        .build();
                listProducts.add(product);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return listProducts;           
    }

    public List<Product> getProductsByCategoryID(int categoryID) {
        List<Product> listProducts = new ArrayList<>();
        try {
            String sql = "select * from tblProduct where tblProduct.catagoryID = ? ";
            
            Connection conn = new DBUtils().getConnection();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryID);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                Product product = Product.builder()
                        .productID(rs.getInt(1))
                        .productName(rs.getString(2))
                        .image(rs.getString(3))
                        .price(rs.getInt(4))
                        .quantity(rs.getInt(5))
                        .catagoryID(rs.getInt(6))
//                        .imporDate(rs.getString(7))
//                        .usingDate(rs.getString(8))
                        .build();
                listProducts.add(product);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProducts;
    }

    public List<Product> search(String keyword) {
        List<Product> listProducts = new ArrayList<>();
        try {
            String sql = "select * from tblProduct where productName like ?";
            
            Connection conn = new DBUtils().getConnection();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" +keyword + "%");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                Product product = Product.builder()
                        .productID(rs.getInt(1))
                        .productName(rs.getString(2))
                        .image(rs.getString(3))
                        .price(rs.getInt(4))
                        .quantity(rs.getInt(5))
                        .catagoryID(rs.getInt(6))
//                        .imporDate(rs.getString(7))
//                        .usingDate(rs.getString(8))
                        .build();
                listProducts.add(product);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProducts;
    }

    public Product getProductById(int productId) {
        List<Product> listProducts = new ArrayList<>();
        try {
            String sql = "select * from tblProduct where productID = ?";
            
            Connection conn = new DBUtils().getConnection();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, productId);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                Product product = Product.builder()
                        .productID(rs.getInt(1))
                        .productName(rs.getString(2))
                        .image(rs.getString(3))
                        .price(rs.getInt(4))
                        .quantity(rs.getInt(5))
                        .catagoryID(rs.getInt(6))
//                        .imporDate(rs.getString(7))
//                        .usingDate(rs.getString(8))
                        .build();
                return product;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
        
    }
    }
    
    
    
    

