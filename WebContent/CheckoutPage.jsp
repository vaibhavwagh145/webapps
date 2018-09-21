<%@ page import="com.persistent.service.EmployeeService"%>
<%@ page import="com.persistent.bean.Employee"%>
<%@ page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	max-width: 600px;
	min-height: 400px;
	margin: auto;
	color: green;
	text-align: center;
	font-family: arial;
}

.title {
	color: green;
	font-size: 18px;
}

button {
	border: none;
	outline: 0;
	display: inline-block;
	padding: 8px;
	color: white;
	background-color: #000;
	text-align: center;
	cursor: pointer;
	width: 100%;
	font-size: 18px;
}

a {
	text-decoration: none;
	font-size: 22px;
	color: black;
}

button:hover, a:hover {
	opacity: 0.7;
}
</style>
</head>
<body>
	<%
		String userName = null;
		userName = (String) session.getAttribute("emp_id");

		EmployeeService employeeService = new EmployeeService();
		List<Employee> employeeList = employeeService
				.getEmployeeDetails(userName);

		//allow access only if session exists
		if (session.getAttribute("emp_id") == null) {
			response.sendRedirect("login.html");
		} else {

			String sessionID = null;
			Cookie[] cookies = request.getCookies();

			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("emp_id"))
						userName = cookie.getValue();
				}
			}
		}
	%>


	<h2 style="text-align: center">Profile Details</h2>
	<form action="<%=response.encodeURL("LogoutServlet")%>" method="post">
		<div class="card">

			<%
				for (Employee employee : employeeList) {
			%>

			<h1><%=employee.getEmpId()%></h1>
			<p class="title"><%=employee.getName()%></p>
			<p><%=employee.getEmail()%></p>
			<p><%=employee.getPhoneNumber()%></p>
			<%
				}
			%>
			<p>
				<input type="submit" value="Logout">
			</p>
		</div>
	</form>

</body>
</html>
