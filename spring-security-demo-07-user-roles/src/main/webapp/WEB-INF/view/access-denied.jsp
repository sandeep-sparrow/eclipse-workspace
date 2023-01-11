<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
	<head>
	
		<meta charset="ISO-8859-1">
		<title>Luv2Code - Access Denied</title>
		
	</head>
	
	<body>

		<h2>Access Denied - You are not authorized to access this recourse</h2>
		
		<hr>
		
		<security:authorize access="hasRole('EMPLOYEE')">
			<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
		</security:authorize>
		
		
		<hr>
		
		<a href="${pageContext.request.contextPath}/showMyLoginPage">Back to Login Page</a>
		
	</body>
	
</html>