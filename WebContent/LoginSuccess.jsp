
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success Page</title>
</head>
<body>
	<%
		//allow access only if session exists
		String emp_id = null;
		if (session.getAttribute("emp_id") == null) {
			response.sendRedirect("login.html");
		} else
			emp_id = (String) session.getAttribute("emp_id");
		String userName = null;
		String sessionID = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("emp_id"))
					userName = cookie.getValue();
				if (cookie.getName().equals("JSESSIONID"))
					sessionID = cookie.getValue();
			}
		} else {
			sessionID = session.getId();
		}
	%>
	<h3>
		Hi
		<%=userName%>, Login successful. Your Session ID=<%=sessionID%></h3>
	<br> User=<%= emp_id%>
	<br>
	<!-- need to encode all the URLs where we want session information to be passed -->
	<a href="<%=response.encodeURL("CheckoutPage.jsp")%>">Checkout Page</a>
	<form action="<%=response.encodeURL("LogoutServlet")%>" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>
