<%@page import="com.AuthenticationService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	//Insert item---------------------------------- 
	if (request.getParameter("username") != null) { 
		AuthenticationService authService = new AuthenticationService(); 
		String stsMsg = authService.checkLogin(request.getParameter("username"), request.getParameter("password")); 
		session.setAttribute("statusMsg", stsMsg); 
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<form method="post" action="index.jsp">
		 Username : <input name="username" type="text"><br> 
		 Password : <input name="password" type="text"><br> 
		 <input name="btnSubmit" type="submit" value="Login"><br>
		 <%
 			out.print(session.getAttribute("statusMsg")); 
	 	 %>
	</form>
</body>
</html>