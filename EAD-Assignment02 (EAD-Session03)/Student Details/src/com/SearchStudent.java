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

@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement stmt;

			if (request.getParameter("class").toString().equalsIgnoreCase("None")) {
				stmt = con.prepareStatement("select * from students where firstName=? and lastName=?");
			} else {
				stmt = con.prepareStatement("select * from students where firstName=? and lastName=? and class=?");
				stmt.setString(3, request.getParameter("class"));
			}

			stmt.setString(1, request.getParameter("firstName"));
			stmt.setString(2, request.getParameter("lastName"));
			PrintWriter out = response.getWriter();

			out.print("<table  width=30% border=1 align=center>");
			out.print("<center><h1>Result:</h1></center>");

			ResultSet rst = stmt.executeQuery();

			out.print("<tr>");
			out.print("<td>Student ID</td>");
			out.print("<td>First Name</td>");
			out.print("<td>Last Name</td>");
			out.print("<td>Father Name</td>");
			out.print("<td>E-mail</td>");
			out.print("<td>Class</td>");
			out.print("<td>Age</td></tr>");

			while (rst.next()) {
				out.print("<tr>");
				out.print("<td>" + rst.getString(1) + "</td>");
				out.print("<td>" + rst.getString(2) + "</td>");
				out.print("<td>" + rst.getString(3) + "</td>");
				out.print("<td>" + rst.getString(4) + "</td>");
				out.print("<td>" + rst.getString(5) + "</td>");
				out.print("<td>" + rst.getString(6) + "</td>");
				out.print("<td>" + rst.getString(7) + "</td></tr>");
			}
			out.print("</table><br>");

			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
