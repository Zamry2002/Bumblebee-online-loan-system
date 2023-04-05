
package com.my.webappbumblebee.manage;

import java.sql.PreparedStatement;


import com.my.webappbumblebee.manage.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ProductDAO {
    public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException{
        PreparedStatement ps =null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/bumblebeedb?allowPublicKeyRetrieval=true&useSSL=false";
        String username="root";
        String password="root";
        
        Connection con = DriverManager.getConnection(url,username,password);
        ps = con.prepareStatement(sql);
        
        return ps;
    }
    
}
    
    
    
 
   