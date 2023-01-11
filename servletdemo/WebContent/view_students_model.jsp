<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Student List MVC Demo</title>
		<link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"
              media="screen"/>
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
        <style>
        	th, td {
			  padding: 10px;
			}
        </style>
	</head>
	<body>
		<table border="1">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Address</th>
			</tr>
			<c:forEach var="tempStudent" items="${student_list}">
				<tr>
					<td>${tempStudent.firstName}</td>
					<td>${tempStudent.lastName}</td>
					<td>${tempStudent.email}</td>
				</tr>
			</c:forEach>		
		</table>
	</body>
</html>