package com.my.webappbumblebee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.webappbumblebee.AdminproductCRUD;


public class AdminproductDAO {
    
    private static final String INSERT_PRODUCTS_STOCK_ADMIN_SQL = "INSERT INTO products_stock_admin " + 
    " (product_id, name, quality, price) VALUES (?, ?, ?, ?);";
    
    private static final String SELECT_PRODUCTS_STOCK_ADMIN_BY_NO = "SELECT no, product_id, name, quality, price FROM products_stock_admin WHERE no = ?";
    private static final String SELECT_ALL_PRODUCTS_STOCK_ADMIN = "SELECT * FROM products_stock_admin";
    private static final String DELETE_PRODUCTS_STOCK_ADMIN_SQL = "DELETE FROM products_stock_admin WHERE no = ?";
    private static final String UPDATE_PRODUCTS_STOCK_ADMIN_SQL = "UPDATE products_stock_admin SET product_id = ?, name = ?, quality = ?, price = ? WHERE no = ?";

    private final String jdbcURL;
    private final String jdbcUsername;
    private final String jdbcPassword;

    public AdminproductDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    AdminproductDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertProduct(AdminproductCRUD AdminproductCRUD) throws SQLException {
        System.out.println(INSERT_PRODUCTS_STOCK_ADMIN_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_STOCK_ADMIN_SQL)) {
            preparedStatement.setString(1, AdminproductCRUD.getProduct_id());
            preparedStatement.setString(2, AdminproductCRUD.getName());
            preparedStatement.setString(3, AdminproductCRUD.getQuality());
            preparedStatement.setString(4, AdminproductCRUD.getPrice());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public AdminproductCRUD selectProduct(int no) {
    AdminproductCRUD AdminproductCRUD  = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_STOCK_ADMIN_BY_NO);) {
            preparedStatement.setInt(1, no);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String productId = rs.getString("product_id");
                String name = rs.getString("name");
                String quality = rs.getString("quality");
                String price = rs.getString("price");
                AdminproductCRUD  = new AdminproductCRUD (no, productId, name, quality, price);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return AdminproductCRUD ;
    }

    public List<AdminproductCRUD > selectAllProducts() {
        List<AdminproductCRUD > products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS_STOCK_ADMIN);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int no = rs.getInt("no");
                String productId = rs.getString("product_id");
                String name = rs.getString("name");
                String quality = rs.getString("quality");
                String price = rs.getString("price");
                products.add(new AdminproductCRUD (no, productId, name, quality, price));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    public boolean deleteProduct(int no) throws SQLException {
        boolean rowDeleted;      
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS_STOCK_ADMIN_SQL);) {
            statement.setInt(1, no);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
   

     public boolean updateAdminproductCRUD (AdminproductCRUD AdminproductCRUD ) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCTS_STOCK_ADMIN_SQL);) {
            statement.setString(1, AdminproductCRUD .getProduct_id());
            statement.setString(2, AdminproductCRUD .getName());
            statement.setString(3, AdminproductCRUD .getQuality());
            statement.setString(4, AdminproductCRUD .getPrice());
            statement.setInt(5, AdminproductCRUD .getNo());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    
    
    

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
    

	public static String getSelectUserByNo() {
		return SELECT_PRODUCTS_STOCK_ADMIN_BY_NO ;
	}

	public static String getSelectProductsStockAdminByNo() {
		return SELECT_PRODUCTS_STOCK_ADMIN_BY_NO ;
	}

	public static String getDeleteProductsStockAdminSql() {
		return DELETE_PRODUCTS_STOCK_ADMIN_SQL;
	}

	public static String getUpdateProductsStockAdminSql() {
		return UPDATE_PRODUCTS_STOCK_ADMIN_SQL;
	}

	public static String getInsertProductsStockAdminSql() {
		return INSERT_PRODUCTS_STOCK_ADMIN_SQL;
	}

	public static String getSelectAllProductsStockAdmin() {
		return  SELECT_ALL_PRODUCTS_STOCK_ADMIN ;
	}

	public static void insertAdminproductCRUD(AdminproductCRUD newAdminproductCRUD) {
		// TODO Auto-generated method stub
		
	}

	

	public static void selectAdminproductCRUD(AdminproductCRUD newAdminproductCRUD) {
		// TODO Auto-generated method stub
		
	}

    void deleteAdminproductCRUD(int no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    AdminproductCRUD selectAdminproductCRUD(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
