<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*, com.luv2code.web.jdbc.*"  %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Student Tracker</title>
		<link type="image/png" sizes="16x16" rel="icon" 
	       href="images/jsp.png">
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
					<!-- Add Sudent Add in new button -->
					<input type="button" value="Add Student"
						onclick="window.location.href='add-student-form.jsp'; return false;"
						class="add-student-button" />
					<table border="1">
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email Address</th>
							<th>Action</th>
						</tr>
						<c:forEach var="tempStudent" items="${STUDENT_LIST}">
							<c:url var="updateLink" value="StudentControllerServlet">
								<c:param name="command" value="LOAD" />
								<c:param name="studentId" value="${tempStudent.id}" />
							</c:url>
							<c:url var="deleteLink" value="StudentControllerServlet">
								<c:param name="command" value="DELETE" />
								<c:param name="studentId" value="${tempStudent.id}" />
							</c:url>
							<tr>
								<td>${tempStudent.firstName}</td>
								<td>${tempStudent.lastName}</td>
								<td>${tempStudent.email}</td>
								<td>
									<a href="${updateLink}">Update</a>
									|
									<a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete Student?'))) return false">
									Delete</a>
								</td>
							</tr>
						</c:forEach>		
					</table>
				</div>
			</div>
			<hr>
			<input type="button" onclick="window.location.href='index.html'; return false;" 
				value="Home Page" class="home-page-button"/>
		</div>

	</body>
</html>