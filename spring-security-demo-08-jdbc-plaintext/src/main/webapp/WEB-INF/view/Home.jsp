<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
		
		<!-- Step3: diaply user name and role -->
		<p>
			User: <security:authentication property="principal.username" />
			<br><br>
			Roles (s): <security:authentication property="principal.authorities" />
		</p>
		
		<hr>
		
		<security:authorize access="hasRole('MANAGER')">
			<!-- Add a link to point to /leaders... this is for managers -->
			<p>
				<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
				(only for Manager people)
			</p>
			<hr>
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">
			<!-- Add a link to point to /systems... this is for admins -->
			<p>
				<a href="${pageContext.request.contextPath}/systems">Admin area</a>
				(only for Admin people)
			</p>
			
		</security:authorize>
		
		<hr>
		
		<!-- Add a Logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			
			<input type="submit" value="logout"/>
		
		</form:form>
	
	</body>
	
</html>