/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.webappbumblebee.manage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.webappbumblebee.manage.SystemUser;
import com.my.webappbumblebee.manage.SystemUserDAO;


@WebServlet(name="/SystemUser")
public class SystemUserServlet extends HttpServlet {

             
       private SystemUserDAO systemuserDAO;

	public void init() {
		systemuserDAO = new SystemUserDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		SystemUser systemuser = new SystemUser();
		systemuser.setUsername(username);
		systemuser.setPassword(password);

		try {
			if (systemuserDAO.validate(systemuser)) {
				//HttpSession session = request.getSession();
				// session.setAttribute("username",username);
				response.sendRedirect("SystemUserHome.jsp");
			} else {
				HttpSession session = request.getSession();
				//session.setAttribute("user", username);
				response.sendRedirect("SytemUser.jsp");
			}
                        

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
                