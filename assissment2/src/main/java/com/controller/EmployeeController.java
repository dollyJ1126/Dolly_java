package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.bean.Employee;
import com.dao.EmployeeDAO;


public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private EmployeeDAO employeeDAO;

	    @Override
	    public void init() throws ServletException {
	        employeeDAO = new EmployeeDAO(); // Initialize the DAO here
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getParameter("action");

	        if ("add".equals(action)) {
	            Employee employee = new Employee();
	            employee.setFirstName(request.getParameter("firstName"));
	            employee.setLastName(request.getParameter("lastName"));
	            employee.setEmail(request.getParameter("email"));
	            employee.setMobile(request.getParameter("mobile"));
	            employee.setAddress(request.getParameter("address"));
	            employee.setGender(request.getParameter("gender"));
	            employee.setPassword(request.getParameter("password"));
	            employeeDAO.addEmployee(employee); // Now this should work
	            request.setAttribute("message", "Employee added successfully!");
	            request.getRequestDispatcher("index.jsp").forward(request, response);
	        } else if ("delete".equals(action)) {
	            int empId = Integer.parseInt(request.getParameter("empId"));
	            employeeDAO.deleteEmployee(empId);
	            response.sendRedirect("viewEmployees.jsp");
	        }

	    }
}
