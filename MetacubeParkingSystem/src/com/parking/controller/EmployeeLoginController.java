package com.parking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parking.dao.EmployeeDao;

@WebServlet("/EmployeeLoginController")
public class EmployeeLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeLoginController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(EmployeeDao.check(email, password))
		{
			HttpSession session=request.getSession();
			session.setAttribute("Email", email);
			response.sendRedirect("employeeHome.jsp");
		}
		else
		{
			String message = "Invalid Email or Password";
			request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
	}
}
