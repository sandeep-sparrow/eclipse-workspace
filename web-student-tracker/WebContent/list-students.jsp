<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*, com.luv2code.web.jdbc.*"  %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Student Tracker Application</title>
		<link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"
              media="screen"/>
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
        <link type="text/css" rel="stylesheet" href="css/style.css"/>
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Luv2Code University</h2>
			</div>
			
			<div id="container">
				<div id="content">
					<table border="1">
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email Address</th>
						</tr>
						<c:forEach var="tempStudent" items="${STUDENT_LIST}">
							<tr>
								<td>${tempStudent.firstName}</td>
								<td>${tempStudent.lastName}</td>
								<td>${tempStudent.email}</td>
							</tr>
						</c:forEach>		
					</table>
				</div>
			</div>
			<hr>
			<a href="/web-student-tracker">Home Page</a>
		</div>

	</body>
</html>