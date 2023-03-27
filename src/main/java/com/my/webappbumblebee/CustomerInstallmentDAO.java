package com.my.webappbumblebee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.my.webappbumblebee.CustomerInstallment;


public class CustomerInstallmentDAO {
    public int InstallmentCustomer(CustomerInstallment CustomerInstallmentDAO ) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO customer_installment_details" +
            "  (no,card_holder_name,card_no,credit_or_debit,date,security_code) VALUES " +
            " (?, ?, ?, ?, ?,?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/bumble_bee?useSSL=false", "root", "0opi03q");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, CustomerInstallmentDAO.getCard_holder_name());
            preparedStatement.setString(3, CustomerInstallmentDAO.getCard_no());
            preparedStatement.setString(4, CustomerInstallmentDAO.getType());
            preparedStatement.setString(5, CustomerInstallmentDAO.getDate());
            preparedStatement.setString(6, CustomerInstallmentDAO.getSecurity_code());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process  exception
            printSQLException(e);
        }
        return result;
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

    void CustomerInstallment(CustomerInstallmentServlet customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	

}
