<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

	<head>
	
		<meta charset="ISO-8859-1">
		<title>Hello World! Luv2Code Company</title>
			
	</head>
	
	<body>
	
		<h2>Welcome to Sandeep's ThinkPad!</h2>
		
		<hr>
		
		<p>
			Welcome to the Luv2Code Company Home Page!
		</p>
		
		<!-- Add a Logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			
			<input type="submit" value="logout"/>
		
		</form:form>
	
	</body>
	
</html>