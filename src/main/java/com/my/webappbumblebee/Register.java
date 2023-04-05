/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.webappbumblebee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.webappbumblebee.CustomerDAO;
import com.my.webappbumblebee.Customer;




@WebServlet("/register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private CustomerDAO customerDAO;
    
    public void init(){
     customerDAO = new CustomerDAO();
}
 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String Full_name= request.getParameter("full_name");
        String Date_of_birth = request.getParameter("date_of_birth");
        String Email = request.getParameter("email");
        String Age = request.getParameter("age");
        String Gender = request.getParameter("gender");
        String Loan_balance = request.getParameter("loan_balance");
        String Used_amount = request.getParameter("used_amount");
        String Installment_plan = request.getParameter("installment_plan");

        Customer customer = new Customer();
        customer.setFull_name(Full_name);
        customer.setDate_of_birth(Date_of_birth);
        customer.setEmail(Email);
        customer.setAge(Age);
        customer.setGender(Gender);
        customer.setLoan_balance(Loan_balance);
        customer.setUsed_amount(Used_amount);
        customer.setInstallment_plan(Installment_plan);
        

        try {
           customerDAO.registercustomer(customer);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         response.sendRedirect("Home.jsp");
}
}


   