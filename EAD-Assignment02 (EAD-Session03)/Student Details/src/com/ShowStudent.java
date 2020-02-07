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

/**
 * Servlet implementation class ShowStudent
 */
@WebServlet("/ShowStudent")
public class ShowStudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Connection con = DatabaseConnection.initializeDatabase();

			PreparedStatement stmt = con.prepareStatement("select * from students");
			response.setContentType("text/html");
			ResultSet rst = stmt.executeQuery();
			PrintWriter out = response.getWriter();
			out.flush();
			out.print("<table width=25% border=1 border-collapse=collapse align=center>");

			out.print("<center><h1>Students</h1></center>");
			out.print("<tr>");
			out.print("<td>Student ID</td>");
			out.print("<td>First Name</td>");
			out.print("<td>Last Name</td>");
			out.print("<td>Father Name</td>");
			out.print("<td>E-mail</td>");
			out.print("<td>Class</td>");
			out.print("<td>Age</td><td>Action</td></tr>");
			while (rst.next()) {
				String studentID = rst.getString(1);
				String firstName = rst.getString(2);
				String lastName = rst.getString(3);
				String fatherName = rst.getString(4);
				String email = rst.getString(5);
				String studentClass = rst.getString(6);
				String age = rst.getString(7);

				out.print("<tr>");
				out.print("<td >" + rst.getString(1) + "</td>");
				out.print("<td >" + rst.getString(2) + "</td>");
				out.print("<td >" + rst.getString(3) + "</td>");
				out.print("<td >" + rst.getString(4) + "</td>");
				out.print("<td >" + rst.getString(5) + "</td>");
				out.print("<td >" + rst.getString(6) + "</td>");
				out.print("<td >" + rst.getString(7) + "</td>");
				out.print("<td><a href=UpdateStudent.html?studentID=" + studentID + "&firstName=" + firstName
						+ "&lastName=" + lastName + "&fatherName=" + fatherName + "&email=" + email + "&studentClass="
						+ studentClass + "&age=" + age + ">update</a></td>");
				out.print("</tr>");
			}

			out.print("</table>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
