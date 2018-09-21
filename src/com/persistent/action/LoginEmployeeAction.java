package com.persistent.action;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.persistent.bean.Employee;
import com.persistent.service.EmployeeService;

public class LoginEmployeeAction extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out
				.println("Entered in OnServletLogin and values are -- " + req);


		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		String user_id = req.getParameter("emp_id");
		String pass = req.getParameter("password");

		EmployeeService employeeService = new EmployeeService();
		List<Employee> employeeList = employeeService
				.getEmployeeDetails(user_id);
		for (Employee employee : employeeList) {
			if (user_id.equals(employee.getEmpId())
					&& pass.equals(employee.getPassword())) {

				HttpSession session = req.getSession();
				session.setAttribute("emp_id", user_id);
				// setting session to expiry in 30 mins
				session.setMaxInactiveInterval(30 * 60);

				pw.println("Login Success...!");
				Cookie loginCookie = new Cookie("emp_id", user_id);
				// setting cookie to expiry in 30 mins
				loginCookie.setMaxAge(30 * 60);
				res.addCookie(loginCookie);

				String encodedURL = res.encodeRedirectURL("CheckoutPage.jsp");
				res.sendRedirect(encodedURL);

			} else {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/login.html");
				PrintWriter out = res.getWriter();
				out.println("<center><h1><font color=green>Either employee id or password is wrong.</font></h1></center>");
				rd.include(req, res);

				pw.close();
			}
		}

	}

}