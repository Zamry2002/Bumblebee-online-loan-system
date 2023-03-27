package com.my.webappbumblebee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.webappbumblebee.CustomerInstallment;
import com.my.webappbumblebee.CustomerInstallmentDAO;


@WebServlet(name = "CustomerInstallmentServlet", urlPatterns = {"/CustomerInstallmentServlet"})
public class CustomerInstallmentServlet extends HttpServlet {

    private  CustomerInstallmentDAO CustomerInstallmentDAO;
    
    public void init() {
    	CustomerInstallmentDAO= new CustomerInstallmentDAO();
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 String  card_holder_name = request.getParameter("card_holder_name");
		 String  card_no = request.getParameter("card_no");
		 String  type= request.getParameter("type");
		 String  date= request.getParameter("date");
		 String  security_code= request.getParameter("security_code");
		
	     

	    CustomerInstallmentServlet customer = new CustomerInstallmentServlet();
	        customer.setCard_holder_name(card_holder_name); 
	        customer.setCard_no(card_no);
	        customer.setType(type);
	        customer.setDate(date);
	        customer.setSecurity_code(security_code);

	        try {
	        	CustomerInstallmentDAO.CustomerInstallment(customer);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        response.sendRedirect("payment_2.jsp");
		
		doGet(request, response);
	}


	private void setType(String type) {
		// TODO Auto-generated method stub
		
	}


	private void setSecurity_code(String security_code) {
		// TODO Auto-generated method stub
		
	}


	private void setDate(String date) {
		// TODO Auto-generated method stub
		
	}


	private void setCard_no(String card_no) {
		// TODO Auto-generated method stub
		
	}


	private void setCard_holder_name(String card_holder_name) {
		// TODO Auto-generated method stub
		
	}


}