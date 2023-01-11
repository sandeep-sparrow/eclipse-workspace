<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Confirmation Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/my-test.css">
<link type="image/png" sizes="16x16" rel="icon" 
	href="${pageContext.request.contextPath}/resources/images/spring-confirm.png">
</head>
<body>
	<p>
	 	The Customer is confirmed: ${customer.firstName} ${customer.lastName}
	 	<br><br>
	 	Free Passes: ${customer.freePasses}
	 	<br><br>
	 	Post Code: ${customer.postalCode}
	 	<br><br>
	 	Course Code: ${customer.courseCode}
	</p>
</body>
</html>