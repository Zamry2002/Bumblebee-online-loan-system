
package com.my.webappbumblebee.manage;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.my.webappbumblebee.manage.ProductDAO;
import com.my.webappbumblebee.manage.Product;

public class ProductAccess {
    public void addNew(Product product){
        try {
            PreparedStatement ps =ProductDAO.getPreparedStatement("insert into products values(?,?,?)");
            ps.setString(1,product.getName());
            ps.setString(2,product.getPrice());
            ps.setString(3,product.getDescription());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    public static List<Product> getaAll(){
        List<Product> ls = new LinkedList<>();
        
        try {
            ResultSet rs = ProductDAO.getPreparedStatement("select* from products").executeQuery();
            while(rs.next()){
                Product product = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                ls.add(product);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return ls;
        
    }
    }
    

