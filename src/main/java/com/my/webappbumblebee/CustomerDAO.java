package com.my.webappbumblebee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.my.webappbumblebee.Customer;




public class CustomerDAO {
    
    public int registercustomer(Customer customer) throws ClassNotFoundException {
        String INSERT_customer_SQL = "INSERT INTO customer" +
            "  (full_name,date_of_birth, email,age,gender, loan_balance, used_amount, installment_plan) VALUES " +
            " (?, ?, ?, ?,?,?,?,?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/bumblebeedb?useSSL=false", "root", "root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_customer_SQL )) {
            preparedStatement.setString(1, customer.getFull_name());
            preparedStatement.setString(2, customer.getDate_of_birth());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getAge());
            preparedStatement.setString(5, customer.getGender());
            preparedStatement.setString(6, customer.getLoan_balance());
            preparedStatement.setString(7, customer.getUsed_amount());
            preparedStatement.setString(8, customer.getInstallment_plan());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return result;
    }
}


   