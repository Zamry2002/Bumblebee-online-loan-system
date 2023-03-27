/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.webappbumblebee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.my.webappbumblebee.AdminDAO;
import com.my.webappbumblebee.adminlogin;


/**
 *
 * @author ZAMRY
 */
@WebServlet("/login")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
         private AdminDAO AdminDAO;
	
public void init() {
	setAdminDAO(new AdminDAO());
}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");
        
        adminlogin adminlogin = new adminlogin();
        
        
        adminlogin.setUsername(username);
        adminlogin.setPassword(password);
        adminlogin.setConfirm_password(confirm_password);
       

        try {
            if (AdminDAO.validate(adminlogin)) {
                //HttpSession session = request.getSession();
                
                response.sendRedirect("Admin.jsp");
                
            } else {
                HttpSession session = request.getSession();
                
                response.sendRedirect("index.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
	}

	private void setAdminDAO(com.my.webappbumblebee.AdminDAO AdminDAO) {
		// TODO Auto-generated method stub
		
	}
}
        

