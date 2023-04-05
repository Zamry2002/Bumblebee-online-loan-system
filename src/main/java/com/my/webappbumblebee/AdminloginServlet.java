/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.webappbumblebee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.webappbumblebee.Adminlogin;
import com.my.webappbumblebee.AdminloginDAO;




@WebServlet("/login")
public class AdminloginServlet extends HttpServlet {
                
       private AdminloginDAO adminloginDAO;

	public void init() {
		adminloginDAO = new AdminloginDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Adminlogin adminlogin = new Adminlogin();
		adminlogin.setUsername(username);
		adminlogin.setPassword(password);

		try {
			if (adminloginDAO.validate(adminlogin)) {
				//HttpSession session = request.getSession();
				// session.setAttribute("username",username);
				response.sendRedirect("AdminHome.jsp");
			} else {
				HttpSession session = request.getSession();
				//session.setAttribute("user", username);
				response.sendRedirect("Admin.jsp");
			}
                        

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
                