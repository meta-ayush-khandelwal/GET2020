package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement stmt = con.prepareStatement("insert into students values (studentID,?,?,?,?,?,?)");
			String email=request.getParameter("email");
			stmt.setString(1, request.getParameter("firstName"));
			stmt.setString(2, request.getParameter("lastName"));
			stmt.setString(3, request.getParameter("fatherName"));
			stmt.setString(4, email);
			stmt.setString(5, request.getParameter("class"));
			stmt.setInt(6, Integer.valueOf(request.getParameter("age")));
			PrintWriter out = response.getWriter();
			
			if(isEmailExist(email)) {
				stmt.close();
				con.close();
				out.println("<html><body><b>Email Already Exist</b><br></body></html>");
				//response.sendRedirect("index.html");
				RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
		        rd.include(request, response);
		        out.close();
		        return;
			}
			stmt.executeUpdate();
			stmt.close();
			con.close();
			out.println("<html><body><b>Successfully Inserted</b><br></body></html>");
			//response.sendRedirect("index.html");
			RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
	        rd.include(request, response);
	        out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean isEmailExist(String email) {
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement stmt = con.prepareStatement("select studentID from students where email=?");
			stmt.setString(1, email);
			ResultSet rst = stmt.executeQuery();
			boolean flag=rst.next();
			return flag;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
