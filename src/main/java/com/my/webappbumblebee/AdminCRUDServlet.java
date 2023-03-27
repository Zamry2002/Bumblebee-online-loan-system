package com.my.webappbumblebee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.my.webappbumblebee.AdminDAO;
import com.my.webappbumblebee.AdminproductCRUD;
import java.util.List;


@WebServlet(name = "AdminCRUDServlet", urlPatterns = {"/AdminCRUDServlet"})
public class AdminCRUDServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	
	private AdminproductDAO AdminproductDAO;

    public void init() {
    	AdminproductDAO = new AdminproductDAO();
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        String action = request.getServletPath();
		        try {
		            switch (action) {
		                case "/new":
		                    showNewForm(request, response);
		                    break;
		                    
		                case "/insert":
		                    insertAdminproductCRUD(request, response);
		                    break;
		                    
		                case "/delete":
		                    deleteAdminproductCRUD(request, response);
		                    break;
		                    
		                case "/edit":
		                    showEditForm(request, response);
		                    break;
		                    
		                case "/update":
		                    updateUser(request, response);
		                    break;
		                    
		                default:
		                    listUser(request, response);
		                    break;
		            }
		        } catch (SQLException ex) {
		            throw new ServletException(ex);
		        }
		    }
	

		    private void listUser(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		    	
		        List < AdminproductCRUD > listAdminproductCRUD = AdminproductDAO.selectAllProducts();
		        request.setAttribute("listAdminproductCRUD", listAdminproductCRUD);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("admin_product_crud.jsp");
		        dispatcher.forward(request, response);
		        
		    }

		    
		    
		    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		    	
		        RequestDispatcher dispatcher = request.getRequestDispatcher("admin_product_crud.jsp");
		        dispatcher.forward(request, response);
		        
		    }
		    
		    

		    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		    	
		        int id = Integer.parseInt(request.getParameter("no"));
		        AdminproductCRUD existingUser = AdminproductDAO.selectAdminproductCRUD(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("admin_product_crud.jsp");
		        request.setAttribute("products", existingUser);
		        dispatcher.forward(request, response);
		        

		    }
		    
		    

		    private void insertAdminproductCRUD(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		    	
		        String product_id = request.getParameter("product_id");
		        String name = request.getParameter("name");
		        String quality = request.getParameter("quality");
		        String price = request.getParameter("price");
		        AdminproductCRUD newAdminproductCRUD = new AdminproductCRUD(product_id,name,quality,price);
		        AdminproductDAO.insertAdminproductCRUD(newAdminproductCRUD);
		        response.sendRedirect("list");
		        
		    }

		    private void updateUser(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		    	
		        int no = Integer.parseInt(request.getParameter("no"));
		        String product_id = request.getParameter("product_id");
		        String name = request.getParameter("name");
		        String quality = request.getParameter("quality");
		        String price = request.getParameter("price");

		        AdminproductCRUD product = new AdminproductCRUD(no,product_id,name,quality,price);
		        AdminproductDAO.updateAdminproductCRUD(product);
		        response.sendRedirect("list");
		        
		    }

		    private void deleteAdminproductCRUD(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		    	
		        int no = Integer.parseInt(request.getParameter("no"));
		       AdminproductDAO.deleteAdminproductCRUD(no);
		        response.sendRedirect("list");

		    }

}
