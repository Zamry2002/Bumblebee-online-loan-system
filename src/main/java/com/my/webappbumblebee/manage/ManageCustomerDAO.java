package com.my.webappbumblebee.manage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.my.webappbumblebee.manage.Customercon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ManageCustomerDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/bumblebeedb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_customer_SQL = "INSERT INTO customer" + " (full_name,date_of_birth, email, age, gender, loan_balance, used_amount, installment_plan) VALUES " +
            " ( ?, ?, ?, ?,?,?,?,?);";

	private static final String SELECT_customer_BY_ID = "select id,full_name,date_of_birth, email, age, gender, loan_balance, used_amount, installment_plan from customer where id =?";
	private static final String SELECT_ALL_customers = "select * from customer";
	private static final String DELETE_customer_SQL = "delete from customer where id = ?;";
	private static final String UPDATE_customer_SQL = "update customer set full_name = ?,date_of_birth= ?, email= ?,age=?, gender=?, loan_balance =?, used_amount=?, installment_plan= ? where id = ?;";

	public ManageCustomerDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
        
        //create or insert customer
        public void insertCustomer (Customercon customercon) throws SQLException {
            try(Connection connection =getConnection();
                     PreparedStatement preparedStatement = connection.prepareStatement(INSERT_customer_SQL)){
                    
            preparedStatement.setString(1, customercon.getFull_name());
            preparedStatement.setString(2, customercon.getDate_of_birth());
            preparedStatement.setString(3, customercon.getEmail());
            preparedStatement.setString(4, customercon.getAge());
            preparedStatement.setString(5, customercon.getGender());
            preparedStatement.setString(6, customercon.getLoan_balance());
            preparedStatement.setString(7, customercon.getUsed_amount());
            preparedStatement.setString(8, customercon.getInstallment_plan());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
	    e.printStackTrace();
        }
        }
            
 
        //update customer
        
        public boolean updateCustomer(Customercon customercon) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
		     PreparedStatement statement = connection.prepareStatement(UPDATE_customer_SQL);) {
	    statement.setString(1, customercon.getFull_name());
            statement.setString(2, customercon.getDate_of_birth());
            statement.setString(3, customercon.getEmail());
            statement.setString(4, customercon.getAge());
            statement.setString(5, customercon.getGender());
            statement.setString(6, customercon.getLoan_balance());
            statement.setString(7, customercon.getUsed_amount());
            statement.setString(8, customercon.getInstallment_plan());
            statement.setInt(9, customercon.getId());
            
	    rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
        

        //select customer by id
        
        public Customercon selectCustomer(int id) {
		Customercon customercon = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_customer_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String Full_name = rs.getString("full_name");
				String Date_of_birth = rs.getString("date_of_birth");
				String Email= rs.getString("email");
                                String Age= rs.getString("age");
                                String Gender= rs.getString("gender");
                                String Loan_balance= rs.getString("loan_balance");
                                String Used_amount= rs.getString("used_amount");
                                String Installment_plan= rs.getString("installment_plan");
                                        
				customercon = new Customercon(id,Full_name,Date_of_birth, Email,Age,Gender,Loan_balance,Used_amount,Installment_plan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customercon;
	}
        
        //select customers
        
        public List<Customercon> selectAllCustomers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Customercon> customers = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_customers);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String Full_name = rs.getString("full_name");
				String Date_of_birth = rs.getString("date_of_birth");
				String Email= rs.getString("email");
                                String Age= rs.getString("age");
                                String Gender= rs.getString("gender");
                                String Loan_balance= rs.getString("loan_balance");
                                String Used_amount= rs.getString("used_amount");
                                String Installment_plan= rs.getString("installment_plan");
				customers.add(new Customercon(id,Full_name,Date_of_birth, Email,Age,Gender,Loan_balance,Used_amount,Installment_plan));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}
        
      
        //delete customer
        
        public boolean deleteCustomer(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_customer_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
     
        
}
