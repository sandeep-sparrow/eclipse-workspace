<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

	<head>
	
		<meta charset="ISO-8859-1">
		
		<title>Luv2Code Custom Login</title>
		
		<style>
			.failed{
				color: red;
			}
		</style>
	
	</head>

	<body>
		
		<h3>My Custom Login Page</h3>
		
			<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
				<!-- check for login error -->
				<c:if test="${param.error != null}">
					<i class="failed">Sorry! Invalid User Name and Password</i>
				</c:if>
				<p>User Name: <input type="text" name="username"/></p>
				<p>Password : <input type="text" name="password"/></p>
				<input type="submit" value="login"/>
			</form:form>
	
	</body>

</html>