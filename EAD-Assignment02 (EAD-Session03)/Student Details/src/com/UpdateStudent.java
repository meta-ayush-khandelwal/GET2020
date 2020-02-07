package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement stmt = con.prepareStatement("UPDATE students SET firstName=? ,lastName=? ,fatherName=? ,class=? ,age=? where studentID=?");
			stmt.setString(1, request.getParameter("firstName"));
			stmt.setString(2, request.getParameter("lastName"));
			stmt.setString(3, request.getParameter("fatherName"));
			stmt.setString(4, request.getParameter("class"));
			stmt.setInt(5, Integer.valueOf(request.getParameter("age")));
			stmt.setInt(6, Integer.valueOf(request.getParameter("studentID")));
			stmt.executeUpdate();
			stmt.close();
			con.close();
			PrintWriter out = response.getWriter();
			out.println("<html><body><b>Successfully Updated</b><br></body></html>");

			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
