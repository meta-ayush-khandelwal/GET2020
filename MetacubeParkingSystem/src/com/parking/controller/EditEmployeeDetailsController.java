package com.parking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parking.dao.EmployeeDao;
import com.parking.pojo.Employee;

@WebServlet("/EditEmployeeDetailsController")
public class EditEmployeeDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    
    public EditEmployeeDetailsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));
		Employee employee = EmployeeDao.getEmployeeDetails(empId);
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));
		String fullName = request.getParameter("FullName");
		String gender = request.getParameter("Gender");
		String contact = request.getParameter("Contact");
		String organization = request.getParameter("Organization");
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setFullName(fullName);
		employee.setGender(gender);
		employee.setContact(contact);
		employee.setOrganization(organization);
		EmployeeDao.editEmployeeDetails(employee);
		request.getRequestDispatcher("employeeHome.jsp").forward(request, response);
	}

}
