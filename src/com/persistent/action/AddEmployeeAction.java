package com.persistent.action;

import com.persistent.service.EmployeeService;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmployeeAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, NumberFormatException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		System.out.println("Entered in AddEmployeeAction and values are -- "
				+ request.getParameterNames().toString());
		String name = request.getParameter("fname");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phone");
		
		String emp_id = request.getParameter("emp_id");
		String password = request.getParameter("password");
      
	
		EmployeeService employeeService = new EmployeeService();
		employeeService.addEmployee(emp_id, name, email, phoneNumber, password);
		pw.println("U have sucessfully registered");
		response.sendRedirect("login.html");
	}

}
