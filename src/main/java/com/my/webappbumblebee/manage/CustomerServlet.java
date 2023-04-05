
package com.my.webappbumblebee.manage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.webappbumblebee.manage.ManageCustomerDAO;
import com.my.webappbumblebee.manage.Customercon;




@WebServlet("/")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ManageCustomerDAO managecustomerDAO;
    
    
    public CustomerServlet (){
        this.managecustomerDAO = new ManageCustomerDAO ();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          this.doGet(request, response);
  
    }// </editor-fold>

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
                
			switch (action) {
			case "/new":
				showNewForm(request,response);
				break;
			case "/insert":
                      {
                    try {
                        insertCustomer(request,response);
                       } catch (SQLException e) {
                        e.printStackTrace();
                     }
                 }
				break;
			case "/delete":
        {
            try {
                deleteCustomer(request , response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
				
				break;
			case "/edit":
        {
            try {
                showEditForm(request, response);
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
				break;
			case "/update":
        {         
            try {
                updateCustomer(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                            
				
				break;
			default:
        {
            try {
                //handle test
                listCustomer(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
				break;
	}
    }
    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Customercon> listCustomer = managecustomerDAO.selectAllCustomers();
		request.setAttribute("listCustomer", listCustomer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Customer-list.jsp");
		dispatcher.forward(request, response);
	}
  
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
		int Id = Integer.parseInt(request.getParameter("id"));
          String Full_name= request.getParameter("full_name");
          String Date_of_birth = request.getParameter("date_of_birth");
          String Email = request.getParameter("email");
          String Age= request.getParameter("age");
          String Gender= request.getParameter("gender");
          String Loan_balance = request.getParameter("loan_balance");
          String Used_amount = request.getParameter("used_amount");
          String Installment_plan = request.getParameter("installment_plan");
		Customercon customercon = new Customercon (Id,Full_name,Date_of_birth, Email,Age,Gender, Loan_balance, Used_amount, Installment_plan);
                managecustomerDAO.updateCustomer(customercon);
               response.sendRedirect("list");
               
	}
	
 
          private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		managecustomerDAO.deleteCustomer(id);
		response.sendRedirect("list");

	}
         private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Customercon existingCustomer = managecustomerDAO.selectCustomer(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Customer-form.jsp");
		request.setAttribute("customer", existingCustomer);
		dispatcher.forward(request, response);

	}

    private void showNewForm(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Customer-form.jsp");
        dispatcher.forward(request, response);
    } 
    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String Full_name= request.getParameter("full_name");
        String Date_of_birth = request.getParameter("date_of_birth");
        String Email = request.getParameter("email");
        String Age= request.getParameter("age");
        String Gender= request.getParameter("gender");
        String Loan_balance = request.getParameter("loan_balance");
        String Used_amount = request.getParameter("used_amount");
        String Installment_plan = request.getParameter("installment_plan");
		Customercon customercon = new Customercon (Full_name,Date_of_birth, Email,Age,Gender, Loan_balance, Used_amount, Installment_plan);
		managecustomerDAO.insertCustomer(customercon);
		response.sendRedirect("list");
	}
   
    
} 